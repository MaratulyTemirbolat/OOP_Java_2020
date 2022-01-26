package threadsBonusTask2;

public class EatingThread extends Thread{
	Pot pot;
	EatingThread(){
		
	}
	EatingThread(Pot pot){
		this.pot = pot;
	}
	public void run() {
		while(true) {
			
			synchronized(pot) {
			
				while(!pot.isFull()) {
					try {
						pot.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					System.out.println("Bear ate the honey");
					pot.empty();
			}
		}
	}
}
