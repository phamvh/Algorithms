package bit;

public class IntToBinary {
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(0));
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println("max:"+Integer.toBinaryString(2147483647));
		System.out.println("min:"+Integer.toBinaryString(-2147483648));
	}
}
