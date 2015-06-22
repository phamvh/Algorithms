package bit;

public class BitRotation {
	
	public static void main(String[] args) {
		//rotateByOne();
		
		//System.out.println(Integer.SIZE);
		rotateByK(0b11000111, 3);
	}
	
	/**
	 * Make a circular shift k times
	 * Idea: 
	 *    Example (assume 8 bits for simplicity):
	 *      x = 11000001
	 *      k = 2;
	 *    if we shift x to the right by k=2, we will lose the two last bits, which are 01.
	 *    Now we need to put these two last bits to the beginning of x (after x has been shifted right k times)
	 *    Since x has been shifted rights, its left-most two bits are filled with ZERO.
	 *    So, we can simply shift the original x to the left by (8-k) times, then 01 will be at the left-most.
	 *    After this, we can just do OR to get the final rotation.  
	 * 
	 * 
	 * @param x
	 * @param k
	 */
	private static void rotateByK(int x, int k){
		int y = x >>> k;
		int z = x << (32-k); //move the last k bits to the left. 32 is the length of a binary representation for int
		int result = y|z;
		System.out.println(Integer.toBinaryString(result));
	}

	private static void rotateByOne() {
		/**
		 * Note that symbol 0b or 0B indicates that this is a binary representation of a number.
		 */
		int x = 0b100001;
		int y = x&1;
		x=x>>>1;
		if(y==1)
			x=x|Integer.MIN_VALUE;
		System.out.println(Integer.toBinaryString(x));
	}

}
