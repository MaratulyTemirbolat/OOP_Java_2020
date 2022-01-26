package problemFive;


public class Beginning {

	public static void main(String[] args) {
		Person p1 = new Person(Gender.BOY,"Subaru");
		Person p2 = new Person(Gender.BOY,"Temir");
		Person p3 = new Person(Gender.GIRL,"Rem");
		Person p4 = new Person(Gender.GIRL,"Ram");
		DragonLaunch dragon = new DragonLaunch();
		dragon.kidnap(p1);
		dragon.kidnap(p2);
		dragon.kidnap(p3);
		dragon.kidnap(p4);
		if(dragon.willDragonEatOrNot()) {
			System.out.println("dragon did not eat");
		}
		else
			System.out.println("dragon ate");
	}

}
