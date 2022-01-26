package weekTwo;
import java.util.Vector;
import java.util.Collections;
public class Beginning {

	public static void main(String[] args) {
		Student stud1 = new Student("Temirbolat","18BD11",90.0);
		Student stud2 = new Student("Nazir","18BD11",100.0);
		Student stud3 = new Student("Ayan","18BD11",95.0);
		Vector<Student> students = new Vector<Student>();
		students.add(stud1);
		students.add(stud2);
		students.add(stud3);
		Collections.sort(students);
		System.out.println(students);
		
		Collections.sort(students, new NameComparator());
		
		System.out.println(students);
		
		PHDStudent phdst1 = new PHDStudent("Temi", "18BD",50.0,25);
		PHDStudent phdst2 = new PHDStudent("Naz", "18BD",50.0,40);
		PHDStudent phdst3 = new PHDStudent("hola", "18BD",40.0,25);
		Vector<PHDStudent> phds = new Vector<PHDStudent>();
		phds.add(phdst1);
		phds.add(phdst2);
		phds.add(phdst3);
		Collections.sort(phds);
		System.out.println(phds);
	}

}
