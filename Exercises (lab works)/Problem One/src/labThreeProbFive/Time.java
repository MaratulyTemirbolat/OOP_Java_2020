package labThreeProbFive;

public class Time implements Comparable<Time> {
	private int hour,minute,second;
	Time(){
		
	}
	Time(int hour,int minute,int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.hour+=(minute/60);
		this.minute = (minute%60);
	}
	public void setSecond(int second) {
		this.minute+=(second/60);
		this.second = (second%60);
		setMinute(this.minute);
	}
	public int compareTo(Time t) {
		if(hour > t.hour)
			return 1;
		if(hour<t.hour)
			return -1;
		if(minute>t.minute)
			return 1;
		if(minute<t.minute)
			return -1;
		if(second>t.second)
			return 1;
		if(second<t.second)
			return -1;
		return 0;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public String toUniversal() {
		return getHour()+":"+getMinute()+":"+getSecond();   // ÄÎÐÀÁÎÒÀÒÜ äëÿ íîëèêîâ
	}
	public void add(Time t) {
		setHour(this.hour+t.hour);
		setMinute(this.minute+ t.minute);
		setSecond(this.second + t.second);
		
	}
	public String toStandard() { //  ÄÎÐÀÁÎÒÀÒÜ äëÿ íîëèêîâ
		if(hour<12)
			return getHour()+":"+getMinute()+":"+getSecond()+" AM";
		return getHour()+":"+getMinute()+":"+getSecond()+" PM";
	}
	public String toString() {
		return "Hours: " + hour + " Minutes: " + minute + " Seconds: "+ second;
	}
	
}
