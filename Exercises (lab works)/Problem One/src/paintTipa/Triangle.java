package paintTipa;

public class Triangle extends Shape {
	Triangle(){
		super();
	}
	Triangle(Color color,int pos){
		super(color,pos);
	}
	public void draw() {
		 if(color == Color.BLACK)
			 System.out.println("/\\"); 
		 if(color == Color.RED)
			 System.err.println("/\\");
	}
}
