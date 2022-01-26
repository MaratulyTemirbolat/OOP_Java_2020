package threadsBonusTask6;

public class Flower {
	private String name;
	private boolean isWatered;
	Flower(){
		
	}
	Flower(String name){
		this.name = name;
		isWatered = true;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void water() {
		isWatered = true;
	}
	public void dry() {
		isWatered = false;
	}
	public boolean isWatered() {
		return isWatered;
	}
	
}
