package enum_related;

public enum Color{
	RED (1),
	GREEN (2),
	YELLOW (3);
	
	private int colorCode;
	Color(int colorCode){
		this.colorCode= colorCode;
	}
}
