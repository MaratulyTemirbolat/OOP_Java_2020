import java.lang.*;
import java.lang.String[3];
/**
*/
public class Teacher extends Employee implements FillingAttendance {
/**
*/
private POSITION position;
/**
*/
private FACULTY attachedFaculty;
/**
*/
private HashMap<Course,Vector<Student>> courses;
/**
*/
private Vector<String> messages;
/**
*/
private Map<Pair,Mark> marks;
/**
*/
private Schedule schedule;
/**
 * @return 
*/
public FACULTY getFaculty() {
    return null;
}
/**
 * @param student 
 * @param course 
 * @param mark 
*/
public void putMark(Course course, Student student, Mark mark) {
}
/**
 * @return 
*/
public Vector<Pair> getMarksReport() {
    return null;
}
/**
 * @param file 
 * @param course 
 * @return 
*/
public boolean uploadCourseFile(Course course, CourseFile file) {
    return false;
}
/**
 * @param file 
 * @param course 
 * @return 
*/
public boolean deleteCourseFile(Course course, CourseFile file) {
    return false;
}
/**
 * @param course 
 * @return 
*/
public Vector<Student> viewStudentsOnCourse(Course course) {
    return null;
}
/**
 * @return 
*/
public Vector<Course> viewCourses() {
    return null;
}
/**
 * @param course 
*/
public void viewStudentsInformation(Course course) {
}
/**
 * @param schedule 
*/
public void setSchedule(Schedule schedule) {
}
/**
 * @param teacher 
 * @param subject 
 * @param students 
*/
public void fillAttendance(Teacher teacher, Vector<Student> students, Course subject) {
}
/**
 * @return 
*/
public String toString() {
    return null;
}
/**
 * @param o 
 * @return 
*/
public boolean equals(Object o) {
    return false;
}
/**
 * @return 
*/
public int hashCode() {
    return 0;
}
/**
 * @param o 
 * @return 
*/
public int compareTo(Object o) {
    return 0;
}
/**
 * @param teacher 
*/
public void saveTeacher(Teacher teacher) {
}
/**
 * @return 
*/
public Teacher viewTeacher() {
    return null;
}
}

