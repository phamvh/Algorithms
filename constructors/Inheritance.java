package constructors;

public class Inheritance {

	public static void main(String[] args) {
		B b = new B("");
		
	}
	
}
class A{
	public A() {
		System.out.println("A without args");
	}
	public A(String s) {
		System.out.println("A");
	}
}
class B extends A{
	public B(String s) {
		System.out.println("B");
	}
	

}