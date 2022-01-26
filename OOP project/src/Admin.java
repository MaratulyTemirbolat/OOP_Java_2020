import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.*;
import java.util.Date;


public class Admin extends Employee implements Serializable{
	
	public Admin() {
		super();
	}
	public Admin(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber) {
		super(name,surname,middleName,login,password,id,restoreAnswer,salary,hireDate,insuranceNumber);
	}
	public void createUser(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,String whoExactly) throws IOException {
		
		if(whoExactly.equals("1") || whoExactly.equals("3") || whoExactly.equals("4") || whoExactly.equals("5")) {
			createEmployee(name,surname,middleName,login,password,id,restoreAnswer,whoExactly);
		}
		else {
			createStudent(name,surname,middleName,login,password,id,restoreAnswer);
		}
		
	}
	
	public void createEmployee(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,String whoExactly) throws IOException {
		//" 1:Teacher" +" 2:Student" +" 3:Admin" + " 4:Manager" " 5:Tech Support Guy
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What is the salary?");
		double salary = Double.parseDouble(in.readLine());
		System.out.println("What is the insurance number?");
		String insuranceNumber = in.readLine();
		if(whoExactly.equals("1")) {
			createTeacher(name,surname,middleName,login,password,id,restoreAnswer,salary,new Date(),insuranceNumber);
		}
		else if(whoExactly.equals("3")) {
			createAdmin(name,surname,middleName,login,password,id,restoreAnswer,salary,new Date(),insuranceNumber);
		}
		else if(whoExactly.equals("4")) {
			createManager(name,surname,middleName,login,password,id,restoreAnswer,salary,new Date(),insuranceNumber);
		}
		else if(whoExactly.equals("5")) {
			createSupportGuy(name,surname,middleName,login,password,id,restoreAnswer,salary,new Date(),insuranceNumber);
		}
	}
	public void createStudent(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer) throws IOException {
		//String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,int yearOfStudy, FACULTY attachedFaculty,String specialty
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What is the Year of study?");
		int newYearOfStudy = Integer.parseInt(in.readLine());
		FACULTY fac = null;
		while(fac==null) {
		System.out.println("What is the Faculty from the list? " + "\n" + "FIT, BS, MCM, GF");
		String newFaculty = in.readLine();
		
		if(newFaculty.equals("FIT")) {
			fac = FACULTY.FIT;
		}
		if(newFaculty.equals("BS")) {
			fac = FACULTY.BS;
		}
		if(newFaculty.equals("MCM")) {
			 fac = FACULTY.MCM;
		}
		if(newFaculty.equals("GF")) {
			 fac = FACULTY.GF;
		}
		
		}
		System.out.println("What is the specialty of the Student?");
		String newSpecialty = in.readLine();
		//String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,int yearOfStudy, FACULTY attachedFaculty,String specialty
		addUser(new Student(name,surname,middleName,login,password,id,restoreAnswer,newYearOfStudy,fac,newSpecialty));
	}
	public void createAdmin(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber) {
		addUser(new Admin(name,surname,middleName,login,password,id,restoreAnswer,salary,hireDate,insuranceNumber));
	}
	public void createManager(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		FACULTY fac = null;
		while(fac == null) {
		System.out.println("What is the Faculty from the list? " + "\n" + "FIT, BS, MCM, GF");
		String newFaculty = in.readLine();
		
		if(newFaculty.equals("FIT")) {
			fac = FACULTY.FIT;
		}
		if(newFaculty.equals("BS")) {
			fac = FACULTY.BS;
		}
		if(newFaculty.equals("MCM")) {
			 fac = FACULTY.MCM;
		}
		if(newFaculty.equals("GF")) {
			 fac = FACULTY.GF;
		}
		}
		addUser(new ORManager(name,surname,middleName,login,password,id,restoreAnswer,salary,hireDate,insuranceNumber,fac));
		
	}
	public void createTeacher(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		POSITION position = null;
		while(position == null) {
		System.out.println("Please type the position of the teacher from the list" + "\n" + "Professor, Lector, Dean, Assistant");
		String positionOptions = in.readLine();
		if(positionOptions.equals("Professor")) {
			position = POSITION.PROFESSOR;
		}
		if(positionOptions.equals("Lector")) {
			position = POSITION.LECTOR;
		}
		if(positionOptions.equals("Dean")) {
			position = POSITION.DEAN;
		}
		if(positionOptions.equals("Assistant")) {
			position = POSITION.ASSISTANT;
		}
		}
		FACULTY fac = null;
		while(fac == null) {
		System.out.println("What is the Faculty from the list? " + "\n" + "FIT, BS, MCM, GF");
		String newFaculty = in.readLine();
		
		if(newFaculty.equals("FIT")) {
			fac = FACULTY.FIT;
		}
		if(newFaculty.equals("BS")) {
			fac = FACULTY.BS;
		}
		if(newFaculty.equals("MCM")) {
			 fac = FACULTY.MCM;
		}
		if(newFaculty.equals("GF")) {
			 fac = FACULTY.GF;
		}
		}
		addUser(new Teacher(name,surname,middleName,login,password,id,restoreAnswer,salary,hireDate,insuranceNumber, position,fac));
	}
	public void createSupportGuy(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber) {
		addUser(new TechSupportGuy(name,surname, middleName,login,password,id,restoreAnswer,salary,new Date(), insuranceNumber));
	}
	public void addUser(User user) {
		if(user instanceof Student) {
			Data.getUsers().add((Student)user);

		}
		else if(user instanceof Admin) {
			Data.getUsers().add((Admin)user);
		}
		else if(user instanceof ORManager) {
			Data.getUsers().add((ORManager)user);
		}
		else if(user instanceof Teacher) {
			Data.getUsers().add((Teacher)user);
		}
		else if(user instanceof TechSupportGuy) {
			Data.getUsers().add((TechSupportGuy)user);
		}
	}
	
