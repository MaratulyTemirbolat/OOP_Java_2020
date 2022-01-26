package problemFive;

public class Person {
	Gender gen;
	String name = "";
	Person(){
		
	}
	Person(Gender gen){
		this.gen = gen;
	}
	Person(Gender gen, String name){
		this.gen = gen;
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
