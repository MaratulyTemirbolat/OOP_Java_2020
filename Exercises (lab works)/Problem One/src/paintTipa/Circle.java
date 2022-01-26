package paintTipa;

public class Circle extends Shape {
	int diamet;
	Circle(){
		super();
	}
	Circle(Color color,int pos,int diamet){
		super(color,pos);
		this.diamet = diamet;
	}
 public void draw() {
	 if(color == Color.BLACK)
		 System.out.println("O"); 
	 if(color == Color.RED)
		 System.err.println("O");
 }
 public int retDiamet() {
	 return diamet;
 }
}
