package inheritenceProblemOne;

public class Cat extends Animal {
	public Cat() {
		super();
	}
	public Cat(int age, String name, EyeColor color,Gender gender) {
		super(age,name,color,gender);
	}
	public void eatFood() {
		System.out.println("Cat is eating wiscas");
	}
	public void move() {
		System.out.println("Cat is moving");
	}
	public void breathe() {
		System.out.println("The cat is breathing");
	}
	public void voice() {
		System.out.println("Mew");
	}
}