	public boolean removeUser(User user) {
		if(Data.getUsers().contains(user)) {
			Data.getUsers().remove(user);
			return true;
		}
		return false;
	}

	public String getUserOptions() {
		return "1: Name     2: Surname     3: Middle Name     4:  Password";
	}
	public String getEmployeeOptions() {
		return "5: Salary   6: Insurance Number  ";
	}
	public String getTeacherOptions() {
		return "7: Position   8: Exit";
	}
	public String getStudentOptions() {
		return "5: Year Of Study   6: Speciality   7: Exit";
	}
	public String getORManagerOptions() {
		return "7: Attached Faculty   8: Exit";
	}
	private void updateInfoUser(User user,String selection) throws IOException { 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			if(selection.equals("1")) {
				System.out.println("Enter new Name please : ");
				String newName = in.readLine();
				user.setName(newName);
			}
			else if(selection.equals("2")) {
				System.out.println("Enter new Surname please : ");
				String newSurname = in.readLine();
				user.setSurname(newSurname);
			}
			else if(selection.equals("3")) {
				System.out.println("Enter new Middle Name please : ");
				String newMiddleName = in.readLine();
				user.setMiddleName(newMiddleName);
			}
			else if(selection.equals("4")) {
				System.out.println("Enter new Password please : ");
				String newPassword = in.readLine();
				user.changePassword(newPassword);
			}
		}
	
