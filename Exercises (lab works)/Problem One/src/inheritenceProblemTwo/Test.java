package inheritenceProblemTwo;
import java.util.Vector;
public class Test {

	public static void main(String[] args) {
		//Person person = new Person("Temirbolat","Tole Bi 59");
		Student student = new Student("Eldjey", "Erzhanova 39", "PhD",1,25.47);
		Staff staff = new Staff("Nazerke", "Imanbaeva 11A","Nurmakov School",29000);
		Vector<Person> people = new Vector<Person>();
		//people.add(person);
		people.add(student);
		people.add(staff);
		for(Person human: people) {
			System.out.println(human);
		}
	}

}
