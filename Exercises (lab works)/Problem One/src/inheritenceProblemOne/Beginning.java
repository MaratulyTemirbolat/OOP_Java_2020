package inheritenceProblemOne;


public class Beginning {

	public static void main(String[] args) {
		Dog d = new Dog(10,"Veron",EyeColor.BROWN,4,Gender.BOY,"Temirbolat");
		Cat c = new Cat();
		feed(c);
	}
	public static void feed(Animal a) {
		System.out.println(a.toString());
		if(a.getClass().getName().equals("Dog")) {
			Dog dog = (Dog)a;
		   System.out.println(dog.findPediGree());
		}
	}
}
