import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class TeacherController extends EmployeeController {
	Teacher teacher;
	public boolean isOk = true;
	Student student = null;
	Course course = null;
	Student studennnnnnttt = null;
	Course cccc = null;
	public TeacherController() {
		super();
	}
	public TeacherController(Teacher teacher) {
		super(teacher);
		this.teacher = teacher;
	}
	public String getOptions() {
		return super.getOptions() + "\n"+
				"10:Get student attestation"+"\n"+
				"11:Put points for the Attestation" + "\n"+
				"12:Upload Course File"+ "\n"+
				"13:Delete Course File" + "\n"+
				"14:View Students list on the Course" + "\n"+
				"15:View Student information" + "\n"+
				"16:View Unread messages" + "\n" +
				"17:View Marks Report for the Course" + "\n"+
				"18:Take desired Course" + "\n"+
				"19:Exit";
	}
	public String getOptionsForAttestationMark() {
		return  "1:Put points for the First Attestation" + "\n"+
				"2:Put points for the Second Attestation" + "\n"+
				"3:Put points for the Final Exam";
		
	}
	public String getOptionsForTheMessage() {
		return "1:Read Message" + "\n"+
				"2:Delete Message" + "\n"
				+"3:Exit";
	}
	public void doInterface(String choice) throws Exception {
		while(!super.option.equals("19")) {
			System.out.println(getOptions());
			super.option = super.in.readLine();
			String opt = option;
			super.doInterface(opt);
			if(opt.equals("10")) {
				viewStudentAttestation();
			}
			else if(opt.equals("11")) {
				putPointsForTheAttestation();
			}
			else if(opt.equals("12")) {
				uploadCourseFile();
			}
			else if(opt.equals("13")) {
				deleteCourseFile();
			}
			else if(opt.equals("14")) {
				viewStudentListOnTheCourse();
			}
			else if(opt.equals("15")) {
				viewStudentInformation();
			}
			else if(opt.equals("16")) {
				viewUnreadMessages();
			}
			else if(opt.equals("17")) {
				viewMarksReport();
			}
			else if(opt.equals("18")) {
				takeCourse();
			}
		}
	}
	public void viewAllCourses() {
		Vector<Course> courses = Data.getCourses();
				for(Course course:courses) {
				System.out.println(course.getName() + " " + course.getCode());
			}	
	}
	public void takeCourse() throws IOException {
		if(Data.getCourses().size()==0) {
			System.out.println("Sorry. No Courses!");
			return;
		}
		viewAllCourses();
			System.out.println("Please type the code of the Course");
			String code = in.readLine();
			Course c = null;
			for(Course co:Data.getCourses()) {
				if(co.getCode().equals(code)) {
					c = co;
				}
			}
			if(c == null) {
				System.out.println("Sorry. No such Course!");
				return;
			}
			teacher.getCourses().put(c, new Vector<Student>());
			System.out.println("The course is taken");
	}
	public void viewUnreadMessages() throws IOException {
		for(Message curMessage: teacher.obtainUnreadMessages()) {
			boolean ok = true;
			while(ok) {
			System.out.println(curMessage);
			System.out.println(getOptionsForTheMessage());
			String reshenie = in.readLine();
			if(reshenie.equals("1")) {
				ok = false;
				teacher.readMessage(curMessage);
			}
			else if(reshenie.equals("2")) {
				ok =false;
				teacher.deleteMessage(curMessage);
			}
			else if(reshenie.equals("3")) {
				return;
			}
			}
		}
	}
	public void viewStudentInformation() throws IOException {
		Vector<Student> students = Data.getStudents();
		for(Student st:students) {
			System.out.println(st.getName() + " " + st.getSurname() + " " + st.getID());
		}
		System.out.println("Please type the ID number of the student");
		String idNumber = in.readLine();
		User stud = Data.findUser(idNumber);
		if(stud instanceof Student && stud!= null) {
			System.out.println((Student)stud);
		}
		else {
			System.out.println("Sorry there is no such student!");
		}
	}
	public void viewStudentListOnTheCourse() throws IOException {
		Course curs = findCourse();
		if(curs == null) {
			System.out.println("Sorry, there is no such course");
			return;
		}
		for(Student stud: teacher.viewStudentsOnCourse(curs)) {
			System.out.println(stud);
		}
		
	}
	public CourseFile isFileExist(Course curs,String name) {
		for(CourseFile courseFile:curs.getCourseFiles()) {
			if(courseFile.getName().equals(name)) {
				return courseFile;
			}
		}
		return null;
	}
	public void viewFiles(Course curs) {
		for(CourseFile curFile:curs.getCourseFiles()) {
			System.out.println(curFile.getName() + " " + curFile.getSize() + "mb");
		}
	}
	public void deleteCourseFile() throws IOException {
		viewSubjects();
		Course curs = findCourse();
		if(curs == null) {
			System.out.println("Sorry, no such course");
			return;
		}
		viewFiles(curs);
		System.out.println("Please,type the courseFile's name please");
		String courseFileName = in.readLine();
		CourseFile cursFile = isFileExist(curs,courseFileName);
		if(cursFile !=null) {
			teacher.deleteCourseFile(curs, cursFile);
			System.out.println("The file is deleted!");
			viewFiles(curs);
		}
		else {
			System.out.println("Sorry, there is no such file!");
		}
	}
	public void uploadCourseFile() throws IOException {
		Course curs = findCourse();
		if(curs==null) {
			System.out.println("Sorry, there is no such course");
			return;
		}
		System.out.println("Please, type the courseFile's name");
		String courseFileName = in.readLine();
		System.out.println("Please choose the type of the file from the list : 1.doc 2.pdf 3.ppt 4.zip");
		TYPE type = null;
		String courseType = in.readLine();
		if(courseType.equals("1")) {
			type = TYPE.DOC;
		}
		else if(courseType.equals("2")) {
			type = TYPE.PDF;
		}
		else if(courseType.equals("3")) {
			type = TYPE.PPT;
		}
		else if(courseType.equals("4")) {
			type = TYPE.ZIP;
		}
		else {
			System.out.println("Sorry there no another types. Please try again later.");
			return;
		}
		System.out.println("Please wite the size of the file in mb. No more than 90 mb");
		double fileSize = Double.parseDouble(in.readLine());
		if(fileSize>90.0) {
			System.out.println("Sorry file size is too big. Try later");
			return;
		}
		CourseFile newCourseFile = new CourseFile(fileSize,courseFileName,new Date(),type);
		teacher.uploadCourseFile(curs, newCourseFile);
		System.out.println("The file " + newCourseFile.getName() + " is successfully uploaded to the " + curs.getName() +" files");
		viewFiles(curs);
	}
	public Course findCourse() throws IOException {
		System.out.println("Please, type the Course's code ");
		String code = in.readLine();
		for(Course curCourse: teacher.viewCourses()) {
			if(curCourse.getCode().equals(code)) {
				 course = curCourse;
			}
		}
		return course;
	}
	public Student getStudentOnTheCourse(Vector<Student> students,String id) {
		for(Student st:students) {
			if(st.getID().equals(id)) {
				student = st;
			}
		}
		return student;
	}
	public void viewSubjects() {
		System.out.println("Your subjects:");
		for(Course c:teacher.viewCourses()) {
			System.out.println("  "+c.getName() + " "+c.getCode());
		}
	}
	public void viewMarksReport() throws IOException {
		viewSubjects();
		Course cour = findCourse();
		if(cour == null) {
			System.out.println("Sorry, there is no such Course");
			return;
		}
		teacher.viewMarksReport(cour);
	}
	public void viewStudentAttestation() throws IOException {
		viewSubjects();
		Course cour = findCourse();
		if(cour == null) {
			System.out.println("Sorry, there is no such Course");
			isOk = false;
			return;
		}
		cccc = cour;
		Vector<Student> students = teacher.viewStudentsOnCourse(course);
		System.out.println(students);
		System.out.println("Please type the ID of the Student");
		String studentID = in.readLine();
		Student stud = getStudentOnTheCourse(students,studentID);
		
		if(stud == null) {
			System.out.println("Sorry,there is no such Student on this course");
			isOk = false;
			return;
		}
		studennnnnnttt = stud;
		System.out.println(stud.getAttestation(cour));
	}
	public void putPointsForTheAttestation() throws IOException {
		viewStudentAttestation();
		if(isOk == false) {
			System.out.println("Error! Try again please!");
			isOk = true;
			return;
		}
		System.out.println("\n"  + getOptionsForAttestationMark());
		String selection = in.readLine();
		System.out.println("How many points do you want to add?");
		double points = Double.parseDouble(in.readLine());
		if(selection.equals("1")) {
			teacher.putPointsToFirstAttestation(course, student, points);
		}
		else if(selection.equals("2")) {
			teacher.putPointsToSecondAttestation(course, student, points);
		}
		else if(selection.equals("3")) {
			teacher.putPointsToFinalExam(course, student, points);
		}
		else if(!selection.equals("1") && !selection.equals("2") && !selection.equals("3")) {
			System.out.println("There is no such option. Please try again later!");
			return;
		}
		System.out.println("The Points are successfully uploaded!");
	}
}
