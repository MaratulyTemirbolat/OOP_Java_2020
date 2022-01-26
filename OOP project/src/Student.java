import java.io.Serializable;
import java.lang.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;
/**
 */
public class Student extends User  {
	private int numberOfCredits;
	private int yearOfStudy;
	private FACULTY attachedFaculty;
	private Transcript transcript;
	private HashMap<Course,Attestation> currentCoursesMarks;
	private String specialty;
	public Student() {
		super();
	}
	public Student(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,int yearOfStudy, FACULTY attachedFaculty,String specialty) {
		super(name, surname,  middleName, login, password, id, restoreAnswer);
		this.yearOfStudy = yearOfStudy;
		this.attachedFaculty = attachedFaculty;
		transcript = new Transcript();
		currentCoursesMarks = new HashMap<Course,Attestation>();
		this.specialty = specialty;
		numberOfCredits = 0;
	}
	public Transcript viewTranscript() {
		return transcript;
	}
	public Attestation getAttestation(Course course) {
		for(Entry<Course, Attestation> entry :transcript.getAllCoursesMarks().entrySet()) {
			Course key = entry.getKey();
			Attestation value = entry.getValue();
			if(key.equals(course)) {
				return value;
			}
		}
		return null;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public FACULTY getFaculty() {
		return attachedFaculty;
	}
	public void setFaculty(FACULTY attachedFaculty) {
		this.attachedFaculty = attachedFaculty;
	}
	public HashMap<Course,Attestation> getCurrentCoursesMarks(){
		return currentCoursesMarks;
	}
	public Vector<Course> viewCurrentCourses() {
		Vector<Course> courses = new Vector<Course>();
		for(Course course:currentCoursesMarks.keySet()) {
			courses.add(course);
		}
		return courses;
	}

	public void viewInfoAboutTeacher(String name, String surname,String id) {
		Teacher teacher = Data.viewTeacher(name, surname, id);
		if(teacher !=null)
			System.out.println(teacher);
		else {
			System.out.println("Teacher is not found! Please check your input data");
		}
	}

	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String toString() {
		return super.toString() + " Year of Study is " + yearOfStudy +  " Specialty is " + specialty;
	}

	public int hashCode() {
		int result = super.hashCode();
		result+= 31*yearOfStudy;
		result+= 31*specialty.hashCode();
		return result;
	}
	public void registerForDiscipline(Course course) {
			if(transcript.getAllCourses().contains(course) == false) {
					if(numberOfCredits+course.getNumberOfCredits()<=21) {
						System.out.println("You are registerred for the " + course.getName());
						currentCoursesMarks.put(course, new Attestation());
						transcript.getAllCoursesMarks().put(course, new Attestation());
					}
					else {
						System.out.println("The number of credits exceeded!");
						return;
					}
				}
					
	}
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Student))
			return false;
		Student student = (Student)o;
		return this.yearOfStudy == student.yearOfStudy && this.specialty.equals(student.specialty) && super.equals(student);
	}
}

