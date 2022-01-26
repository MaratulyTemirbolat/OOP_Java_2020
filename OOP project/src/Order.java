import java.lang.*;
import java.util.*;
import java.io.Serializable;

public class Order implements Serializable, Cloneable,Comparable<Order>{

	private String description;
	private Date dayOfSending;
	private STATUS orderStatus;

	public Order() {

	}
	public Order(String description) {
		this.description = description;
		this.dayOfSending = new Date();
		orderStatus = STATUS.QUEUE;
	}

	public String toString() {
		return "Description is " + description + " Date of sending is " + dayOfSending;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public STATUS getStatus() {
		return orderStatus;
	}
	public void setStatus(STATUS orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getDescription() {
		return description;
	}
	public Date getDateOfSending() {
		return dayOfSending;
	}

	public int hashCode() {
		int result = 17;
		result+= 31*description.hashCode();
		result+= 31*dayOfSending.hashCode();
		return result;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Order))
			return false;
		Order order = (Order)o;
		return  this.description.equals(order.description) && this.dayOfSending.equals(order.dayOfSending);
	}
	public Object clone() throws CloneNotSupportedException {
		Order order = (Order)super.clone();
		order.dayOfSending = (Date)this.dayOfSending.clone();
		return order;
	}
	@Override
	public int compareTo(Order o) {
		if(this.description.length() > o.description.length())
			return 1;
		if(this.description.length() < o.description.length())
			return -1;
		return 0;
	}
}

