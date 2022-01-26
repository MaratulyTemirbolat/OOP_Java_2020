package problemTwo;
import weekTwo.Student;
public class Register {
	Subjects subject;
	static int currentNumberOfStudentsOnMath;
	static int currentStudentsOnPhysics;
	static int totalStudents;
	final int MAX_AMOUNT_OF_THE_STUDENTS = 3;
	String nameOfTheStudent;
	String id;
	{
		currentNumberOfStudentsOnMath = 0;
		currentStudentsOnPhysics = 0;
	}
	Register(){
		totalStudents++;
	}
	Register(String nameOfTheStudent,Subjects subject){
		this();
		this.subject = subject;
		this.nameOfTheStudent = nameOfTheStudent;
		setSubject(this.nameOfTheStudent,this.subject);
	}
	Register(String nameOfTheStudent,Subjects subject,String id){
		this();
		this.subject = subject;
		this.nameOfTheStudent = nameOfTheStudent;
		this.id = id;
		setSubject(this.nameOfTheStudent, this.subject,this.id);
	}
	void setSubject(String nameOfTheStudent,Subjects subject) {
		if(subject == Subjects.MATHEMATICS && currentNumberOfStudentsOnMath +1<=MAX_AMOUNT_OF_THE_STUDENTS) {
			currentNumberOfStudentsOnMath++;
			totalStudents++;
			System.out.println("Student "+nameOfTheStudent +" is successfully registered on MATHEMATICS!" );
		}
		else if(subject == Subjects.PHYSICS && currentStudentsOnPhysics +1<=MAX_AMOUNT_OF_THE_STUDENTS) {
			currentStudentsOnPhysics++;
			totalStudents++;
			System.out.println("Student "+nameOfTheStudent +" is successfully registered on PHYSICS!" );
		}
		else {
			System.out.println("Sorry, but not available places!");
		}
	}
	void setSubject(String nameOfTheStudent,Subjects subject,String id) {
		if(subject == Subjects.MATHEMATICS && currentNumberOfStudentsOnMath +1<=MAX_AMOUNT_OF_THE_STUDENTS) {
			currentNumberOfStudentsOnMath++;
			totalStudents++;
			System.out.println("Student "+nameOfTheStudent +" with id "+ id + " is successfully registered on "+"Math!" );
		}
		else if(subject == Subjects.PHYSICS && currentStudentsOnPhysics +1<=MAX_AMOUNT_OF_THE_STUDENTS) {
			currentStudentsOnPhysics++;
			totalStudents++;
			System.out.println("Student "+nameOfTheStudent +" with id "+ id + " is successfully registered on "+"Physics!" );
		}
		else {
			System.out.println("Sorry, but not available places!");
		}
	}
	String getData() {
		return "Name of the student "+ nameOfTheStudent+ ". Student's ID is "+id;
	}
	
	
	
}
