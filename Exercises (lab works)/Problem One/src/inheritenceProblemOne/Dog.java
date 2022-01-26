package inheritenceProblemOne;

public class Dog extends Animal {
	int numberOffoots;
	String holderName;
	public Dog(){
		super();
	}
	
	public Dog(int age, String name, EyeColor color,int numberOffoots,Gender gender,String holderName) {
		super(age,name,color,gender);
		this.numberOffoots = numberOffoots;
		this.holderName = holderName;
	}
	public void voice() {
		System.out.println("Gav");
	}
	public void eatFood() {
		System.out.println("Dog is eating Pedigree");
	}
	public void move() {
		System.out.println("Dog is moving");
	}
	public void breathe() {
		System.out.println("The dog is breathing");
	}
	public boolean findPediGree() {
		return true;
	}
	public String toString() {
		return  super.toString() + " " + numberOffoots+"";
	}
	}
