package labTwoProbTwo;

public class Apple extends Food {
	int amountOfFerrum;
	Apple (){
		super();
	}
	Apple(String taste, int amountOfFerrum){
		super(taste);
		this.amountOfFerrum = amountOfFerrum;
	}
	public int calorieContent() {
		return 52;
	}
	public boolean equals(Object o) {
		if(!(o instanceof Apple))
			return false;
		return ((Apple)o).amountOfFerrum == this.amountOfFerrum && super.equals(o);
	}
	public int hashCode() {
		int result = super.hashCode();
		result += 31*amountOfFerrum;
		return (result);
	}
	public String toString() {
		return taste + " " + amountOfFerrum;
	}
}
