import java.io.Serializable;
import java.lang.*;
import java.util.Date;
import java.util.Vector;
public class TechSupportGuy extends Employee implements Serializable { 	//ƒŒœ»—¿“‹?

	/**
	 *  Current order - vector for orders
	 */
	private static Vector<Order> currentOrders;
	{
		currentOrders = new Vector<Order>();
	}
	public TechSupportGuy() {
		super();
	}
	/**
	 * Teach support guy constructor the current instance of the parent class.
	 * @param name Name of the guy
	 * @param surname Surnam of the guy
	 * @param middleName Middle name of the guy
	 * @param password password of the guy
	 * @param id id of the guy
	 * @param restoreAnswer restore answer of the guy
	 * @param salary income of the guy
	 * @param hireDate the date when the guy started working
	 * @param insuranceNumber insurance number of the guy
	 */	
	public TechSupportGuy(String name, String surname, String middleName,String login,String password,String id,String restoreAnswer,double salary,Date hireDate,String insuranceNumber) {
		super( name, surname,  middleName,login,password,id, restoreAnswer,salary,hireDate, insuranceNumber);
	}
	/**Add order in current order.
	 * @return current order with new add orders
	 */
	public static boolean addOrder(Order order) {
		return currentOrders.add(order);
	}
	/**View current orders
	 * @return current orders
	 */
	public Vector<Order> viewCurrentOrders() {
		return currentOrders;
	}
	/**View and accept orders. Cur order run in curent orders and compare.
	 * @return if they status not equal :curOrder else null.
	 */
	public Order viewUnAcceptedOrder() {
		Order ord = null;
		for(Order curOrder:currentOrders) {
			if(curOrder.getStatus() != STATUS.ACCEPTED) {
				ord = curOrder;
				return ord;
			}
		}
		return ord;
	}
	/**Accept order
	 * @return if status accepted than in current order remove order return :1  else :-1
	 * @param order accepted order.
	 */
	public boolean acceptOrder(Order order) {
		if(order.getStatus() != STATUS.ACCEPTED) {
		order.setStatus(STATUS.ACCEPTED);
		currentOrders.remove(order);
		System.out.println("The order " + order.getDescription() + " is accepted ");
		return true;
		}
		return false;
	}
	/**
	 * @return if cur order equal order return number of equal element
	 * @param order rejected order
	 */
	public Order rejectOrder(Order order) { //Õ¿œ»—¿“‹ œŒ ¿«€¬¿Õ»≈ —À≈ƒ”ﬁŸ≈√Œ Œ–ƒ≈–¿
		if(order.getStatus()!=STATUS.DECLINED) {
		order.setStatus(STATUS.DECLINED);
		int cnt = 0;
		for(Order curOrder: currentOrders) {
			if(curOrder.equals(order)) {
				cnt++;
				return currentOrders.elementAt(cnt);
			}
			cnt++;
		}
		}
		return null;
	}
	/**
	 * @return the string of the parent class.
	 */
	public String toString() {
		return super.toString();
	}
	/**
	 * @return The current instance of the parent class returns the number of the memory location where it is stored.
	 */
	public int hashCode() {
		return super.hashCode();
	}
	/**
	 * @return return the equals method of the parent class.
	 * @param o Object field.
	 */

	public boolean equals(Object o) {
		return super.equals(o);
	}
	
}

