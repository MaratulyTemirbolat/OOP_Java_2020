package problemOne;

public class Student {
	private String name;
	private String id;
	private int yearOfStudy = 1;
	Student (){
		
	}
	Student(String name, String id){
		this.name = name;
		this.id = id;
	}
	String returnData() {
		return name + " " + id;
	}
	void incrementYearOfStudy() {
		yearOfStudy++;
	}
}
