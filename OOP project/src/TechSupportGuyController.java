import java.io.IOException;

public class TechSupportGuyController extends EmployeeController {
	private TechSupportGuy supportGuy ;
	public TechSupportGuyController() {
		super();
	}
	public TechSupportGuyController(TechSupportGuy supportGuy) {
		super(supportGuy);
		this.supportGuy = supportGuy;
	}
	public String getOptions() {
		return super.getOptions() + "\n"
				+"10: View orders"+ "\n"+
				"11:Exit";
	}
	public String getOrderOptions() {
		return "1:Accept order" +"\n"+
				"2:Refuse order" +"\n"+
				"3:Previouse page";
	}
	public void doInterface(String choice) throws Exception {
		while(!super.option.equals("11")) {
			System.out.println(getOptions());
			super.option = super.in.readLine();
			if(super.option.equals("1") || super.option.equals("2") || super.option.equals("3") || super.option.equals("4")|| super.option.equals("5")|| super.option.equals("6")||super.option.equals("7")||super.option.equals("8") || super.option.equals("9")) {
				super.doInterface(super.option);
			}
			else if(super.option.equals("10")) {
					Order curOrder = supportGuy.viewUnAcceptedOrder();
					if(curOrder!=null) {
						decideOrder(curOrder);
					}
					else {
						System.out.println("Sorry there is not current orders!");
					}
			}
		}
	}
	public void decideOrder(Order curOrder) throws IOException {
		System.out.println("The current order is " + curOrder.getDescription());
		System.out.println("What will you do?");
		System.out.println(getOrderOptions());
		String decision = super.in.readLine();
		if(decision.equals("1")) {
			supportGuy.acceptOrder(curOrder);
			System.out.println("The order is accepted");
		}
		else if(decision.equals("2")) {
			decideOrder(supportGuy.rejectOrder(curOrder));
		}
		else if(decision.equals("3")) {
			return;
		}
	}
}
