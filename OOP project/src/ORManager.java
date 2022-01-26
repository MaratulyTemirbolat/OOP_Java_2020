import java.io.Serializable;
import java.lang.*;
import java.util.*;
/**
 */
public class ORManager extends Employee implements Serializable {
	/**
	 */
	private FACULTY attachedFaculty;
	/**
	 * @param message 
	 */
	public ORManager() {
		super();
	}
	public ORManager(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber,FACULTY attachedFaculty) {
		super(name,surname,middleName,login,password,id,restoreAnswer,salary,hireDate,insuranceNumber);
		this.attachedFaculty = attachedFaculty;
	}
	public void sendMessageToTeacher(Teacher teacher, Message message) {
		teacher.viewAllMessages().add(message);
	}
	/**
	 * @param newCourse 
	 */
	public boolean addNewCourseToTheSystem(Course newCourse) {
		return Data.getCourses().add(newCourse);
	}
	
	
	/**
	 * @param student 
	 * @return 
	 */
	public String viewStudentInformatio(Student student) {
		return student.toString();
	}
	/**
	 * @param teacher 
	 * @return 
	 */
	public String viewTeacherInformation(Teacher teacher) {
		return teacher.toString();
	}
	/**
	 */
	
	
	public FACULTY getFaculty() {
		return attachedFaculty;
	}
	public void setAttachedFaculty(FACULTY faculty) {
		attachedFaculty = faculty;
	}
	/**
	 * @param teacher 
	 * @param subject 
	 * @param students 
	 */
	
	public String toString() {
		return super.toString() + " attached faculty : " + Data.detFaculty(attachedFaculty);
	}
	/**
	 * @param o 
	 * @return 
	 */
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof ORManager))
			return false;
		ORManager manager = (ORManager)o;
		return  super.equals(manager) && this.attachedFaculty.equals(manager.getFaculty()) ;
		
	}
	/**
	 * @return 
	 */
	public int hashCode() {
		int result = super.hashCode();
		result+=31*attachedFaculty.hashCode();
		return result;
	}
	/**
	 * @param o 
	 * @return 
	 */
		
}

