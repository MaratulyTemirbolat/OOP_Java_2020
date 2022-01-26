package labTwoProbFour;
import java.util.Vector;
public class Bank {
	Vector<Account> accounts;
	
	Bank(){
		 accounts = new Vector<Account>();
	}
	public void update(double sum) {
		for(Account account: accounts) {
			account.deposit(sum);
			if(account instanceof CheckingAccount) {
				((CheckingAccount)account).deductFee();
			}
			else if(account instanceof SavingAccount) {
				((SavingAccount)account).addInterestToTheAccount();
			}
		}
	}
	public void openAccount(Object o) {
		
		if(o instanceof Account)
			accounts.add((Account)(o));
		
	}
	public void closeAccount(int accNumber) {
		for(Account account:accounts) {
			if(account.getAccountNumber() == accNumber) {
				accounts.remove(account);
				break;
			}
		}
	}
}
