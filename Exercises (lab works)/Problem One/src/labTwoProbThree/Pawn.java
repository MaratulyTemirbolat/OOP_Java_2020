package labTwoProbThree;

public class Pawn extends Piece{
	Pawn(){
		super();
	}
	public boolean isLegalMove(Position a, Position b) {
		if(King.isLegalPositions(a, b) == false)
			return false;
		if(a.getVerticalCoordinate() == b.getVerticalCoordinate() &&(int)(a.getHorizontalCoordinate())==(int)(b.getHorizontalCoordinate()))
			return false;
		return (a.getVerticalCoordinate() ==2 && b.getVerticalCoordinate() ==4 &&(int)(a.getHorizontalCoordinate()) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() + 1 == b.getVerticalCoordinate() && (int)(a.getHorizontalCoordinate()) == (int)(b.getHorizontalCoordinate()));
	}
}
