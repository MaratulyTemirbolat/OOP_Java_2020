package labTwoProbThree;

public abstract class Piece {
	Piece(){
		
	}
	
	public abstract boolean isLegalMove(Position a,Position b);
	public static boolean isLegalPositions(Position a, Position b) {
		if(a.getVerticalCoordinate()<1 || a.getVerticalCoordinate()>8 ||
		b.getVerticalCoordinate()<1 || b.getVerticalCoordinate()>8 || 
		(int)(a.getHorizontalCoordinate())<94 || (int)(a.getHorizontalCoordinate())>104 ||
		(int)(b.getHorizontalCoordinate())<94 || (int)(b.getHorizontalCoordinate())>104) return false;
		return true;
	}
}
