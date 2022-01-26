package labTwoProbFour;

public class Tester {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.openAccount(new CheckingAccount(18117358,1000));
		bank.openAccount(new SavingAccount(18050505,12.0));
		bank.openAccount(new Account(18117359));
		bank.update(10000);
		for(Account account : bank.accounts) {
			System.out.println(account);
		}
		bank.closeAccount(18050505);
		System.out.println();
		for(Account account : bank.accounts) {
			System.out.println(account);
		}
	}

}
