package problemFour;
import weekTwo.Student;
import java.util.Vector;

public class GradeBook {
	Course course;
	Vector<Student> students;
	static double classAverage = 0;
	public double maxGrade = Double.MIN_VALUE;
	public double minGrade = Double.MAX_VALUE;
	public String nameWithHighestMark = "";
	public String nameWithLowestMark = "";
	public String[] arrayOfMarks;
	{
		arrayOfMarks = new String[]{
				"00-09:",
				"10-19:",
				"20-29:", 
				"30-39:",
				"40-49:",
				"50-59:",
				"60-69:",
				"70-79:",
				"80-89:",
				"90-99:",
				"100:"};
	}
	GradeBook(){
	}
	GradeBook(Course course,Vector<Student> students){
		this.course = course;
		this.students = students;
		for(Student st :this.students) {
			addStudentMark(st,st.mark);
		}
	}
	public void displayMessage() {
		System.out.println("Welcome to the grade book for GS101 " + course +" !");
	}
	public void lowestMark(double grade,String name,String id) {
		if(grade<=minGrade) {
			minGrade = grade;
			nameWithLowestMark = name + ","+" id:"+id;
		}
	}
	public void highestMark(double grade,String name,String id) {
		if(grade>=maxGrade) {
			maxGrade = grade;
			nameWithHighestMark = name+ "," + " id:" + id;
		}
	}
	public void addStudentMark(Student s,double grade) {
		lowestMark(grade,s.getName(),s.getID());
		highestMark(grade,s.getName(),s.getID());
		arrayOfMarks[(int)grade/10]+="*";
	}
	public double determineClassAverage() {
		double numberOfStudents = students.size();
		return classAverage/numberOfStudents;
	}
	public void outputBarChart() {
		for(int k=0;k<arrayOfMarks.length;k++) {
			System.out.println(arrayOfMarks[k]);
		}
	}
	public void displayGradeReport() {
		System.out.println("\n"+"Class average is " + determineClassAverage()+".");
		System.out.println("Lowest grade is " + minGrade + "(Student "+nameWithLowestMark+").");
		System.out.println("Highest grade is " + maxGrade + "(Student " + nameWithHighestMark+").");
		System.out.println("\n"+"Grades distribution: ");
		outputBarChart();
	}
	public String toString() {
		return nameWithHighestMark+maxGrade;
	}
}
