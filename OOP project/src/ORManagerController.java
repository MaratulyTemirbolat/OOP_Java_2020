import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class ORManagerController extends EmployeeController {
	ORManager manager;
	public ORManagerController(){
		super();
	}
	public ORManagerController(ORManager manager){
		super(manager);
		this.manager = manager;
	}
	public String getOptions() {
		return super.getOptions() + "\n"+
				"10:Send message to Teacher"+ "\n"+
				"11:Add Course to the system" + "\n"+
				"12:View student information" + "\n"+
				"13:View teacher information"+ "\n"+
				"14:Exit";
 	}
	public void doInterface(String choice) throws Exception {
		while(!super.option.equals("14")) {
		System.out.println(getOptions());
		super.option = super.in.readLine();
		super.doInterface(super.option);
		if(super.option.equals("10")) {
			sendMessageToTeacher();
		}
		else if(super.option.equals("11")) {
			addNewCourseToTheSystem();
		}
		else if(super.option.equals("12")) {
			viewStudentInfo();
		}
		else if(super.option.equals("13")) {
			viewStudentInfo();
		}
	}
}
	public void viewAllCourses() {
		for(Course cur: Data.getCourses()) {
			System.out.println(cur);
		}
	}
	public void addNewCourseToTheSystem() throws IOException {
		viewAllCourses();
		System.out.println("Please,type the name of new Course");
		String newName = in.readLine();
		if(manager.isCorrespondentData(newName) == false) {
			System.out.println("Sorry. Not this format");
			return;
		}
		System.out.println("Please type the number of Credits for the subject");
		int numberOfCredits = Integer.parseInt(in.readLine());
		if(numberOfCredits <= 0) {
			System.out.println("Sorry. Not this format");
			return;
		}
		System.out.println("Please, type the code for the Course");
		String code = in.readLine();
		if(manager.isCorrespondentData(code) == false) {
			System.out.println("Sorry. Wrong code");
			return;
		}
		for(Course course:Data.getCourses()) {
			if(course.getCode().equals(code)) {
				System.out.println("Sorry, this course already exists");
				return;
			}
		}
		
			Course newCourse = new Course(numberOfCredits,newName,code);
			manager.addNewCourseToTheSystem(newCourse);
			System.out.println("The course "+newName+" is successfully created");
	}

	public void viewAllTeachers() {
		for(Teacher teach: Data.getTeachers()) {
			System.out.println(teach.getName() + " " + teach.getSurname() + " " + teach.getID());
		}
	}
	public Teacher findTeacher() throws IOException {
		viewAllTeachers();
		System.out.println("Please type the name of the teacher!");
		String newName = in.readLine();
		System.out.println("Please type the surname of the teacher!");
		String newSurname = in.readLine();
		System.out.println("Please type the ID number of the teacher");
		String idNumber = in.readLine();
		return Data.viewTeacher(newName, newSurname, idNumber);
	}
	public void viewTeacherInfo() throws IOException {
		Teacher teacher = findTeacher();
		if(teacher!=null) {
			System.out.println(teacher);
		}
		else {
			System.out.println("Sorry, Teacher was not found. Please try again later!");
		}
	}
	public void viewAllStudents() {
		for(Student stud: Data.getStudents()) {
			System.out.println(stud.getName() + " "+stud.getSurname() + " " + stud.getMiddleName() + " "+stud.getID());
		}
	}
	public Student findStudent() throws IOException {
		viewAllStudents();
		System.out.println("Please type the ID number of the student!");
		String idNumber = in.readLine();
		User foundUser = Data.findUser(idNumber);
		if(foundUser instanceof Student) {
			return (Student)foundUser;
		}
		return null;
	}
	public void viewStudentInfo() throws IOException {
		Student student = findStudent();
		if(student != null) {
			System.out.println(student);
		}
		else {
			System.out.println("Sorry,but this student was not found!");
		}
	}
	
	public void sendMessageToTeacher() throws IOException {
		Teacher foundTeacher = findTeacher();
		if(foundTeacher!=null) {
			System.out.println("Please type the description of the message!");
			String description = in.readLine();
			Message message = new Message(new Date(),description,manager.getName());
			manager.sendMessageToTeacher(foundTeacher, message);
			System.out.println("The message is successfully sent");
		}
		else {
			System.out.println("Sorry Teacher not found! Please try again later!");
		}
	}
}
