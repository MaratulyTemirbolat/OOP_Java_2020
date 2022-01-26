package labThreeProbFive;

public class Chocolate implements Comparable<Chocolate> {
	private double weight;
	private String name;
	Chocolate(){
		
	}
	Chocolate(double weight,String name){
		this.name = name;
		this.weight = weight;
	}
	public String toString() {
		return "The Name is " + name+ " and the weight is " + weight;
	}
	public double getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int compareTo(Chocolate c) {
		if(this.weight > c.weight)
			return 1;
		if(this.weight<c.weight)
			return -1;
		return 0;
	}

}
