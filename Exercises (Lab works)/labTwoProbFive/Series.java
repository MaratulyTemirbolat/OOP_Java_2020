package labTwoProbFive;

public class Series extends Circuit {
	Circuit resistorOne,resistorTwo;
	Series(){
		super();
	}
	Series(Circuit resistorOne,Circuit resistorTwo){
		this.resistorOne = resistorOne;
		this.resistorTwo = resistorTwo;
	}
	public  double getResistance() {
		return (resistorOne.getResistance() + resistorTwo.getResistance());
	}
	public  double getPotentialDiff() {
		return (resistorOne.getPotentialDiff() + resistorTwo.getPotentialDiff());
	}
	public void applyPotentialDiff(double V) {
		double voltageOnResistorOne = V*(resistorOne.getResistance()/(resistorOne.getResistance()+resistorTwo.getResistance()));
		double valtageOnResistorTwo = V*(resistorTwo.getResistance()/(resistorOne.getResistance()+resistorTwo.getResistance()));
		resistorOne.applyPotentialDiff(voltageOnResistorOne);
		resistorTwo.applyPotentialDiff(valtageOnResistorTwo);
	}
	
	
}
