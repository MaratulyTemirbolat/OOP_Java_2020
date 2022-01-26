package threadsBonusTask7;

public class Gardener extends Thread {
	static int[][] ground;
	int sizeHorizontal;
	int sizeVertical;
	Gardener(){
		
	}
	Gardener(int sizeHorizontal , int sizeVertical){
		this.sizeHorizontal = sizeHorizontal;
		this.sizeVertical = sizeVertical;
		ground = new int[sizeHorizontal][sizeVertical];
		for(int k =0 ; k< sizeHorizontal;k++) {
			for(int j = 0 ; j < sizeVertical;j++) {
				ground[k][j] = 0;
			}
		}
	}
	public synchronized void markGround(int x, int y) {
		if(Thread.currentThread().getName().equals("GardenerOne"))
			ground[x][y] = 1;
		else if(Thread.currentThread().getName().equals("GardenerTwo"))
			ground[x][y] = 2;
	}
	public void moveGardenerOneHorizontally() {
		for ( int k = 0 ; k <sizeHorizontal;k++) {
			for(int j = 0 ; j < sizeVertical;j++) {
				if(ground[k][j]==0) {
					markGround(k,j);
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void moveGardenerSecondeVertically() {
		for(int k = (sizeVertical- 1);k>-1;k--) {
			for(int j = (sizeHorizontal -1); j >-1;j--) {
				if(ground[j][k] == 0) {
					markGround(j,k);
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void run() {
		if(Thread.currentThread().getName().equals("GardenerOne")) {
			moveGardenerOneHorizontally();
		}
		else if(Thread.currentThread().getName().equals("GardenerTwo")) {
			moveGardenerSecondeVertically();
		}
	}
}
