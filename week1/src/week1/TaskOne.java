package week1;

public class TaskOne {

	public static void main(String[] args) {
		Time t1 = new Time(8,90,65);
		//System.out.println(t1.toUniversal());
		Time t2 = new Time(23,90,70);
		//System.out.println(t2.toStandard());
		Time.sumOfTime(t1, t2);
	}
}
