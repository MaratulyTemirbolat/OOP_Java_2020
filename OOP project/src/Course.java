import java.io.Serializable;
import java.lang.*;
import java.util.Objects;
import java.util.Vector;
  
  public class Course implements Serializable,Cloneable,Comparable<Course>{    
      private double numberOfCredits;
      private String name;
      private String code;
      private Vector<CourseFile> courseFiles;
      private Vector<Lesson>lessons;
      private Vector<Course> prerequisites;
      
      {
    	lessons = new Vector<Lesson>();
    	courseFiles = new Vector<CourseFile>();  
      }
      
      public Course() {
    	  
      }
      public Course(double numberOfCredits, String name, String code) {
          this.numberOfCredits = numberOfCredits;
          this.name = name;
          this.code = code;
          this.prerequisites = new Vector<Course>(3);
      }
      public Course(double numberOfCredits, String name, String code,Vector<Course> prerequisites) {
          this.numberOfCredits = numberOfCredits;
          this.name = name;
          this.code = code;
          this.prerequisites = prerequisites;
      }

      
      @Override
      
      public String toString() {
          return "Course{ " +
                  " numberOfCredits = " + numberOfCredits +
                  ", name = " + name  +
                  ", code = " + code + 
                  ", lessons = " + lessons +
                  " }";
      }
     
      public double getNumberOfCredits() {
          return numberOfCredits;
      }
      public Vector<CourseFile> getCourseFiles(){
    	  return courseFiles;
      }
      public String getCode() {
          return code;
      }
      public void setCode(String code) {
    	  this.code = code;
      }
      public String getName() {
          return name;
      }
      public void setName(String name) {
    	  this.name = name;
      }
      public boolean addLesson(Lesson lesson) {
    	 lessons.add(lesson);
    	 return true;
      }
      public Vector<Lesson> getLessons() {
          return lessons;
      }
      public void setNumberOfCredits(double numberOfCredits) {
    	  this.numberOfCredits = numberOfCredits;
      }
      public Vector<Course> getPrerequisites() {
    	  return prerequisites;
      }
      public boolean addPrerequisite(Course prerequisite) {
    	  prerequisites.add(prerequisite);
    	  return true;
      }
      @Override
      public int hashCode() {
    	  	int result = 17;
    	  	result+=31*code.hashCode();
          return result;
      }
    
      public boolean equals(Object o) {
          if (this == o) 
        	  return true;
          if (o == null ) 
        	  return false;
          if(!(o instanceof Course)) {
        	  return false;
          }
          Course course = (Course)o;
          return this.code.equals(course.code); 
      }
	@Override
	public int compareTo(Course course) {
		if(this.numberOfCredits > course.numberOfCredits)
			return 1;
		if(this.numberOfCredits < course.numberOfCredits)
			return -1;
		return 0;
	}
	public Object clone() throws CloneNotSupportedException {
		Course newCourse =(Course) super.clone();
		newCourse.lessons = (Vector<Lesson>)this.lessons.clone();
		newCourse.courseFiles = (Vector<CourseFile>)this.courseFiles.clone();
		newCourse.prerequisites = (Vector<Course>)this.prerequisites.clone();
		return newCourse;
	}
}
