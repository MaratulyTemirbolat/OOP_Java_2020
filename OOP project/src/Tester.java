import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

public class Tester implements Serializable {

	public void startTheSystem(Data dataa,boolean isOk) throws Exception  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hello! WELCOME TO UNIVERSITY SYSTEM!");
		System.out.println("Enter Your Login please!");
		String login = in.readLine();
		if(isOk== true) {
			Data.getUsers().add(new Admin("Temir","Maratuly","","t_maratuly","12345","18BD117358","Dog",20.5,new Date(),"4410"));
			isOk = false;
		}
		User user  = null;
		for(User curUser:Data.getUsers()) {
			if(curUser.getLogin().equals(login))
				user = curUser;
		}
		if(user!=null) {
			UserController userController = null;
			if(user instanceof Admin) {
				userController = new AdminController((Admin)user);
			}
			if(user instanceof Student) {
				userController = new StudentController((Student)user);
			}
			if(user instanceof ORManager) {
				userController = new ORManagerController((ORManager)user);
			}
			if(user instanceof Teacher) {
				userController = new TeacherController((Teacher)user);
			}
			if(user instanceof TechSupportGuy) {
				userController = new TechSupportGuyController((TechSupportGuy)user);
			}
		
			userController.enterAccount();
		}
		else {
			System.out.println("Sorry. There is no such user with this login. Please try again! ");
			startTheSystem(dataa,isOk);
		}
		System.out.println("THANKS!!! GOOD BUY! SEE YOU NEXT TIME!");
		Data.saveCourses();
		Data.saveStudents();
		Data.saveAdmins();
		Data.saveORManagers();
		Data.saveTeachers();
		Data.saveTechSupportGuys();
	}
	public static void main(String[] args) throws Exception {
		Tester tester = new Tester();
		Data dataa  = Data.getInstance();
		boolean isOk = true;
		 if(new File("students").exists()) {
			 Data.desStudents();
			 isOk = false;
		 }
		 if(new File("admins").exists()) {
			 Data.desAdmins();
			 isOk = false;
		 }
		 if(new File("managers").exists()) {
			 Data.desORManagers();
			 isOk = false;
		 }
		 if(new File("techSupportGuys").exists()) {
			 Data.desTechSupportGuys();
			 isOk = false;
		 }
		 if(new File("teachers").exists()) {
			 Data.desTeachers();
			 isOk = false;
		 }
		 if(new File("courses").exists()) {
			 Data.desCourses();
			 isOk = false;
		 }
		
		tester.startTheSystem(dataa,isOk);
	}

}
