package inheritenceProblemTwo;
import labThreeProbTwo.Moveable;
import labThreeProbTwo.CanEatFish;
import labThreeProbTwo.Jumpable;

public abstract class Person implements Moveable,CanEatFish,Jumpable {
	private String name;
	private String address;
	public String surname = "";
	public Person(){
		
	}
	public abstract void jump();
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public void eatFish() {
		System.out.println("The person is eating a fish");
	}
	public void move() {
		System.out.println("The person is moving");
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
		return "Name = " + name + " , address =  " + address;
	}
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Person))
			return false;
		Person p = (Person)o;
		return this.address.equals(p.address) && p.name.equals(this.name);
	}
	public int hashCode() {
		int result = 17;
		result+=31*name.hashCode();
		result += 31*address.hashCode();
		return result;
		}
}
