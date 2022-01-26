package labThreeProbFour;

import java.util.Date;
import java.util.Vector;
import java.util.Collections;

public class Tester {

	public static void main(String[] args) {
		Vector<Employee> employees = new Vector<Employee>();
		Vector<Manager> managers = new Vector<Manager>();
		Employee em1 = new Employee("Rem",200000.0,"18BD",new Date(1920,6,13));
		Employee em2 = new Employee("Ram",100000.0,"19BD",new Date(1900,8,16));
		Employee em3 = new Employee("Rom",100000.0,"19BD",new Date(2000,11,16));
		Manager man1 = new Manager("Emilia",50000.0,"20BD",new Date(2020,10,20),15);
		Manager man2 = new Manager("Subaru",10000.0,"21BD",new Date(2020,10,20),17);
		Manager man3 = new Manager("Puk",12.0,"22BD",new Date(2019,10,20),20);//String name,double salary,String insuranceNumber,Date hireDate,int bonus
		try {
		em2 =(Employee)em3.clone();
		em2.setName("Rias");
		}
		catch(CloneNotSupportedException e){
			System.out.println("Employee Can't be cloneable");
		}
		try {
			man2 = (Manager)man1.clone();
			man2.setName("Asia");
		}
		catch(CloneNotSupportedException e) {
			
			System.out.println("Manager can't be cloneable");
		}
		employees.add(em1);
		employees.add(em2);
		employees.add(em3);
		managers.add(man1);
		managers.add(man2);
		managers.add(man3);
		
		Collections.sort(employees,new NameComparator());
		for(Employee employee:employees) {
			System.out.println(employee);
		}
		Collections.sort(employees,new HireDateComparator());
		for(Employee employee:employees) {
			System.out.println(employee);
		}
		
		System.out.println();
		Collections.sort(managers,new NameComparator());
		for(Manager manager:managers) {
			System.out.println(manager);
		}
		Collections.sort(managers,new HireDateComparator());
		for(Manager manager:managers) {
			System.out.println(manager);
		}
	}

}
