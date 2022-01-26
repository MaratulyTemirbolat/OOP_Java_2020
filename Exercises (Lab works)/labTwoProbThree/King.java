package labTwoProbThree;

public class King extends Piece {
	King(){
		super();
	}
	
	public boolean isLegalMove(Position a,Position b) {
		if(King.isLegalPositions(a, b) == false)
			return false;
		if(a.getVerticalCoordinate() == b.getVerticalCoordinate() &&(int)(a.getHorizontalCoordinate())==(int)(b.getHorizontalCoordinate()))
			return false;
		return (a.getVerticalCoordinate() +1 == b.getVerticalCoordinate() && 
				(int)(a.getHorizontalCoordinate()) ==(int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() -1 == b.getVerticalCoordinate() && 
				(int)(a.getHorizontalCoordinate()) ==(int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate()  == b.getVerticalCoordinate() && 
				((int)(a.getHorizontalCoordinate())+1) ==(int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate()  == b.getVerticalCoordinate() && 
				((int)(a.getHorizontalCoordinate())-1) ==(int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() + 1 == b.getVerticalCoordinate() && 
				((int)(a.getHorizontalCoordinate())+1) ==(int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() -1 == b.getVerticalCoordinate() && 
				((int)(a.getHorizontalCoordinate())-1) ==(int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() + 1 == b.getVerticalCoordinate() && 
				((int)(a.getHorizontalCoordinate())-1) ==(int)(b.getHorizontalCoordinate())) ||
				(a.getVerticalCoordinate() -1 == b.getVerticalCoordinate() && 
				((int)(a.getHorizontalCoordinate())+1) ==(int)(b.getHorizontalCoordinate()));
	}
}
