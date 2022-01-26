package labTwoProbOne;

public class Sphere extends ThreeDShape{
	private double radius;
	public Sphere(){
	super();	
	}
	public Sphere(double radius) {
		this.radius = radius;
	}
	public double volume() {
		return (4.0/3.0)*Math.PI*radius*radius*radius;
	}
	public double surfaceArea() {
		return 4.0*(Math.PI)*radius*radius;
	}
	public double sectionalAreaThroughBase() {
		return (Math.PI)*radius*radius;
	}
}
