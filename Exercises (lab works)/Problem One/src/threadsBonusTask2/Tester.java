package threadsBonusTask2;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		int n = 4;
		Pot pot = new Pot(10);
		EatingThread et = new EatingThread(pot);
		et.start();
		for(int k =0 ;k< n ;k++) {
			FillingThread ft = new FillingThread(pot);
			ft.setName("Bee" + (k+1) + " :");
			ft.start(); 
		}
	}

}
