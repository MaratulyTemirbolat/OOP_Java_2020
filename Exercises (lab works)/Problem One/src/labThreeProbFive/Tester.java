package labThreeProbFive;

public class Tester {
 // œ–Œ“≈—“»–Œ¬¿“‹ COMPARABLE
	public static void main(String[] args) {
		Time t1 = new Time(24,113,67);
		Time t2 = new Time(25,65,73);
		Time t3 = new Time(23, 40,55);
		
		System.out.println(t1.toUniversal());
		System.out.println(t2.toUniversal());
		Chocolate choco1 = new Chocolate(20.0,"Baunti");
		Chocolate choco2 = new Chocolate(10.0,"Twix");
		Chocolate choco3 = new Chocolate(100.0,"Snickers");
		Chocolate[] chocolates = {choco1,choco2,choco3};
		try{Sort.mergeSort(chocolates, 0, (chocolates.length-1));}
		catch(Exception e) {
			System.out.println(e);
		}
		//Sort.bubbleSort(chocolates);
		//Sort.quickSort(chocolates);
		for(int k=0;k<chocolates.length;k++) {
			System.out.println(chocolates[k]);
		}
		Time[] times = {t1,t2,t3};
		Sort.bubbleSort(times);
		for(int k=0;k<times.length;k++) {
			System.out.println(times[k]);
		}
	}

}
