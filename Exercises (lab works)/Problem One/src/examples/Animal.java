package examples;
import java.util.Date;
//Marker interface --> Empty interface
public  class Animal extends Object implements Runnable,Comparable<Animal>,Cloneable{
	String nickname;
	int age;
	Date todayDate = new Date();
	public void run() {
		System.out.println("The animal is running");
	}
	public void breathe() {
		
	}
	public void move() {
		
	}
	@Override
	public int compareTo(Animal a) {
		if(this.age >a.age) {
			return 50;
		}
		if(this.age<a.age) {
			return -50;
		}
		if(this.nickname.compareTo(a.nickname)>0) {
			return 100;
		}
		if(this.nickname.compareTo(a.nickname)<0) {
			return -200;
		}
		if(this.todayDate.compareTo(a.todayDate)>0) {
			return 500;
		}
		if(this.todayDate.compareTo(a.todayDate)<0) {
			return -122;
		}
		return 0;
	}
	public Object clone() throws CloneNotSupportedException {
		Animal animal = (Animal)super.clone();
		animal.todayDate = (Date)this.todayDate.clone();
		return animal;
	}
}
