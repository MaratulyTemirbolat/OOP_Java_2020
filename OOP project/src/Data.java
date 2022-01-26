import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Data implements Serializable,Comparable<Data>,Cloneable {
	private static final Data INSTANCE = new Data();
	private static Vector<User> users;
	private static Vector<Course> courses;
	

	private Data() { //SINGLETONE
		users = new Vector<User>();
		courses = new Vector<Course>();
	}
	
	public static Vector<User> getUsers() {
		return users;
	}
	
	public static Vector<Course> getCourses() {
		return courses;
	}
	public void setUsers(Vector<User> users) {
		this.users = users;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	public static Data getInstance() {
		return INSTANCE;
	}
	public static Vector<String> gettAllLogins(){
		Vector<String> allLogins = new Vector<String>();
		for(User user:users) {
			allLogins.add(user.getLogin());
		}
		return allLogins;
	}
	public static Vector<String> getAllId(){
		Vector<String> allID = new Vector<String>();
		for(User user:users) {
			allID.add(user.getID());
		}
		return allID;
	}
	public static Teacher viewTeacher(String name,String surname,String id) {
		for(User user: users) {
			if(user instanceof Teacher) {
				if(user.getName().equals(name) && user.getSurname().equals(surname)&&user.getID().equals(id))
					return (Teacher)user;
			}
		}
		return null;
	}
	public static void saveData(Data dataa) throws IOException {
		FileOutputStream fos = new FileOutputStream("data");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dataa);
		oos.close();
	}
	public static void saveStudents() throws IOException {
		FileOutputStream fos = new FileOutputStream("students");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(getStudents());
		oos.close();
	}

	public static void saveCourses() throws IOException {
		FileOutputStream fos = new FileOutputStream("courses");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
	}
	public static void saveAdmins() throws IOException {
		FileOutputStream fos = new FileOutputStream("admins");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(getAdmins());
		oos.close();
	}
	public static void saveORManagers() throws IOException {
		FileOutputStream fos = new FileOutputStream("managers");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(getORManagers());
		oos.close();
	}
	public static void saveTechSupportGuys() throws IOException {
		FileOutputStream fos = new FileOutputStream("techSupportGuys");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(getTechSupportGuys());
		oos.close();
	}
	public static void saveTeachers() throws IOException {
		FileOutputStream fos = new FileOutputStream("teachers");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(getTeachers());
		oos.close();
	}
	public static void desStudents() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("students");
		ObjectInputStream ois = new ObjectInputStream(fis);
		 Vector<Student> stud = (Vector<Student>)ois.readObject();
		 for(Student s:stud) {
			 users.add(s);
		 }
	}
	public static void desAdmins() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("admins");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Vector<Admin> admin = (Vector<Admin>)ois.readObject();
		for(Admin a:admin) {
			users.add(a);
		}
	}
	public static void desORManagers() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("managers");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Vector<ORManager> manages = (Vector<ORManager>)ois.readObject();
		for(ORManager m:manages) {
			users.add(m);
		}
	}
	public static void desTechSupportGuys() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("techSupportGuys");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Vector<TechSupportGuy> guys = (Vector<TechSupportGuy>)ois.readObject();
		for(TechSupportGuy g:guys) {
			users.add(g);
		}
	}
	public static void desTeachers() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("teachers");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Vector<Teacher> teach = (Vector<Teacher>)ois.readObject();
		for(Teacher t:teach) {
			users.add(t);
		}
	}
	public static void desCourses() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("courses");
		ObjectInputStream ois = new ObjectInputStream(fis);
		courses = (Vector<Course>)ois.readObject();
	}
	public static Data viewData() throws ClassNotFoundException, IOException { //Подумать над возвращением 
			if(new File("data").exists() == false) {
				//return getInstance();
				return getInstance();
			}
			FileInputStream fis = new FileInputStream("data");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Data dataa = (Data)ois.readObject();
			//ois.close();
			//fis.close();
			return dataa;
			}

	public static Vector<Student> getStudents() {
		Vector<Student> students = new Vector<Student>();
		for(User user: users) {
			if(user instanceof Student) {
				students.add((Student)user);
			}
		}
		return students;
	}
	public static String detFaculty(FACULTY attachedFaculty) {
		if(attachedFaculty == FACULTY.BS) {
			return "Business School";
		}
		else if(attachedFaculty == FACULTY.FIT) {
			return "Faculty of Information Technology";
		}
		else if(attachedFaculty == FACULTY.GF) {
			return "General Faculty";
		}
		else if(attachedFaculty == FACULTY.MCM) {
			return "Mathematical and Computer Modelling";
		}
		return "";
	}
	public static Vector<Teacher> getTeachers() {
		Vector<Teacher> teachers = new Vector<Teacher>();
		for(User user:users) {
			if(user instanceof Teacher) {
				teachers.add((Teacher)user);
			}
		}
		return teachers;
	}

	public static Vector<ORManager> getORManagers() {
		Vector<ORManager> orManagers = new Vector<ORManager>();
		for(User user:users) {
			if(user instanceof ORManager) {
				orManagers.add((ORManager)user);
			}
		}
		return orManagers;
	}

	public static Vector<TechSupportGuy> getTechSupportGuys() {
		Vector<TechSupportGuy> techSupportGuys = new Vector<TechSupportGuy>();
		for(User user:users) {
			if(user instanceof TechSupportGuy) {
				techSupportGuys.add((TechSupportGuy)user);
			}
		}
		return techSupportGuys;
	}
	
	public static Vector<Admin> getAdmins() {
		Vector<Admin> admins = new Vector<Admin>();
		for(User user:users) {
			if(user instanceof Admin) {
				admins.add((Admin)user);
			}
		}
		return admins;
	}
	public static User findUser(String id) {
		for(User user : users) {
			if(  user.getID().equals(id) ) {
				return user;
			}
		}
		return null;
	}
	public static void viewStudentsGeneralInformation() {
		Vector<Student> students = getStudents();
		Collections.sort(students,new NameComparator());
		if(students.size()!=0) {
			System.out.println("Students :");
			for(Student st:students) {
				System.out.println("   " + st.getName() + " "+st.getSurname() + " "+ st.getMiddleName() + " ID "+ st.getID());
			}
		}
	}
	public static void viewTeachersGeneralInformation() {
		Vector<Teacher> teachers = getTeachers();
		Collections.sort(teachers,new NameComparator());
		if(teachers.size()!=0) {
			System.out.println("Teachers :");
			for(Teacher t:teachers) {
				System.out.println("   " + t.getName() + " "+t.getSurname() + " "+ t.getMiddleName() + " ID "+ t.getID());
			}
		}
	}
	public static void viewTechSupportGuysGeneralInformation() {
		Vector<TechSupportGuy> guys = getTechSupportGuys();
		Collections.sort(guys,new NameComparator());
		if(guys.size()!=0) {
			System.out.println("Tech Support Guys : ");
			for(TechSupportGuy g:guys) {
				System.out.println("   " + g.getName() + " "+g.getSurname() + " "+ g.getMiddleName() + " ID "+ g.getID());
			}
		}
	}
	public static void viewAdminsGeneralInformation() {
		Vector<Admin> admins = getAdmins();
		Collections.sort(admins,new NameComparator());
		if(admins.size()!=0) {
			System.out.println("Admins : ");
			for(Admin a:admins) {
				System.out.println("   " + a.getName() + " "+a.getSurname() + " "+ a.getMiddleName() + " ID "+ a.getID());
			}
		}
	}
	public static void viewManagersGeneralInformation() {
		Vector<ORManager> managers = getORManagers();
		Collections.sort(managers,new NameComparator());
		if(managers.size()!=0) {
			System.out.println("Managers : ");
			for(ORManager m:managers) {
				System.out.println("   " + m.getName() + " "+m.getSurname() + " "+ m.getMiddleName() + " ID "+ m.getID());
			}
		}
	}
	public static void viewAllUsersGeneralInformation() {
			viewStudentsGeneralInformation();
			viewTeachersGeneralInformation();
			viewTechSupportGuysGeneralInformation();
			viewAdminsGeneralInformation();
			viewManagersGeneralInformation();
			
	}
	public Object clone() throws CloneNotSupportedException {
		Data data = (Data)super.clone();
		data.users.addAll(this.users);
		data.courses.addAll(this.courses);
		return data;

	}
	public int compareTo(Data data) {
		if(this.getUsers().size()>data.getUsers().size()) {
			return 1;
		}
		if(this.getUsers().size()<data.getUsers().size()) {
			return -1;
		}
		return 0;
	}
}

