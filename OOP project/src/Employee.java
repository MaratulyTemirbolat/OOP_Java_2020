import java.util.*;
import java.io.Serializable;
import java.lang.*;


public abstract class Employee extends User implements Serializable  { 
	private double salary;
	private Date hireDate;
	private String insuranceNumber;
	
	public Employee() {
		super();
	}
	public Employee(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber) {
		super(name,surname,middleName,login,password,id,restoreAnswer);
		this.salary = salary;
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
	}

	public String toString() {
		return super.toString() + " Salary is : " + salary + " hire date is : " + hireDate + " Insurance number is : " + insuranceNumber ;
	}
	
	public boolean equals(Object o) {
			if(!super.equals(o))
			return false;
			Employee employee = (Employee)o;
			return this.salary == employee.salary && this.insuranceNumber.equals(employee.insuranceNumber);
	}
	
	public int hashCode() {
		int result = super.hashCode();
		result += 31*salary;
		result += 31*insuranceNumber.hashCode();
		return result;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Date getHireDate() {
		return hireDate;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public int compareTo(User user) {
		if(super.compareTo(user)>0)
			return 1;
		if(super.compareTo(user)<0)
			return -1;
		Employee employee = (Employee)user;
		if(this.salary>employee.salary)
			return 1;
		if(this.salary<employee.salary)
			return -1;
		return 0;
	}
	public Object clone() throws CloneNotSupportedException {
		Employee employee = (Employee)super.clone();
		employee.hireDate = (Date)this.hireDate.clone();
		return employee;
		
	}
}

