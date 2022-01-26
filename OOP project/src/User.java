import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.*;


public abstract class User implements Cloneable, Serializable, Comparable<User> {
	private int numberOfChangedPasswords;
	private String name;
	private String restoreAnswer;
	private String surname;
	private String middleName;
	private String login;
	private String password;
	private String id;
	private String[] previousPasswords;
	
	public User() {

	}
	public User(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer) {
		this.name = name;
		this.surname = surname;
		this.middleName = middleName;
		this.login = login;
		this.password = password;
		this.id = id;
		previousPasswords = new String[]{"","",password};
		numberOfChangedPasswords = 0;
		this.restoreAnswer = restoreAnswer;
	}
	public String getLogin() {
		return login;
	}
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getID() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean enterAccount(String login, String password) throws UserIdentificationException {
		if(this.login.equals(login) && this.password.equals(password))
			return true;
		return false;
	}
	public boolean changePassword(String newPassword) {
		if(isValidPassword(newPassword)==false) {
			System.out.println("Sorry. Not Correspondent Password");
			return false;
		}
		for(int k = 0 ; k <3;k++) {
			if(previousPasswords[k].equals(newPassword)) {
				System.out.println("Your password is similar to previous 3 passwords.");
				return false;
			}
		}
		numberOfChangedPasswords++;
		this.password = newPassword;
		if (3-numberOfChangedPasswords -1 < 0) {
			numberOfChangedPasswords = 0;
		}
		int difference = 3-numberOfChangedPasswords -1;
		previousPasswords[difference] = newPassword;
		return true;
	}

	public boolean changePassword(String currentPassword,String newPassword) throws UserIdentificationException{
		if(this.password.equals(currentPassword)) {
			return changePassword(newPassword);
		}
		else {
			System.out.println("Your enterred Password is not the same as actual!");
		}
		return false;
	}

	public boolean restorePassword() throws Exception {
		System.out.println("What is your favourite type of Animal");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//BUFFER ÈÑÏÎËÜÇÎÂÀÒÜ
		String answer = in.readLine();
		if(answer.equals(restoreAnswer)){// Write checking for the entered restorePassword to change currentPassword
			System.out.println("Type new password please. Your password must have at : ");
			System.out.println("       " + "1:At least one Upper Letter");
			System.out.println("       " + "2:Size >=6");
			System.out.println("       " + "3:Any number");
			String newPassword = in.readLine();
			return changePassword(newPassword);
		}
		return false;
	}
	public boolean isCorrespondentData(String data) {
		if(data.equals("") == true || data.equals(" ") == true) {
			return false;
		}
		return true;
	}
	public boolean isUniqueLogin(String login) {
		if(Data.gettAllLogins().contains(login) == true) {
			return false;
		}
		return true;
	}
	public boolean isUniqeIDNumber(String id) {
		if(Data.getAllId().contains(id) == true) {
			return false;
		}
		return true;
	}
	public boolean isValidPassword(String password) {
		if(password.length()<6) {
			return false;
		}
		boolean isHavingBigLetter = false;
		boolean isHavingNumber = false;
		for(int k =0;k<password.length();k++) {
			char c = password.charAt(k);
			if((int)c>=65 && (int)c<=90) {
				isHavingBigLetter = true;
			}
		}
		for(int k = 0;k<password.length();k++) {
			char n = password.charAt(k);
			if((int)n>=48 && (int)n<=57) {
				isHavingNumber = true;
			}
		}
		if(isHavingBigLetter == true && isHavingNumber == true) {
			return true;
		}
		return false;
	}
	public void setRestoreAnswer(String restoreAnswer) {
		this.restoreAnswer = restoreAnswer;
	}

	public String toString() {
		return  name + " " + surname + " " + middleName + " " + id;
	}

	public int hashCode() {
		int result = 17;
		result+= 31*login.hashCode();
		result+= 31*id.hashCode();
		return result;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof User))
			return false;
		User user = (User)o;
		return this.login.equals(user.login) && this.id.equals(user.id);
	}

	public void sendOrderToITGuy(Order order) {
		TechSupportGuy.addOrder(order);
	}

	public int compareTo(User user) {
		return this.login.compareTo(user.login);
	}

	public Object clone() throws CloneNotSupportedException {
		User user = (User)super.clone();
		return user;
	}
}
