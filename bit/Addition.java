package bit;

public class Addition {
	public static void main(String[] args) {
		System.out.println(add(2,3));
		System.out.println(add(4,9));
	}
	
	public static int add(int x, int y){
		/**
		 * Example:
		 *      x = 3 = 0*2^3 + 0*2^2 + 1*2^1 + 1*2^0
		 *      y = 2 = 0*2^3 + 0*2^2 + 1*2^1 + 0*2^0
		 *   bit order:     3       2       1       0
		 * bit value x: 0       0       1       1
		 * bit value y: 0       0       1       0       
		 */
		
		/**
		 * This xor has the meaning of adding x and y at the position where one bit is not 1.
		 * For example, for the bit order = 0, 1*2^0 + 0*2^0 = 1*2^0, therefore we can just write 1^0=1
		 * However, this does not work as adding, when both bits are 1
		 * For example, for the bit order = 1, 1*2^1 + 1*2^1 = 1*2^2 -->> the power increases by 1
		 * therefore, this new power, meaning the bit 1 of 2^2 needs to be carried to the left by 1 position
		 * That's why, the XOR only add x and y at the positions when at least one of the bits is not 1.
		 * To add x and y at the position when both the bits are 1, we need to carry (promote) this bit to the left
		 * by 1 position.
		 */
		int xor = x^y;
		/**
		 * This "carry" is when both the bits in x and y are 1, and thus when they are added together,
		 * they have the meaning of adding
		 */
		int carry = x&y; //positions where we need to carry the sum
		carry = carry << 1; //carry all the positions to the left by one position.
		
		/**
		 * After getting xor and carry, we need to to shift "carry" to the left by one position,
		 * and then add it to xor. This procedure repeats again, as two new operands are xor and carry.
		 * For simplicity, we assign "xor" back to x, and "carry" back to y to do the repetitions. 
		 */
		//this means, if carry = 0, there is no thing to carry b/c there are no position when both bits are 1.
		while(carry!=0){ 
			x = xor;
			y = carry;
			
			xor = x^y;
			carry=x&y;
			carry= carry << 1;
		}
		return xor;
	}

}
