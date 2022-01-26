package labTwoProbFour;

public class Account {
	// Задача на полиморфизм
	private double balance;
	private int accNumber;
	public Account() {
	}
	public Account(int accNumber) {
		balance = 0.0;
		this.accNumber = accNumber;
	}
	public void deposit(double sum) {
		balance+=sum;
	}
	public void withdraw(double sum) {
		if(balance - sum>0)
			balance-=sum;
	}
	public double getBalance() {
		return balance;
	}
	public double getAccountNumber() {
		return accNumber;
	}
	public void transfer(double amount, Account other) {
		if(balance - amount>0) {
		this.withdraw(amount);
		other.deposit(amount);
		}
		else {
			System.out.println("NO MONEY to transfer!!!");
		}
		
	}
	//Override toString method
	public String toString() {
		return "Account number : " + accNumber + "\n"+ "Current balance : " + balance;
	}
	public final void print() {
		System.out.println(toString());
	}
	

}
