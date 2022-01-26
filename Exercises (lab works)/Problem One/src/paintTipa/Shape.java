package paintTipa;

public abstract class Shape {
	Color color;
	int pos;
	Shape(){
	}
	Shape(Color color,int pos){
		this.color = color;
		this.pos = pos;
	}
	abstract void draw();
	public void draw(int n) {
		for(int k=0;k<n;k++) {
			System.out.print(" ");
		}
		draw();
		
	}
}
