package threadsBonusTask6;

import java.util.Random;

public class DryableThread extends Thread {
	Random random = new Random();
	DryableThread(){	
	}
	public void run() {
		int k  = 39;
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(Flowerbed.flowers) {
				Flowerbed.flowers[k].dry();
				System.out.println(Flowerbed.flowers[k].getName() + " is dried");
				
			}
			k--;
			if( k == -1) {
				k = 39;
			}
		}
	}
}
