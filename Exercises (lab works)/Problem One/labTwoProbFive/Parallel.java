package labTwoProbFive;

public class Parallel extends Circuit {
	Circuit resistorOne,resistorTwo;
	Parallel(){
		super();
	}
	Parallel(Circuit resistorOne,Circuit resistorTwo){
		this.resistorOne = resistorOne;
		this.resistorTwo = resistorTwo;
	}
	public double getResistance() {
		return (resistorOne.getResistance()*resistorTwo.getResistance())/(resistorOne.getResistance()+resistorTwo.getResistance());
	}
	public double getPotentialDiff() {
		return resistorOne.getPotentialDiff();
	}
	public void applyPotentialDiff(double V) {
		resistorOne.applyPotentialDiff(V);
		resistorTwo.applyPotentialDiff(V);
	}
}
