package problemFive;

import java.util.Vector;

public class DragonLaunch {
	Vector<Person> humanity;
	boolean isEaten = false;
	DragonLaunch(){	
		humanity = new Vector<Person>();
		}
	public void kidnap(Person p) {
		if(p.gen == Gender.GIRL) {
			if(humanity.size()==0)
				isEaten = true;
			else {
				int lastElem = (humanity.size()-1);
				humanity.remove(lastElem);
			}
		}
		else
			humanity.add(p);
		System.out.println(humanity.size());
		
	}
	boolean willDragonEatOrNot(){
		return isEaten;
	}
}
