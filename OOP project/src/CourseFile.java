import java.io.Serializable;
import java.lang.*;
import java.util.*;
  
  public class CourseFile implements Serializable,Cloneable,Comparable<CourseFile>{
      private double size;
      private String name;
      private Date dayOfCreation;
      private TYPE fileType;
      
      public CourseFile() {
    	  
      }
      public CourseFile(double size, String name, Date dayOfCreation, TYPE fileType) {
          this.size = size;
          this.name = name;
          this.dayOfCreation = dayOfCreation;
          this.fileType = fileType;
      }
      public double getSize() {
          return size;
      }
      
      public String toString() {
          return "CourseFile{ " +
                  "size = " + size +
                  ", name = " + name  +
                  ", dayOfCreation = " + dayOfCreation +
                  ", fileType = " + fileType +
                  " }";
      }
     
      public String viewType() {
          if(fileType == TYPE.DOC) {
        	  return ".doc";
          }
          else if(fileType == TYPE.PDF) {
        	  return ".pdf";
          }
          else if(fileType == TYPE.PPT) {
        	  return ".ppt";
          }
          else if(fileType == TYPE.ZIP) {
        	  return ".zip";
          }
          return null;
      }
     
      public Date getDayOfCreation() {
          return dayOfCreation;
      }
      public String getName() {
          return name;
      }
      
      public boolean equals(Object o) {
          if (this == o) 
        	  return true;
          if (o == null || getClass() != o.getClass()) 
        	  return false;
          CourseFile that = (CourseFile) o;
          return this.name.equals(that.name);
      }

     
      public int hashCode() {
    	  int result = 17;
    	  result+=31*size;
    	  result+=31*name.hashCode();
          return result;
      }

      public Object clone() throws CloneNotSupportedException {
    	  CourseFile newCourse = (CourseFile)super.clone();
    	  newCourse.dayOfCreation = (Date)this.dayOfCreation.clone();
    	  return newCourse;
      }
	
	public int compareTo(CourseFile file) {
		if(this.size>file.size)
			return 1;
		if(this.size<file.size)
			return -1;
		return 0;
	}
  }