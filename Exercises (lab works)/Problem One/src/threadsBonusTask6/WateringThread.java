package threadsBonusTask6;

import threadsBonusTask2.Pot;

public class WateringThread extends Thread {
	
	WateringThread(){
		
	}
	public void run() {
		int k = 0;
		while(true) {
			synchronized(Flowerbed.flowers) {
			
					if(!Flowerbed.flowers[k].isWatered()) {
						Flowerbed.flowers[k].water();
						System.out.println(Thread.currentThread().getName() + " Watered " + Flowerbed.flowers[k].getName());
					}
				}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			k++;
			if(k == 40) {
				k = 0;
			}
		
		}
	}
}
