package swap;

public class TestSwapObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNumber num1 = new MyNumber(1);
		MyNumber num2 = new MyNumber(2);
		TestSwapObject test = new TestSwapObject();
		test.changeAndSwap(num1, num2);
		System.out.println(num1+" - "+num2);

	}
	
	public void swap(MyNumber num1, MyNumber num2){
		MyNumber temp = num1;
		num1 = num2;
		num2 = temp;
	}
	
	public void changeAndSwap(MyNumber num1, MyNumber num2){
		num1.number = num1.number + 10;
		num2.number = num2.number + 10;
		MyNumber temp = num1;
		num1 = num2;
		num2 = temp;
	}

}
