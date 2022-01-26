
public abstract class EmployeeController extends UserController {
	Employee employee;
	public EmployeeController() {
		super();
	}
	public EmployeeController(Employee employee) {
		super(employee);
		this.employee = employee;
	}
	public String  getOptions() {
		return super.getOptions() + "\n" +
				"8:View Salary" + "\n"+
				"9:View Insurance Number";
	}
	public void doInterface(String choice) throws Exception {
			super.doInterface(choice);
		
			if(choice.equals("8")) {
			System.out.println("Your salary is "+employee.getSalary() + " Tenge");
		}
			else if(choice.equals("9")) {
			System.out.println("Your insurance number is " + employee.getInsuranceNumber());
		}
	}
	
	
}
