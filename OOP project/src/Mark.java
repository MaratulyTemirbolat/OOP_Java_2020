import java.io.Serializable;
import java.lang.*;


public class Mark implements Cloneable, Serializable, Comparable<Mark>{
	private double points;
	private double gpa;
	
	public Mark() {
		
	}
	public Mark (double points) {
		this.points = points;
		gpa = 0.0;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public String toLetter() {
		if(points >= 95) 
			return "A";
		else if(points >=90 && points < 95 )
			return "A-";
		else if(points >= 85 && points < 90)
			return "B+";
		else if(points >= 80 && points< 85)
			return "B";
		else if(points >= 75 && points <80)
			return "B-";
		else if(points >= 70 && points <75)
			return "C+";
		else if(points >= 65 && points < 70)
			return "C";
		else if(points >= 60 && points < 65)
			return "Ñ-";
		else if(points >= 55 && points < 60)
			return "D+";
		else if(points >=50 && points <55)
			return "D";
		return "F";
	}

	public double getGPA() {
		if(toLetter().equals("A"))
			gpa = 4.0;
		if(toLetter().equals("A-"))
			gpa = 3.67;
		if(toLetter().equals("B+"))
			gpa = 3.33;
		if(toLetter().equals("B"))
			gpa = 3.0;
		if(toLetter().equals("B-"))
			gpa = 2.67;
		if(toLetter().equals("C+"))
			gpa = 2.33;
		if(toLetter().equals("C"))
			gpa = 2.0;
		if(toLetter().equals("C-"))
			gpa = 1.67;
		if(toLetter().equals("D+"))
			gpa = 1.33;
		if(toLetter().equals("D"))
			gpa = 1.0;
		if(toLetter().equals("F"))
			gpa = 0.0;
		return gpa;
	}

	public String toTraditionalMark() {
		if(getGPA() >= 3.67)
			return "Excellent";
		else if(getGPA() >=2.33 && getGPA() < 3.67)
			return "Good";
		else if(getGPA() >= 1.0 && getGPA() < 2.33)
			return "Satisfactory";
		return "Unsatisfactory";
	}

	public String toString() {
		return "Your points : " + points  + " Your GPA is " + getGPA();
	}

	public int hashCode() {
		int result = 17;
		result+= 31*points;
		return result;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Mark))
			return false;
		Mark mark = (Mark)o;
		return this.points == mark.points;
	}

	public int compareTo(Mark mark) { 
		if(this.points > mark.points) {
			return 1;
		}
		if(this.points < mark.points) {
			return -1;
		}
		return 0;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Mark mark = (Mark)super.clone();
		return mark;
	}

}