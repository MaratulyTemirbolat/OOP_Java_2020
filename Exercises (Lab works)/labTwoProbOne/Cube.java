package labTwoProbOne;

public class Cube extends ThreeDShape{
	private double lengthh;
	public Cube(){
		super();
	}
	public Cube(double lenghth) {
		this.lengthh = lenghth;
	}
	public double volume() {
		return (lengthh*lengthh*lengthh);
	}
	public double surfaceArea() {
		return (6.0*(lengthh*lengthh));
	}
	public double sectionalAreaThroughBase() {
		return lengthh*lengthh*(Math.sqrt(2.0));
	}
}
