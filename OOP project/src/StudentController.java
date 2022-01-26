import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class StudentController extends UserController {
	Student student;
	public StudentController() {
		super();
	}
	public StudentController(Student student) {
		super(student);
		this.student = student;
	}
	public String getOptions() {
		return super.getOptions()+ "\n" +
				"8:View Transcript" + "\n" +
				"9:View Current courses" + "\n" +
				"10:View Current faculty" + "\n" +
				"11:View information about teacher" +"\n"+
				"12:Register for the subject" + "\n" + 
				"13:Exit";
	}
	public void doInterface(String choice) throws Exception {
		
		while(!super.option.equals("13")) {
			System.out.println(getOptions());
			super.option = super.in.readLine();
			String ch = option;
			super.doInterface(ch);
			if(super.option.equals("8")) {
				System.out.println(student.viewTranscript());
			}
			else if(super.option.equals("9")) {
				System.out.println(student.viewCurrentCourses());
			}
			else if(super.option.equals("10")) {
				if(student.getFaculty() == FACULTY.FIT) {
					System.out.println("Faculty of Information Technology");
				}
				if(student.getFaculty() == FACULTY.BS) {
					System.out.println("Business School");
				}
				if(student.getFaculty() == FACULTY.GF) {
					System.out.println("General Faculty");
				}
				if(student.getFaculty() == FACULTY.MCM) {
					System.out.println("Mathematical and Computer Modelling");
				}
			}
			else if(super.option.equals("11")) {
				viewInfoTeacher();
			}
			else if(super.option.equals("12")) {
				registerForTheSubject();
			}
			
		}	
	}
	public Course findSubject(String code) {
		for(Course subject: Data.getCourses()) {
			if(subject.equals(code)) {
				return subject;
			}
		}
		return null;
	}
	public void viewAllSubjects() {
		Vector<Course> courses = Data.getCourses();
				for(Course course:courses) {
				System.out.println(course.getName()+" "+course.getNumberOfCredits() + " " + course.getCode());
			}	
	}
	public void viewAllTeacher() {
		for(Teacher teacher:Data.getTeachers()) {
			System.out.println(teacher.getName() + " "+ teacher.getSurname()+" "+ teacher.getID());
		}
	}
	public Vector<Teacher> getAllTeachersOnTheSubject(Course cours) {
		Vector<Teacher> tea = new Vector<Teacher>();
		
		for(Teacher t: Data.getTeachers()) {
			if(t.getCourses().containsKey(cours)) {
				System.out.println(t.getName() + " "+ t.getSurname() + " ID "+ t.getID() +" "+ cours.getName());
				tea.add(t);
			}
		}
		return tea;
	}
	
	public void viewInfoTeacher() throws IOException {
		viewAllTeacher();
		System.out.println("\n"+"Please, write name of the teacher");
		String name = in.readLine();
		System.out.println("Please, write surname of the teacher");
		String surname = in.readLine();
		System.out.println("Please, write id of the teacher");
		String id = in.readLine();
		student.viewInfoAboutTeacher(name, surname, id);
	}
	public void registerForTheSubject() throws IOException {
		viewAllSubjects();
		System.out.println("Please type the code of the Subject");
		String codeSubject = in.readLine();
		Course c = null;
		for(Course co:Data.getCourses()) {
			if(co.getCode().equals(codeSubject)) {
				c = co;
			}
		}
		if(c == null) {
			System.out.println("Sorry. No such Course!");
			return;
		}
		Vector<Teacher> techer = getAllTeachersOnTheSubject(c);
		if(techer.size() == 0) {
			System.out.println("Sorry, no current teachers!");
			return;
		}
		System.out.println("Please,choose the teacher by ID");
		String idTeacher = in.readLine();
		Teacher te = null;
		for(Teacher t:techer) {
			if(t.getID().equals(idTeacher)) {
				te = t;
			}
		}
		if(te == null) {
			System.out.println("Sorry. No such Teacher!");
		}
		te.getCourses().get(c).add(student);
		student.registerForDiscipline(c);
	}
	
}
