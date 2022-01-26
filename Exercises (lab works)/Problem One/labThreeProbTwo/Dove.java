package labThreeProbTwo;

public class Dove implements Flyable,CanEatFish{
	Dove(){
		
	}
	public void eatFish() {
		System.out.println("The Dove is eating a fish");
	}
	public void fly() {
		System.out.println("The Dove is moving");
	}
	public void move() {
		System.out.println("The Dove is flying");
	}
}
