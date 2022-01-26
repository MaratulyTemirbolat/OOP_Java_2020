package inheritenceProblemTwo;

public class Staff extends Person{
	private String school;
	private double pay;
	public Staff() {
		super();
	}
	public Staff(String name, String address, String school, double pay) {
		super(name,address);
		this.school = school;
		this.pay = pay;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public String toString() {
		return super.toString() + " , school = " + school + " ,pay = " + pay;
	}
	public boolean equals(Object o) {
		return super.equals(o) && this.school.equals(((Staff)o).school);
	}
	public int hashCode() {
		int result = 17;
		result+=31*pay;
		return super.hashCode() + result; 
	}
	@Override
	public void jump() {
		System.out.println("The Staff is jumping");
		
	}
}
