package threadsBonusTask2;

public class FillingThread extends Thread{
	Pot pot;
	FillingThread(){
		
	}
	FillingThread(Pot pot){
		this.pot = pot;
	}
	public void run() {
		while(true) {
			
			synchronized(pot) {
				if(pot.isFull() == false) {
					pot.incrCurrentLevel();
					System.out.println(Thread.currentThread().getName() + " " + Pot.currentLevel);
					if(pot.isFull())
						pot.notifyAll();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
