package labThreeProbFour;
import java.util.Date;


//Подумать насчет hireDate	сортировка

public class Employee extends Person implements Comparable<Employee>,Cloneable {
	private double salary;
	private Date hireDate;
	private String insuranceNumber;
	public Employee() {
		super();
	}
	public Employee(String name,double salary,String insuranceNumber,Date hireDate) {
		super(name);
		this.salary = salary;
		this.insuranceNumber = insuranceNumber;
		this.hireDate = hireDate;
		}
	
	public boolean equals(Object o) {
		if(!(o instanceof Person)) {
			return false;
		}
		return ((Employee)o).salary == this.salary 
				&& this.insuranceNumber.equals(((Employee)o).insuranceNumber) 
				&& super.equals(o);
	}
	public int hashCode() {
		int result = 17;
		result+=31*salary;
		result+=31*hireDate.hashCode();
		result+=31*insuranceNumber.hashCode();
		return result;
	}
	public double getSalary() {
		return salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getinsuranceNumber() {
		return insuranceNumber;
	}
	public int compareTo(Employee employee) {
			
		if(salary>employee.salary)
			return 1;
		if(salary<employee.salary)
			return -1;
		return 0;
	}
	public String toString() {
		return super.toString() + " Your salary is " + salary + " The day when you were hired: " + hireDate + " Your insurance number: " + insuranceNumber;
	}
	public Object clone() throws CloneNotSupportedException {
		Employee e = (Employee)super.clone();
		e.hireDate = (Date)this.hireDate.clone();
		return e;
	}
}
