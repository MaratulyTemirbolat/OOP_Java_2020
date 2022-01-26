import java.io.Serializable;
import java.lang.*;
public class Pair implements Serializable {

private Object partOne;

private Object partTwo;

public Pair() {
	
}
public Pair(Object partOne,Object partTwo) {
	setPartOne(partOne);
	setPartTwo(partTwo);
}

public Object getPartOne() {
    return partOne;
}
public void setPartOne(Object partOne) {
	if(partOne instanceof String)
		this.partOne = (String)partOne;
	if(partOne instanceof Integer)
		this.partOne = (int)partOne;
	if(partOne instanceof Double)
		this.partOne = (double)partOne;
	if(partOne instanceof Order)
		this.partOne = (Order)partOne;
	if(partOne instanceof User)
		this.partOne = (User)partOne;
	if(partOne instanceof Data)
		this.partOne = (Data)partOne;
	if(partOne instanceof Teacher)
		this.partOne = (Teacher)partOne;
	if(partOne instanceof TechSupportGuy)
		this.partOne = (TechSupportGuy)partOne;
	if(partOne instanceof ORManager)
		this.partOne = (ORManager)partOne;
	if(partOne instanceof Student)
		this.partOne = (Student)partOne;
	if(partOne instanceof Course)
		this.partOne = (Course)partOne;
	if(partOne instanceof CourseFile)
		this.partOne = (CourseFile)partOne;
	if(partOne instanceof Mark)
		this.partOne = (Mark)partOne;
	if(partOne instanceof Admin)
		this.partOne = (Admin)partOne;
	if(partOne instanceof Employee)
		this.partOne = (Employee)partOne;
	if(partOne instanceof Lesson)
		this.partOne = (Lesson)partOne;
	if(partOne instanceof Transcript)
		this.partOne = (Transcript)partOne;
}
public Object getPartTwo() {
    return partTwo;
}
public void setPartTwo(Object partTwo) {
	if(partTwo instanceof String)
		this.partOne = (String)partOne;
	if(partTwo instanceof Integer)
		this.partOne = (int)partOne;
	if(partTwo instanceof Double)
		this.partTwo = (double)partOne;
	if(partTwo instanceof Order)
		this.partTwo = (Order)partOne;
	if(partTwo instanceof User)
		this.partTwo = (User)partOne;
	if(partTwo instanceof Data)
		this.partTwo = (Data)partOne;
	if(partTwo instanceof Teacher)
		this.partTwo = (Teacher)partOne;
	if(partTwo instanceof TechSupportGuy)
		this.partTwo = (TechSupportGuy)partOne;
	if(partTwo instanceof ORManager)
		this.partTwo = (ORManager)partOne;
	if(partTwo instanceof Student)
		this.partTwo = (Student)partOne;
	if(partTwo instanceof Course)
		this.partTwo = (Course)partOne;
	if(partTwo instanceof CourseFile)
		this.partTwo = (CourseFile)partOne;
	if(partTwo instanceof Mark)
		this.partTwo = (Mark)partOne;
	if(partTwo instanceof Admin)
		this.partTwo = (Admin)partOne;
	if(partTwo instanceof Employee)
		this.partTwo = (Employee)partOne;
	if(partTwo instanceof Lesson)
		this.partTwo = (Lesson)partOne;
	if(partTwo instanceof Transcript)
		this.partTwo = (Transcript)partOne;
}
public String toString() {
    return "Part one is " + partOne + " Part two is " + partTwo;
}

public int hashCode() {
  int result = 17;
  result+= 31*partOne.hashCode();
  result+= 31*partTwo.hashCode();
    return result;
}

public boolean equals(Object o) {
  if(this == o)
    return true;
  if(o == null)
    return false;
  if(!(o instanceof Pair))
    return false;
  Pair pair = (Pair)o;
    return this.partOne.equals(pair.partOne) && this.partTwo.equals(partTwo);

}


}
