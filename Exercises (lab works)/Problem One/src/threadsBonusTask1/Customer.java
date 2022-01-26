package threadsBonusTask1;

import java.util.Random;

public class Customer extends Thread {
	private String name;
	private boolean isCut;
	Random random = new Random();
	Barbershop bs;
	Customer(){
		
	}
	Customer(String name,Barbershop bs){
		this.name = name;
		isCut = false;
		this.bs = bs;
	}
	public boolean isHaired() {
		return isCut;
	}
	public String getNameCustomer() {
		return name;
	}
	public void hair() {
		isCut = true;
	}
	public void run() {
		try {
			Thread.sleep(random.nextInt(4000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bs.takeNewCustomer(this);
	}
}
