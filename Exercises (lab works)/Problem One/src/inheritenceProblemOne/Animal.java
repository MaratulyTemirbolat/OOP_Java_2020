package inheritenceProblemOne;
import labThreeProbTwo.CanEatFood;
import labThreeProbTwo.CanBreathe;

public abstract class Animal implements CanEatFood,CanBreathe  {
	public int age;
	public String name = "";
	public EyeColor color;
	public Gender gender; 
	
	public Animal() {
	}
	public Animal(int age , String name,EyeColor color,Gender gender) {
		this.age = age;
		this.name = name;
		this.color = color;
		this.gender = gender;
	}
	public abstract void eatFood();
	public abstract void move();
	public abstract void voice();
	public void changeInfo(Gender gender) {
		this.gender = gender;
	}
	public void changeInfo(Gender gender, String name) {
		this.gender = gender;
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
