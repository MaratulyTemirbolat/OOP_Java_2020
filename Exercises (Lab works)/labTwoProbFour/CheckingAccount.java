package labTwoProbFour;

public class CheckingAccount extends Account {
	private int numberOfTransactions;
	final int FREE_TRANSACTIONS = 5;
	CheckingAccount(){
	}
	CheckingAccount(int accNumber,int numberOfTransactions){
		super(accNumber);
		this.numberOfTransactions = numberOfTransactions;
	}
	public void deductFee() {
		if(numberOfTransactions>FREE_TRANSACTIONS) {
			if(((numberOfTransactions-FREE_TRANSACTIONS)*0.02)< getBalance()){
				System.out.println("Unsufficient amount of money for fee!");
			}
			else
			   withdraw(getBalance()-((numberOfTransactions-FREE_TRANSACTIONS)*0.02));
		}
	}
	public String toString() {
		return super.toString() + "\n" +"Total number of transactions = " + numberOfTransactions; 
	}
}
