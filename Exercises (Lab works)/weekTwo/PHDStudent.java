package weekTwo;

public class PHDStudent extends Student {
	int articleNumber;
	PHDStudent(){
		
	}
	PHDStudent(String name,String id, double mark,int articleNumber){
		super(name,id,mark);
		this.articleNumber = articleNumber;
	}
	public int compareTo(Student o) {
		PHDStudent p = (PHDStudent)o;
		if(articleNumber > p.articleNumber)
			return 1;
		if(articleNumber < p.articleNumber)
			return -1;
			return super.compareTo(o);
	}
	
}
