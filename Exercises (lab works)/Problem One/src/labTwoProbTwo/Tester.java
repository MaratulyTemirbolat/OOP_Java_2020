package labTwoProbTwo;
import java.util.HashSet;
public class Tester {

	public static void main(String[] args) {
		HashSet<Food> food = new HashSet<Food>();
		Food f1 = new Apple("sweet",52);
		Food f2 = new Apple("sweet",52);
		food.add(f1);
		food.add(f2);
		System.out.println(food);
		System.out.println(f1.getClass());
	}

}
