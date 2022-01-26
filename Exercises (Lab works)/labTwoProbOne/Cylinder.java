package labTwoProbOne;

public class Cylinder extends ThreeDShape {
	private double radius;
	private double height;
	public Cylinder(){
		super();
	}
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	public double volume() {
		return (Math.PI)*height*radius*radius;
	}
	public double surfaceArea() {
		return (2*Math.PI*radius*radius) + (2*Math.PI*radius*height);
	}
	public double sectionalAreaThroughBase() {
		return height*2.0*radius;
	}
}
