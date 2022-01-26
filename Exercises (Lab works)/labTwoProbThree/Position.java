package labTwoProbThree;

public class Position {
	private char horizontalCoordinate;
	private int verticalCoordinate;
	
	Position(){
		
	}
	Position(char horizontalCoordinate,int verticalCoordinate){
		this.horizontalCoordinate = horizontalCoordinate;
		this.verticalCoordinate = verticalCoordinate;
	}
	public int getVerticalCoordinate() {
		return verticalCoordinate;
	}
	
	public char getHorizontalCoordinate() {
		return horizontalCoordinate;
	}
	
}
