package threadsBonusTask2;

public class Pot {
	private int heightOfThePot;
	static int currentLevel = 0;
	Pot(int heightOfThePot){
		this.heightOfThePot = heightOfThePot;
	}
	public void incrCurrentLevel() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentLevel++;
	}
	public void setHeight( int heightOfThePot) {
		this.heightOfThePot = heightOfThePot;
	}
	public int getHeight() {
		return heightOfThePot;
	}
	public void empty() {
		currentLevel = 0;
	}
	public boolean isFull() {
		if(currentLevel == heightOfThePot) 
			return true;
		return false;
	}
}
