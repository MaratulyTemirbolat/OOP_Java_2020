
import java.io.Serializable;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
/**
 */
public class Teacher extends Employee implements DeletingMessage,Serializable {
	/**
	 */
	private POSITION position;
	/**
	 */
	private FACULTY attachedFaculty;
	/**
	 */
	private HashMap<Course,Vector<Student>> courses;
	/**
	 */
	private Vector<Message> allMessages;
	
	/**
	 * @return 
	 */
	public Teacher() {
		super();
	}
	public Teacher(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber,POSITION position,FACULTY attachedFaculty) {
		super(name,surname,middleName,login,password,id,restoreAnswer,salary,hireDate,insuranceNumber);
		courses = new HashMap<Course,Vector<Student>>();
		allMessages = new Vector<Message>();

	}
	public void setFaculty(FACULTY attachedFaculty) {
		this.attachedFaculty = attachedFaculty;
	}
	public FACULTY getFaculty() {
		return attachedFaculty;
	}
	public HashMap<Course,Vector<Student>> getCourses(){
		return courses;
	}
	public void setPosition(POSITION position) {
		this.position = position;
	}
	
	/**
	 * @param student 
	 * @param course 
	 * @param mark 
	 */
	private Attestation getStudentAttestation(Course course, Student student) {
		Attestation currentAttestation = null;
		for(HashMap.Entry<Course,Attestation> entry : student.viewTranscript().getAllCoursesMarks().entrySet()){
			Course key = entry.getKey();
			Attestation value = entry.getValue();
			if(key.equals(course)) {
				currentAttestation = value;
				break;
			}
		}
		return currentAttestation;
	}
	public void putPointsToFirstAttestation(Course course,Student student,double points) {
		Attestation attestation = getStudentAttestation(course,student);
		attestation.addPointToFirstAttestation(points);
	}
	public void putPointsToSecondAttestation(Course course,Student student, double points) {
		Attestation attestation = getStudentAttestation(course,student);
		attestation.addPointToSecondAttestation(points);
	}
	public void putPointsToFinalExam(Course course, Student student, double points) {
		Attestation attestation = getStudentAttestation(course,student);
		attestation.setFinalPoints(points);
	}
	
	
	/**
	 * @return 
	 */
	public void viewBiggestStudentMarkForCourse(Vector<Student> courseStudents,Course course) {
		double highestMark = 0;
		Student st = null;
		for(Student student:courseStudents) {
			if(highestMark<student.getAttestation(course).getTotalAttestation().getPoints() && student.getAttestation(course).getTotalAttestation()!=null) {
				highestMark = student.getAttestation(course).getTotalAttestation().getPoints();
				st = student;
			}
		}
		System.out.println("The highest mark for the " + course.getName() + " has " + st.getName() + " " + highestMark);
	}
	public void viewAverageMarkForTheCourse(Vector<Student> courseStudents,Course course) {
		double totalMark = 0;
		double cnt = 0;
		for(Student student:courseStudents) {
			if(student.getAttestation(course).getTotalAttestation()!=null) {
				totalMark+=student.getAttestation(course).getTotalAttestation().getPoints();
			
			}
			cnt++;
		}
		double averageMark = totalMark/cnt; 
		System.out.println("The average point is " + averageMark);
	}
	public void viewLowestStudentMarkForCourse(Vector<Student> courseStudents,Course course) {
		double lowestMark = 10000;
		Student st = null;
		for(Student student:courseStudents) {
			if(lowestMark>student.getAttestation(course).getTotalAttestation().getPoints() && student.getAttestation(course).getTotalAttestation()!=null) {
				lowestMark = student.getAttestation(course).getTotalAttestation().getPoints();
				st = student;
			}
		}
		System.out.println("The lowest mark for the " + course.getName() + " has " + st.getName() + " " + lowestMark);
	}
	public void viewMarksReport(Course course) {
		Vector<Student> courseStudents = viewStudentsOnCourse(course);
		if(courseStudents != null) {
			viewBiggestStudentMarkForCourse(courseStudents,course);
			viewLowestStudentMarkForCourse(courseStudents,course);
			viewAverageMarkForTheCourse(courseStudents,course);
		}
		else {
			System.out.println("Sorry there is no such course!");
		}
		
	}
	/**
	 * @param file 
	 * @param course 
	 * @return 
	 */
	public boolean uploadCourseFile(Course course, CourseFile file) {
		return course.getCourseFiles().add(file); 
	}
	/**
	 * @param file 
	 * @param course 
	 * @return 
	 */
	public boolean deleteCourseFile(Course course, CourseFile file) {
		return course.getCourseFiles().remove(file);
	}
	/**
	 * @param course 
	 * @return 
	 */
	public Vector<Student> viewStudentsOnCourse(Course course) {
		for(HashMap.Entry<Course,Vector<Student>> entry : courses.entrySet()) {
			Course key = entry.getKey();
			Vector<Student> value = entry.getValue();
			if(key.equals(course))
				return value;
		}
		return null;
	}
	/**
	 * @return 
	 */
	public Vector<Course> viewCourses() {
		Vector<Course> curCourses = new Vector<Course>();
		for(Course course : courses.keySet()) {
			curCourses.add(course);
		}
		return curCourses;
	}
	/**
	 * @param course 
	 */
	public void viewStudentsInformation(Student student) {
		System.out.println(student);
	}
	
	/**
	 * @return 
	 */
	public String toString() {
		return super.toString();
	}
	/**
	 * @param o 
	 * @return 
	 */
	public POSITION getPosition() {
		return position;
	}
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Teacher))
			return false;
		Teacher teacher = (Teacher)o;
		return  super.equals(teacher) && this.attachedFaculty.equals(teacher.getFaculty()) && this.position.equals(teacher.getPosition()) ;
	}
	/**
	 * @return 
	 */
	public int hashCode() {
		int result = super.hashCode();
		result += 31*attachedFaculty.hashCode();
		result += 31*position.hashCode();
		return result;
	}
	/**
	 * @param o 
	 * @return 
	 */
	public int compareTo(User o) {
		Teacher teacher = (Teacher)o;
		if(this.courses.size() > teacher.courses.size())
			return 1;
		if(this.courses.size() < teacher.courses.size())
			return -1;
		return 0;
	}
	public Vector<Message> obtainUnreadMessages(){
		Vector<Message> unreadMessages = new Vector<Message>();
		for(Message message : allMessages) {
			if(!message.getIsRead())
				unreadMessages.add(message);
		}
		return unreadMessages;
	}
	public void readMessage(Message message) { // подумать в использовании
		message.readMessage();
	}
	public void deleteMessage(Message message) {
		allMessages.remove(message);
	}
	public Vector<Message> viewAllMessages(){
		return allMessages;
	}
	/**
	 * @param teacher 
	 */
}

