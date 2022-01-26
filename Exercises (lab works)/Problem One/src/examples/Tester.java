package examples;

import java.util.Collections;
import java.util.Vector;



public class Tester {

	public static void main(String[] args) {
		Vector<Animal> animals = new Vector<Animal>();
		Animal a1 = new Dog("Dos",10, new Date(2020,13,4));
		Animal a2 = new Cat("Markiza", 14, new Date(2013,11,24));
		animals.add(a1);
		animals.add(a2);
		Collections.sort(animals,new NameComparator());
		Collections.sort(animals, new DateComparator());
	}
	
}
