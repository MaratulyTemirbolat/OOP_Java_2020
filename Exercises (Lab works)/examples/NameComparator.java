package examples;

import java.util.Comparator;

public class NameComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.nickname.compareTo(o2.nickname);
	}
	
}
