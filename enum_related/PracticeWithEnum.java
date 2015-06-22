package enum_related;

import java.util.EnumSet;

public class PracticeWithEnum {
	public static void main(String[] args) {
		for(Level level: Level.values()){
			System.out.println(level);
		}
		
		Level l1 = Level.high;
		Level l2 = Level.medium;
		Level l3 = Level.high;
		System.out.println(l1.compareTo(l2));
		System.out.println(l1.compareTo(l3));
		
		Color1 color = Color1.GREEN;
		Color1 anotherColor = Color1.YELLOW;
		System.out.println(color.getColorCode());
		System.out.println(anotherColor.getColorCode());
		
		
		EnumSet<Color> hue = EnumSet.of(Color.GREEN,Color.YELLOW);
		EnumSet<Color> gray = EnumSet.of(Color.RED,Color.GREEN);
		System.out.println(hue);
		System.out.println(gray);
		
		System.out.println("Content of hue is:");
		for(Color c : hue){
			System.out.print(c+" ");
		}
	}
}
enum Level{
	high, medium, low
}

enum Color1{
	RED (1),
	GREEN (2),
	YELLOW (3);
	
	private int colorCode;
	Color1(int code){
		colorCode = code;
	}
	
	public int getColorCode(){
		return colorCode;
	}
}

