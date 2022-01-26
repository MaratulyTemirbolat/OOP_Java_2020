package labTwoProbFour;

public class SavingAccount extends Account {
// Депозитный счет
// метод который добавляет процентную ставку (interest)
	
// В Чекин Аккаунт взимаются FEE за каждую транзакцию 
// ТРанзакция это пополнение, снятие, перевод
	private double interestRate;
	SavingAccount(){
		super();
	}
	SavingAccount(int accNumber,double interestRate){
		super(accNumber);
		this.interestRate = interestRate;
	}
	public void addInterestToTheAccount() {
		 deposit((getBalance()*interestRate)/100.0);
	}
	public String toString() {
		return super.toString() +"\n"+ "Your interestRate =" + interestRate;
	}
}
