import java.lang.*;
import java.lang.String[3];
/**
*/
public abstract class User implements Cloneable, Serializable, Comparable {
/**
*/
private String name;
/**
*/
private String surname;
/**
*/
private String middleName;
/**
*/
private String login;
/**
*/
private String password;
/**
*/
private String id;
/**
*/
private String[3] previousPasswords;
/**
 * @return 
*/
public String getName() {
    return null;
}
/**
 * @return 
*/
public String getSurname() {
    return null;
}
/**
 * @return 
*/
public String getMiddleName() {
    return null;
}
/**
 * @return 
*/
public String getID() {
    return null;
}
/**
 * @param name 
*/
public void setName(String name) {
}
/**
 * @param surname 
*/
public void setSurname(String surname) {
}
/**
 * @param password 
 * @param login 
 * @return 
*/
public boolean enterAccount(String login, String password) {
    return false;
}
/**
 * @param newPassword 
*/
private void changePassword(String newPassword) {
}
/**
 * @param newPassword 
 * @return 
*/
public boolean restorePassword(String newPassword) {
    return false;
}
/**
 * @return 
*/
public String toString() {
    return null;
}
/**
 * @return 
*/
public int hashCode() {
    return 0;
}
/**
 * @param o 
 * @return 
*/
public boolean equals(Object o) {
    return false;
}
/**
 * @param typeProblem 
*/
public void sendOrderToITGuy(int typeProblem) {
}
/**
 * @param order 
*/
public void sendOrder(Order order) {
}
/**
 * @param o 
 * @return 
*/
public int compareTo(Object o) {
    return 0;
}
/**
 * @param user 
*/
public void saveUser(User user) {
}
/**
 * @return 
*/
public User viewUser() {
    return null;
}
}

