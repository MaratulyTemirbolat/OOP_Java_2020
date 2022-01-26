package examples;

//Interfaces can be used for classes which totally unrelated (CROSS CUTTING FUNCTIONALITY)
// Class --> extends Person and Animal

//Inheritance     Class 
public class Person implements Breathable{
	public void breathe(){
		System.out.println("The person is breathing");
	}
}
