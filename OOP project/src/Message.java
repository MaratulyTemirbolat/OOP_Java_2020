import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable,Cloneable,Comparable<Message>  {
	private boolean isRead = false;
	private String description;
	private Date dateOfTheSending;
	private String senderName;
	public Message() {
		
	}
	public Message(Date dateOfTheSending,String description,String senderName) {
		this.description = description;
		this.dateOfTheSending = dateOfTheSending;
		this.senderName = senderName;
	}
	public String getDescription() {
		return description;
	}
	public void readMessage() {
		isRead = true;
	}
	public boolean getIsRead() {
		return isRead;
	}
	public Date getDateOfTheSending() {
		return dateOfTheSending;
	}
	public String toString() {
		return description +"\n" +" Sender name is "+ senderName + "  " + dateOfTheSending ;
	}
	public String getSenderName() {
		return senderName;
	}
	public Object clone() throws CloneNotSupportedException {
		Message message = (Message)super.clone();
		message.dateOfTheSending =(Date)this.dateOfTheSending.clone();
		return message;
	}
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(!(o instanceof Message)) {
			return false;
		}
		Message mes = (Message)o;
		return this.description.equals(mes)&& this.senderName.equals(mes.senderName) && this.dateOfTheSending.equals(mes.dateOfTheSending);
	}
	public int hashCode() {
		int result = 17;
		result+= 31*description.hashCode();
		result+=31*senderName.hashCode();
		result+=31*dateOfTheSending.hashCode();
		return result;
	}
	public int compareTo(Message message) {
		return this.dateOfTheSending.compareTo(message.dateOfTheSending);
	}
}
