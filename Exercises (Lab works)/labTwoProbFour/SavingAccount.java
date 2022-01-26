package labTwoProbFour;

public class SavingAccount extends Account {
// ���������� ����
// ����� ������� ��������� ���������� ������ (interest)
	
// � ����� ������� ��������� FEE �� ������ ���������� 
// ���������� ��� ����������, ������, �������
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
