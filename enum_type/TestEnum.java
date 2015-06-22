package enum_type;

public class TestEnum {
	
	public enum Label {before, now, after};
	
	public static void printDay(Day day){
		System.out.println(day);
	}
	
	public static void printLabel(Label label){
		System.out.println(label);
	}
	

	public static void main(String[] args) {
		printDay(Day.monday);
		printLabel(Label.before);

	}

}
