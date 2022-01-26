package week1;

public class Time {
	int hour;
	int minute;
	int second;
	public String stHour="";
	public String stMin="";
	public String stSec="";
	public Time () {
		
	}
	public Time(int hour,int minute,int second) {
		if(hour<0||minute<0||second < 0) {
			System.out.println("Error");
			return;
		}
		else
			setTime(hour,minute,second);	
	}
	public  void setTime(int hour,int minute,int second) {
		this.minute = minute + (second/60);
		this.second = second%60;
		this.hour = hour + (this.minute/60);
		this.minute = (this.minute%60);
		stHour = this.hour+"";
		stMin = this.minute+"";
		stSec = this.second+"";
		if(this.hour<10)
			stHour = "0"+this.hour;
		if(this.minute<10)
			stMin = "0"+this.minute;
		if(this.second<10)
			stSec = "0"+this.second;
			
	}
	public String toUniversal() {
			return stHour+":"+stMin+":"+stSec;
	}
	public String toStandard() {

	}
	public static void sumOfTime(Time t1, Time t2) {
		int newHour = t1.hour + t2.hour;
		int newMin = t1.minute + t2.minute;
		int newSec = t1.second + t2.second;
		Time tNew = new Time(newHour,newMin,newSec);
		System.out.println(tNew.toStandard());
	}
}
