package threadsBonusTask1;

public class HairDresser extends Thread{
	private String name;
	private boolean isSleep;
	private boolean isWork;
	private Customer currentCustomer;
	public Barbershop barbershop;
	HairDresser(){
		
	}
	HairDresser(String name,Barbershop barbershop){
		this.name = name;
		isSleep = true;
		isWork = false;
		this.barbershop = barbershop;
		currentCustomer = null;
	}
	public void setNameBarber(String name) {
		this.name = name;
	}
	public String getNameBarber() {
		return name;
	}
	public void takeNap() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Barber is sleeping");
		isSleep = true;
		isWork = false;
	}
	public boolean isSleeping() {
		return isSleep;
	}
	public boolean isWorking() {
		return isWork;
	}
	public void wakeUp(Customer curCustomer) {
		isSleep = false;
		isWork = true;
		currentCustomer = curCustomer;
	}
	public void run() {
		while(true) {
			if(isSleeping()) {
				takeNap();
			}
			else if(isWorking()) {
				System.out.println("Barber is busy");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Barber has finished");
				currentCustomer.hair();
				System.out.println(currentCustomer.getNameCustomer() + " is haired ");
				
				if(barbershop.isEmpty()) {
					takeNap();
					currentCustomer = null;
				}
				else if(!barbershop.isEmpty()) {
					currentCustomer = barbershop.customers.peek();
					barbershop.customers.poll();
					System.out.println("Barber took a new customer " + currentCustomer.getNameCustomer());
				}
			}
		}
	}
	
}
