package problemFour;

public class Course {
	String name;
	String description;
	int numberOfCredits;
	String prerequisites;
	public Course(){
		
	}
	public Course(String name,String description,int numberOfCredits,String prerequisites) {
		this.name = name;
		this.description = description;
		this.numberOfCredits = numberOfCredits;
		this.prerequisites = prerequisites;
	}
	public String toString() {
		return description;
	}
}
