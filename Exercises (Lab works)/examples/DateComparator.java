package examples;

import java.util.Comparator;

public class DateComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.todayDate.compareTo(o2.todayDate);
	}
	
}
