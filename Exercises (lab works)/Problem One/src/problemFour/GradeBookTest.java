package problemFour;
import java.util.Scanner;
import weekTwo.Student;
import java.util.Vector;
public class GradeBookTest {

	public static void main(String[] args) {
		int s = (int) 'A';
		Course course = new Course("OOP","The best course to understand how to do big projects", 3,"PP2");
		Scanner sc = new Scanner(System.in);
		Vector<Student> students = new Vector<Student>();
		System.out.println("Please, input grades for students:");
		for(int k=0;k<10;k++) {
			System.out.print("Student "+(char)s + " :");
			double grade = sc.nextDouble();
			Student student = new Student((char)s +"",(char)s+(char)k+"",grade);
			students.add(student);
			GradeBook.classAverage+=grade;
			s++;
		}
		GradeBook gradeBook = new GradeBook(course,students);
		gradeBook.displayGradeReport();
		sc.close();
	}

}
