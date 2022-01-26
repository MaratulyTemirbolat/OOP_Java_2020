package problemOne;

public class Data {
	private double max = Double.MIN_VALUE;
	private double aver= 0;
	private int amountOfNumbers = 0;
		public Data(){
		}
		public void addData(int data) {
			max = Math.max(data, max);
			amountOfNumbers++;
			aver+=data;
		}
		 public double returnAverage() {
			 if(amountOfNumbers == 0)
			return 0.0;
			 return aver/amountOfNumbers;
		}
		 public void setAverage(double aver) {
			 this.aver = aver;
		 }
		 
		public double returnLargestData() {
			return max;
		}
		
}
