package characters;

public class TestNumericValueOfChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1 = 'h';
		char c2 = 'i';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println((int)c1);
		System.out.println((int)c2);
		for(int i =0; i <=255; i++){
			System.out.println(i+" --- "+((char)i));
		}
	}

}
