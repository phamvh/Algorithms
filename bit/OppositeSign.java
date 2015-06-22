package bit;

public class OppositeSign {
	public static void main(String[] args) {
		System.out.println(haveOppositeSigns(3, 2));
		System.out.println(haveOppositeSigns(-1, 2));
		
		System.out.println(12&Integer.MAX_VALUE);
		System.out.println(25&Integer.MAX_VALUE);
		System.out.println(-1&Integer.MAX_VALUE);
	}

	/**
	 * Return true of x and y are of opposite signs (+ and -).
	 * The highest-order bit determines the sign in java: 1 means negative, 0 means non-negative.
	 * Therefore, if two numbers have different signs, the XOR will the highest-order bit equal 1, 
	 * and thus XOR is negative
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean haveOppositeSigns(int x, int y){
		return (x^y) < 0;
	}
}
