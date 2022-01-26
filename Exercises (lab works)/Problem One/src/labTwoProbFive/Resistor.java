package labTwoProbFive;

public class Resistor extends Circuit {
	private double resistance;
	private double pottentialDifference;
	Resistor(){
		super();
	}
	Resistor(double resistance){
		this.resistance = resistance;
	}
	
	public double getPotentialDiff() {
		return pottentialDifference;
	}
	
	public void applyPotentialDiff(double V) {
		pottentialDifference = V;
	}
	public double getResistance() {
		return resistance;
	}
	
}
