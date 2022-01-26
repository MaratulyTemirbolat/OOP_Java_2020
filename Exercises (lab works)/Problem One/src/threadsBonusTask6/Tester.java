package threadsBonusTask6;

public class Tester {

	public static void main(String[] args) {
		Flowerbed flowerbed = new Flowerbed();
		WateringThread gardenerOne = new WateringThread();
		WateringThread gardenerTwo = new WateringThread();
		DryableThread drTh = new DryableThread();
		drTh.start();
		gardenerOne.start();
		gardenerTwo.start();
	}

}
