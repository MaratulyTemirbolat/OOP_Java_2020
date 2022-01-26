package threadsBonusTask6;

public class Flowerbed {
	static Flower[] flowers = new Flower[40];
	int numberOfGardeners = 2;
	Flowerbed(){
		for(int k=0;k<40;k++) {
			flowers[k] = new Flower("Flower: " + (k+1));
		}
	}
	
	
}
