import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminController extends EmployeeController{
	public Admin admin;
	public AdminController() {
		super();
	}
	public AdminController(Admin admin) {
		super(admin);
		this.admin = admin;
	}
	public String getOptions() {
		return super.getOptions() + "\n" +
				"10:Add new user" + "\n" +
				"11:Remove user" + "\n" +
				"12:Update info user" + "\n"+
				"13:See all existed users" + "\n" +
				"14:Exit";
	}
	public void doInterface(String choice) throws Exception {
		while(!super.option.equals("14")) {
			System.out.println(getOptions());
			super.option = super.in.readLine();
			String ch = super.option;
			super.doInterface(ch);
			
			if(option.equals("10")) {
				addNewUser();
			}
			else if(option.equals("11")) {
				removeUser();
			}
			else if(option.equals("12")) {
				updateUser();
			}
			else if(option.equals("13")) {
				viewAllUsers();
			}
		}
	}
	
	public void addNewUser() throws IOException {
		viewAllUsers();
		System.out.println("Type the name please");
		String newName = in.readLine();
		if(admin.isCorrespondentData(newName) == false) {
			System.out.println("Sorry, not available format");
			return;
		}
		System.out.println("Type the surname please");
		String newSurname = in.readLine();
		if(admin.isCorrespondentData(newSurname) == false) {
			return;
		}
		System.out.println("Type the middle name please");
		String newMiddleName = in.readLine();
		System.out.println("Type new login please");
		String newLogin = in.readLine();
		if(admin.isUniqueLogin(newLogin) == false) {
			System.out.println("This login is busy");
			return ;
		}
		System.out.println("Type new password please. Your password must have at : " );
		System.out.println("       " + "1:At least one Upper Letter");
		System.out.println("       " + "2:Size >=6");
		System.out.println("       " + "3:Any number");
		String newPassword = in.readLine();
		if(admin.isValidPassword(newPassword)==false) {
			System.out.println("Sorry! Invalid Password!");
			return;
		}
		System.out.println("Type the ID number please");
		String newID = in.readLine();
		if(admin.isUniqeIDNumber(newID) == false) {
			System.out.println("This ID is busy");
			return;
		}
		System.out.println("Type restore answer to Question : What is your favourite animal");
		String newRestoreAnswer = in.readLine();
		if(admin.isCorrespondentData(newRestoreAnswer)== false) {
			System.out.println("Sorry, not available format");
			return;
		}
		System.out.println("Who do you want to create?" + "\n" + " 1:Teacher" +" 2:Student" +" 3:Admin" + " 4:Manager" + " 5:Tech Support Guy" );
		String newChoice = in.readLine();
		if(newChoice.equals("1") ==false && newChoice.equals("2") == false && newChoice.equals("3")==false && newChoice.equals("4") == false && newChoice.equals("5") ==false ) {
			System.out.println("No such option");
			return;
		}
		//String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,int yearOfStudy, FACULTY attachedFaculty,String specialty
		admin.createUser(newName, newSurname, newMiddleName, newLogin, newPassword, newID, newRestoreAnswer, newChoice);
		System.out.println("The user is successfully added");
	}
	public void removeUser() throws IOException {
		viewAllUsers();
		System.out.println("Please type the ID card number of the User");
		String userIDNumber = in.readLine();
		User userDeleted = Data.findUser(userIDNumber);
		if(userDeleted!=null) {
			admin.removeUser(userDeleted);
			System.out.println("User is successfully deleted");
		}
		else {
			System.out.println("User is not found. Please try later");
		}
	}
	public void updateUser() throws IOException {
		viewAllUsers();
		System.out.println("Please write the ID number of the user that you want to update");
		String userID = in.readLine();
		User user = Data.findUser(userID);
		if(user!=null) {
		     if(user instanceof Student) {
		    	 admin.updateInfoStudent((Student)user);
		     }
		     if(user instanceof Teacher) {
		    	 admin.updateInfoTeacher((Teacher)user);
		     }
		     if(user instanceof Admin) {
		    	 admin.updateInfoAdmin((Admin)user);
		     }
		     if(user instanceof ORManager) {
		    	 admin.updateInfoORManager((ORManager)user);
		     }
		     System.out.println("User is successfully updated");
		}
		else {
			System.out.println("Sorry, but user not found. Please try later");
		}
	}
	public void viewAllUsers() {
		if(!Data.getUsers().isEmpty()) {
			Data.viewAllUsersGeneralInformation();
		}
		else {
			System.out.println("Sorry but there is no any user");
		}
	}
}
