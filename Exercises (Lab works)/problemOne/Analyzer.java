package problemOne;
import java.util.Scanner;

public class Analyzer {
	Analyzer(){
	}
	void beginning() {
		Data data = new Data();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter number (Q to quit): ");
			String s = sc.nextLine();
			if(s.equals("Q")) {
				System.out.println("Average = "+data.returnAverage());
				System.out.println("Maximum = "+data.returnLargestData());
				break;
			}
			else {
				data.addData(Integer.parseInt(s));
			}
		}
		sc.close();
	}
}
