import java.io.Serializable;
import java.lang.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Map;
import java.util.Vector;

public class Transcript implements Serializable, Cloneable,Comparable<Transcript>{
	private HashMap<Course,Attestation> allCoursesMarks;
	
	public Transcript() {
		allCoursesMarks = new HashMap<Course,Attestation>();
	}    
	public HashMap<Course,Attestation> getAllCoursesMarks(){
		return allCoursesMarks;
	}
	public double calculateTotalGpa() {
		double gradeWeight = 0;
		for(HashMap.Entry<Course,Attestation> entry : allCoursesMarks.entrySet()) {
			Course key = entry.getKey();
			Attestation value = entry.getValue();
			gradeWeight += (key.getNumberOfCredits()*value.getTotalAttestation().getGPA());
		}
		double numberOfCredits = calculateTotalNumberOfCredits();
		return (gradeWeight/numberOfCredits);
			}
	public double calculateTotalNumberOfCredits() {
		double numberOfCredits = 0;
		for(HashMap.Entry<Course,Attestation> entry : allCoursesMarks.entrySet()) {
			Course key = entry.getKey();
			numberOfCredits+=key.getNumberOfCredits();
		}
		return numberOfCredits;
	}
	public String toString() {
		for(HashMap.Entry<Course,Attestation> entry : allCoursesMarks.entrySet()) {
			Course key = entry.getKey();
			Attestation value = entry.getValue();
			Mark mark = value.getTotalAttestation();
			System.out.println(key.getCode() + " " + key.getName() + " " + key.getNumberOfCredits() + " " + value );
			
		}
		return "Total GPA is : " + calculateTotalGpa() + "\n" + "Total number of Credits : "+ calculateTotalNumberOfCredits();
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null ) 
			return false;
		if(!(o instanceof Transcript))
			return false;
		Transcript transcript = (Transcript) o;
		return allCoursesMarks.equals(transcript.allCoursesMarks);
	}

	public int hashCode() {
		int result = 17;
		result+=31*allCoursesMarks.hashCode();
		return result;
	}

	public void setCourses(HashMap<Course,Attestation> allCoursesMarks) {
		this.allCoursesMarks = allCoursesMarks;
	}

	public Vector<Course>  getAllCourses() {
		Vector<Course> courses = new Vector<Course>();
		for(Course course:allCoursesMarks.keySet()) {
			courses.add(course);
		}
		return courses;
	}
	public Object clone() throws CloneNotSupportedException {
		Transcript trans = (Transcript)super.clone();
		trans.allCoursesMarks = (HashMap)this.allCoursesMarks.clone();
		return trans;
	}
	@Override
	public int compareTo(Transcript o) {
		if(this.calculateTotalGpa() > o.calculateTotalGpa()) {
			return 1;
		}
		if(this.calculateTotalGpa() < o.calculateTotalGpa()) {
			return -1;
		}
		return 0;
	}
}