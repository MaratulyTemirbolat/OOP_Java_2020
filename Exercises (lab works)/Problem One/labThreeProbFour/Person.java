package labThreeProbFour;

public class Person {
	private String name;

	public Person() {
		
	}
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "The name is " + name;
	}
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(!(o instanceof Person)) {
			return false;
		}
		Person person = (Person)o;
		return this.name.equals(person.name);
	}
}
