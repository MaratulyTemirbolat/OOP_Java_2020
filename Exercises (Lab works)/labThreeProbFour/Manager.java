package labThreeProbFour;
import java.util.Date;
import java.util.Vector;

public class Manager extends Employee{
	public Vector<Employee> employees;
	private int bonus;
	{
		employees = new Vector<Employee>(); 
	}
	Manager(){
		super();
	}
	Manager(String name,double salary,String insuranceNumber,Date hireDate,int bonus){
		super(name,salary,insuranceNumber,hireDate);
		this.bonus = bonus;
	}
	
	public String toString() {
		return super.toString() + " Your bonus points: " + bonus;
	}
	public void add(Employee employee) {
		employees.add(employee);
	}
	public Vector<Employee> getEmployees(){
		return employees;
	}
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null) {		// ask for equals
			return false;
		}
		if(!(o instanceof Manager)) {
			return false;
		}
		Manager manager = (Manager)o;
		return this.getName() == manager.getName() && this.bonus == manager.bonus;
	}
	public int hashCode() {
		int result = super.hashCode();
		result += 31*bonus;
		return result;
	}
	public int compareTo(Manager manager) { // Спросить вопрос про супер в компараторах
		if(super.compareTo(manager)!=0)
			return super.compareTo(manager);
		if(this.bonus > manager.bonus) {
			return 1;
		}
		if(this.bonus < manager.bonus) {
			return -1;
		}
		return 0;
	}
	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException {
		Manager manager = (Manager)super.clone();
		manager.setHireDate((Date)this.getHireDate().clone());
		manager.employees =	(Vector<Employee>)this.employees.clone();
		return manager;
	}
}
