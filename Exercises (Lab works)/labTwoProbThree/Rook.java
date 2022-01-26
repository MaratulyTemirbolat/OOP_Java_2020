package labTwoProbThree;

public class Rook extends Piece{
	Rook(){
		super();
	}
	public boolean isLegalMove(Position a, Position b) {
		if(King.isLegalPositions(a, b) == false)
			return false;
		if(a.getVerticalCoordinate() == b.getVerticalCoordinate() &&(int)(a.getHorizontalCoordinate())==(int)(b.getHorizontalCoordinate()))
			return false;
		return (a.getVerticalCoordinate() ==b.getVerticalCoordinate()) || ((int)(a.getHorizontalCoordinate()) == (int)(b.getHorizontalCoordinate()));
	}
}
