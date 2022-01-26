package threadsBonusTask7;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		Gardener gardenerOne = new Gardener(5,5);
		Gardener gardenerTwo = new Gardener(5,5);
		gardenerOne.setName("GardenerOne");
		gardenerTwo.setName("GardenerTwo");
		gardenerOne.start();
		gardenerTwo.start();
		while(true) {
			for(int k= 0 ;k< 5;k++) {
				for(int j = 0; j< 5;j++) {
					System.out.print(Gardener.ground[k][j] + " ");
					Thread.sleep(1000);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
