package labTwoProbThree;

public class Knight extends Piece{
	Knight(){
		super();
	}
	public boolean isLegalMove(Position a,Position b) {
		if(King.isLegalPositions(a, b) == false)
			return false;
		if(a.getVerticalCoordinate() == b.getVerticalCoordinate() &&(int)(a.getHorizontalCoordinate())==(int)(b.getHorizontalCoordinate()))
			return false;
		return (a.getVerticalCoordinate() +2 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())+1) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() +2 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())-1) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() -2 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())+1) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() -2 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())-1) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() +1 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())+2) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() -1 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())+2) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() +1 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())-2) == (int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() -1 == b.getVerticalCoordinate() && ((int)(a.getHorizontalCoordinate())-2) == (int)(b.getHorizontalCoordinate()));
	}
}
