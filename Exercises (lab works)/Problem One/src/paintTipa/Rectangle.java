package paintTipa;

public class Rectangle extends Shape {
	Rectangle(){
		super();
	}
	Rectangle(Color color,int pos){
		super(color,pos);
	}
	public void draw() {
		 if(color == Color.BLACK)
			 System.out.println("[]"); 
		 if(color == Color.RED)
			 System.err.println("[]");
	}
	
}
