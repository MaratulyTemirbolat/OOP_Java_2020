package labTwoProbFive;

public class Tester {

	public static void main(String[] args) {
		Circuit a  = new Resistor(3.0);
		Circuit b = new Resistor(3.0);
		Circuit c = new Resistor(6.0);
		Circuit d = new Resistor(3.0);
		Circuit e = new Resistor(4.0);
		Circuit f = new Series(a,b);
		f.applyPotentialDiff(20.0);
		Circuit g =new Parallel(c,d);
		Circuit h = new Series(g,e);
		g.applyPotentialDiff(16.0);
		System.out.println(h.getCurrent());
		System.out.println(h.getPotentialDiff());
		Circuit circuit = new Parallel(h,f);
		double R = circuit.getResistance();
		double P = circuit.getPower();
		double U = circuit.getPotentialDiff();
		double I = circuit.getCurrent();
		System.out.println("Your Resistance = "+R);
		System.out.println("Your Power = "+P);
		System.out.println("Your Voltage = "+ U);
		System.out.println("Your current = " + I);
	}

}