	public void updateInfoEmployee(Employee employee,String selection) throws IOException {  // Спросить писать бафферридер в вайле или вне его
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			if(selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4")) {
				updateInfoUser(employee, selection);
			}
			else if(selection.equals("5")) {
				System.out.println("Please fill in new Salary : ");
				double newSalary = Double.parseDouble(in.readLine());
				employee.setSalary(newSalary);
			}
			else if(selection.equals("6")) {
				System.out.println("Please write a new Insurance Number");
				String newInsuranceNumber = in.readLine();
				employee.setInsuranceNumber(newInsuranceNumber);
			}
	}
	@SuppressWarnings({ "unused", "unused" })
	public void updateInfoTeacher(Teacher teacher) throws IOException {
		String selection = "";
		while(true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(getUserOptions() + " " + getEmployeeOptions() + " " + getTeacherOptions());
			selection = in.readLine();
			if(selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4") || selection.equals("5") || selection.equals("6")) {
				updateInfoEmployee(teacher, selection);
			}
			else if(selection.equals("7")) {
				POSITION pos = null;
				while(pos == null) {
				System.out.println("Please write a new Position from the list :");
				System.out.println("Professor      Lector     Dean      Assistant");
				String newPosition = in.readLine();
				if(newPosition.equals("Professor")) {
					pos =POSITION.PROFESSOR;
					teacher.setPosition(pos);
				}
				if(newPosition.equals("Lector")) {
					pos = POSITION.LECTOR;
					teacher.setPosition(pos);
				}
				if(newPosition.equals("Dean")) {
					pos = POSITION.DEAN;
					teacher.setPosition(pos);
				}
				if(newPosition.equals("Assistant")) {
					pos = POSITION.ASSISTANT;
					teacher.setPosition(pos);
				}
			}
			}
			else if(selection.equals("8")) {
				break;
			}
			
		}
	}
	public void updateInfoStudent(Student student) throws IOException {
		String selection = "";
		while(true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(getUserOptions() + " " + getStudentOptions());
			selection = in.readLine();
			if(selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4")) {
				updateInfoUser(student, selection);
			}
			else if(selection.equals("5")) {
				System.out.println("Please, write a new Year of Study : ");
				int newYearOfStudy =Integer.parseInt(in.readLine());
				student.setYearOfStudy(newYearOfStudy);
			}
			else if(selection.equals("6")) {
				System.out.println("Please, write a new Speciality : ");
				 String newSpeciality = in.readLine();
				 student.setSpecialty(newSpeciality);
			}
			else if(selection.equals("7")) {
				break;
			}
		}
	}
	public void updateInfoAdmin(Employee employee) throws IOException {
		String selection = "";
		while(true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(getUserOptions() + " " + getEmployeeOptions() + "     7: Exit");
			selection = in.readLine();
			if(selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4") || selection.equals("5") || selection.equals("6")) {
				updateInfoEmployee(employee, selection);
			}
			else if(selection.equals("7")) {
				break;
			}
		}
	}
	public void updateInfoORManager(ORManager manager) throws IOException {
		String selection = "";
		while(true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(getUserOptions() + " " + getEmployeeOptions() + getORManagerOptions());
			selection = in.readLine();
			if(selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4") || selection.equals("5") || selection.equals("6")) {
				updateInfoEmployee(manager, selection);
			}
			else if(selection.equals("7")) {
				FACULTY fac = null;
				while(fac == null) {
				System.out.println("Please, write a new Faculty from the list below : ");
				System.out.println("FIT, MCM, BS, GF");
				String newFaculty = in.readLine();
				if(newFaculty.equals("FIT")) {
					fac = FACULTY.FIT;
					manager.setAttachedFaculty(fac);
				}
				if(newFaculty.equals("MCM")) {
					fac = FACULTY.MCM;
					manager.setAttachedFaculty(fac);
				}
				if(newFaculty.equals("BS")) {
					fac = FACULTY.BS;
					manager.setAttachedFaculty(fac);
				}
				if(newFaculty.equals("GF")) {
					fac = FACULTY.GF;
					manager.setAttachedFaculty(fac);
				}
				}
			}
			else if(selection.equals("8")) {
				break;
			}
		}
	}
	private void updateInfoTechSupportGuy(Employee supportGuy) throws IOException {
		updateInfoAdmin(supportGuy);
	}
	public String toString() {
		return super.toString() ;
	}

	public boolean equals(Object o) {
		return super.equals(o);
	}

	public int hashCode() {
		return super.hashCode();
	}

}

