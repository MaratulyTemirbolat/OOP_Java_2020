import java.util.*;
import java.io.Serializable;

public class Lesson implements Serializable, Cloneable,Comparable<Lesson>{

private Date date;
private int timeDuration;
private String typeOfLesson;

public Lesson() {
	
}
public Lesson(Date date, int timeDuration,String typeOfLesson) {
	this.date = date;
	this.timeDuration = timeDuration;
	this.typeOfLesson = typeOfLesson;
}
public Date getDate() {
    return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String toString() {
    return " Date is : " + date + " timeDuration : " + timeDuration + " type of the Lesson is " + typeOfLesson;
}

public int getTimeDuration() {
	return timeDuration;
}

public void setTimeDuration(int timeDuration) {
	this.timeDuration = timeDuration;
}

public String getTypeOfLesson() {
    return typeOfLesson;
}
public void setTypeOfLesson(String typeOfLesson) {
	this.typeOfLesson = typeOfLesson;
}
public Object clone() throws CloneNotSupportedException {
	Lesson newLesson = (Lesson) super.clone();
	newLesson.date = (Date)this.date.clone();
	return newLesson;
}
@Override
public int compareTo(Lesson lesson) {
	if(this.timeDuration > lesson.timeDuration) {
		return 1;
	}
	if(this.timeDuration<lesson.timeDuration) {
		return -1;
	}
	return 0;
}
}

