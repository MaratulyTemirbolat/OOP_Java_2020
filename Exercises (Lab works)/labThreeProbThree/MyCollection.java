package labThreeProbThree;


public interface MyCollection {
	public boolean add(Object o);
	public void clear();
	public boolean isEmpty();
	public boolean remove(Object o);
	public int size();
	public boolean contains(Object o);
	public boolean equals(Object o);
	public Object[] toArray(); // Return a new array containing references to all the elements of the collection
	public int hashCode();
}
