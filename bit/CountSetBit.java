package bit;

public class CountSetBit {
	public static void main(String[] args) {
		System.out.println(countSetBits(1));
		System.out.println(countSetBits(2));
		System.out.println(countSetBits(3));
		System.out.println(countSetBits(4));
		System.out.println(countSetBits(-1));
		System.out.println(0x0F0F0F0F);
		System.out.println(0x0);
		System.out.println(0x1);
	}

	/**
	 * Count the number of 1-bits in a given integer x
	 * @param x
	 * @return
	 */
	public static int countSetBits(int x){
		//note that -1 is represented as all 1-bits
		//Simply check this fact by calling: Integer.toBinaryString(-1);
		int count=0;
		for(int i=0; i<32;i++){
			if(((x)&(1))==1)
				count++;
			x=x>>>1;
		}
		return count;
	}
}
