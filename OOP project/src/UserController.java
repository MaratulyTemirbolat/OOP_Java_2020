import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

public abstract class UserController implements Serializable{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public String option ="";
	public User user ;
	
	UserController(){
		
	}
	UserController(User user){
		this.user = user;
	}
	public String userOptionsToEnter() {
		return "1:Enter Account " + "\n" + "2:Restore Password" + "\n" + "3:Exit";
	}
	public void enterAccount() throws Exception{
		System.out.println(userOptionsToEnter());
		String selection = in.readLine();
		if(selection.equals("2")){
			restorePassword();
		}
		else {
			if(selection.equals("3")) {
				return;
			}
			String password = "";
			while(user.enterAccount(user.getLogin(), password) == false) {
				System.out.println("Please type your password or type Exit to close!");
				password = in.readLine();
				if(password.equals("Exit")) {
					System.out.println("Good Buy");
					return;
				}
			}
		}
		System.out.println("You are successfully enterred to the account");
		doInterface("");   // ПОдумать
	}
	public void restorePassword() throws Exception {
		boolean isRestored = user.restorePassword();
		if(isRestored) {
			System.out.println("Your Password is successfully changed!");
			return;
		}
		else {
			System.out.println("Sorry try again later!");	
		}
		enterAccount();
	}
	public String getOptions() {
		return "1:Send order to IT Guy" + "\n"+
				"2:View own user information " + "\n"+
				"3:Change password" + "\n"+
				"4:Change name"+ "\n"+
				"5:Change surname" + "\n"+
				"6:Change middleName" + "\n"+
				"7:Change restore answer" ;
		
	}

	public void doInterface(String choice) throws Exception {
			if(choice.equals("1")) {
				if(Data.getTechSupportGuys().size()==0) {
					System.out.println("Sorry.There is no any support guy");
					return;
				}
				System.out.println("Please type order description");
				String description = in.readLine();
				Order order = new Order(description);
				user.sendOrderToITGuy(order);
				System.out.println("Thanks your order is successfully sent");
			}
			else if(choice.equals("2")) {
				System.out.println(user);
			}
			else if(choice.equals("3")) {
				System.out.println("Please type your current password");
				String currentPassword = in.readLine();
				System.out.println("Type new password please. Your password must have at : ");
				System.out.println("       " + "1:At least one Upper Letter");
				System.out.println("       " + "2:Size >=6");
				System.out.println("       " + "3:Any number");
				System.out.println("Your password can no be the same as 3 previous");
				String newPassword = in.readLine();
				boolean isOk = user.changePassword(currentPassword, newPassword);
				if(isOk) {
					System.out.println("Your current password us successfully changed!");
				}
			}
			else if(choice.equals("4")) {
				System.out.println("Please, type your new name");
				String newName = in.readLine();
				user.setName(newName);
				System.out.println("Your name is successfully changed!");
			}
			else if(choice.equals("5")) {
				System.out.println("Please, type your new surname");
				String newSurname = in.readLine();
				user.setSurname(newSurname);
				System.out.println("Your surname is successfully changed!");
			}
			else if(choice.equals("6")) {
				System.out.println("Please, type your new Middle Name");
				String newMiddleName = in.readLine();
				user.setMiddleName(newMiddleName);
				System.out.println("Your Middle Name is successfully changed!");
			}
			else if(choice.equals("7")) {
				System.out.println("Please write yout new favourite animal for the restore answer");
				String newRestoreAnswer = in.readLine();
				user.setRestoreAnswer(newRestoreAnswer);
				System.out.println("Your restore answer succussfully updated!");
			}
		
		
		
	}
}
