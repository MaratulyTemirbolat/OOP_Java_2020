package threadsBonusTask1;

public class Tester {

	public static void main(String[] args) {
		Barbershop barbershop = new Barbershop();
		HairDresser barber = new HairDresser("Victor",barbershop);
		Customer[] customers = new Customer[4];
		barbershop.setBarber(barber);
		barber.start();
		for(int k = 0; k < 4;k++) {
			customers[k] = new Customer("Customer " + (k+1),barbershop);
			customers[k].start();
		}
		
	}

}
