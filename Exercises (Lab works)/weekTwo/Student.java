package weekTwo;

public class Student implements Comparable<Student> {
	private String name;
	private String id;
	static int yearOfStudy=1;
	public double mark;
	public Student(){
		
	}
	public Student(String name,String id, double mark){
		this.name = name;
		this.id = id;
		this.mark = mark;
	}
	
	public String getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int compareTo(Student o) {
		if(mark>o.mark)
			return 1;
		if(mark<o.mark)
			return -1;
		return 0;
	}
	public void incrementYearOfStudy() {
		yearOfStudy++;
	}
	public String toString() {
		return name;
	}
	
}
