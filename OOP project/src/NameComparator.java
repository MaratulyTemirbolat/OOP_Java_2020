
import java.util.Comparator;

public class NameComparator implements Comparator<User>{
	public int compare(User us1, User us2) {
		return us1.getName().compareTo(us2.getName());
	}
}
