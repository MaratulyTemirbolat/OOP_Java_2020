package labTwoProbThree;

public class Tester {

	public static void main(String[] args) {
		//CHECK CHESS POSITION LIKE e2-e3 or e 2 - e 3
		Piece piece = new King();
		System.out.println("All possible steps for King");
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('f',4)));
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('f',5)));
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('e',5)));
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('d',5)));
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('d',4)));
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('d',3)));
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('e',3)));
		System.out.println(piece.isLegalMove(new Position('e',4), new Position('f',3)));
	
	}

}
