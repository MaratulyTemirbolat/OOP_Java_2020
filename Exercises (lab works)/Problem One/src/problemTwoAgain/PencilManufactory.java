package problemTwoAgain;

public class PencilManufactory {
	Colours colou;
	static int currentNumberOforders;
	final String HOLIDAY = "SUNDAY";
	private int amountOfPencils; 
	private TypeOrder type;
	private String currentDay;
	{
		type = TypeOrder.OFFLINE;
	}
	PencilManufactory(){
		currentNumberOforders++;
	}
	PencilManufactory(Colours colou,int amountOfPencils,String currentDay){
		this();
		this.colou = colou;
		this.amountOfPencils = amountOfPencils;
		this.currentDay = currentDay;
	}
	public void addOrder(int amountOfPencils,String currentDay) {
		if(HOLIDAY.equals(currentDay)) {
			System.out.println("Sorry, but we do not work today!");
		}
		else {
			System.out.println("Okay. We will add " + amountOfPencils +" black pencils.");
		}
	}
	public void addOrder(int amountOfPencils,String currentDay,Colours colou) {
		if(HOLIDAY.equals(currentDay)) {
			System.out.println("Sorry, but we do not work today!");
		}
		else {
			if(colou == Colours.BLACK){
				System.out.println("Okay. We will add " + amountOfPencils +" black pencils.");
			}
			if(colou == Colours.BLUE) {
				System.out.println("Okay. We will add " + amountOfPencils +" blue pencils.");
			}
			if(colou == Colours.RED) {
				System.out.println("Okay. We will add " + amountOfPencils +" red pencils.");
			}
		}
	}
	String getData() {
		return currentDay+" "+ amountOfPencils;
	}
}
