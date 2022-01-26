package labTwoProbThree;

public class Queen extends Piece{
	Queen(){
	 super();
	}
	public boolean isLegalMove(Position a, Position b) {
		if(King.isLegalPositions(a, b) == false)
			return false;
		if(a.getVerticalCoordinate() == b.getVerticalCoordinate() &&(int)(a.getHorizontalCoordinate())==(int)(b.getHorizontalCoordinate()))
			return false;
		int lengthVertical = Math.abs((a.getVerticalCoordinate() - b.getVerticalCoordinate()));
		int lengthHorizontal = Math.abs((int)(a.getHorizontalCoordinate()) - (int)(b.getHorizontalCoordinate()));
		return (lengthVertical == lengthHorizontal) ||
				(a.getVerticalCoordinate() == b.getVerticalCoordinate())||
				((int)(a.getHorizontalCoordinate()) == (int)(b.getHorizontalCoordinate()));
	}
}
