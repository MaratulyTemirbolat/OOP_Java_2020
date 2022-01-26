package threadsBonusTask1;
import java.util.Queue;
import java.util.LinkedList;

public class Barbershop {
	 Queue<Customer> customers;
	 HairDresser hairDresser;
	{
		customers = new LinkedList<>();
	}
	Barbershop(){
	}
	Barbershop(HairDresser hairDresser){
		this.hairDresser = hairDresser;
	}
	public void addCustomerToQueue(Customer customer) {
		customers.add(customer);
	}
	public void setBarber(HairDresser barber) {
		this.hairDresser = barber;
	}
	public boolean isEmpty() {
		return customers.isEmpty();
	}
	public void takeNewCustomer(Customer customer) {
		if(hairDresser.isSleeping()) {
			hairDresser.wakeUp(customer);
			System.out.println("Barbed woke up and tooke the customer " + customer.getNameCustomer());
		}
		else if(hairDresser.isWorking()) {
			System.out.println("The Customer " + customer.getNameCustomer() + " is sleeping in queue");
			addCustomerToQueue(customer);
		}
	}
}
