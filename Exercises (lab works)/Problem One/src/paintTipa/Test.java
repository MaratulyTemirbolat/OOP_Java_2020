package paintTipa;

import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		Vector<Shape> v = new Vector<Shape>();
		Circle circ = new Circle(Color.BLACK,5,9);
		Rectangle rec = new Rectangle(Color.RED,8);
		Triangle triang = new Triangle(Color.BLACK,10);
		v.add(circ);
		v.add(rec);
		v.add(triang);
		for(Shape shape :v) {
			shape.draw(shape.pos);
		}
	}

}
