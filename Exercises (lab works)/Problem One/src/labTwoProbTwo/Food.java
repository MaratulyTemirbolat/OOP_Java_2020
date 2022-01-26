package labTwoProbTwo;
//EQUALS    ^^
//HashCode  ^^
//Override superClassMethod  ^^
//Check quality of the EQUALS and HASHCODE by adding to HashSet
//Demonstrate polymorphism using the overridden method
public abstract class Food {
	String taste;
	Food(){
	}
	Food(String taste){
		this.taste = taste;
	}
	public abstract int calorieContent();
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Food))
			return false;
		Food food = (Food)o;
		return this.taste.equals(food.taste);
	}
	public int hashCode() {
		int result = 17;
		result+=31*taste.hashCode();
		return result;
	}
}
