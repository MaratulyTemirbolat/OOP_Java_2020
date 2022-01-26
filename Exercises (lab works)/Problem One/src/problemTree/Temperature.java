package problemTree;

public class Temperature {
	private double value;
	private char scale;
	
	Temperature(){
		value = 0;
		scale = 'C';
	}
	Temperature(double value){
		this.value = value;
	}
	Temperature(char scale){
		this.scale = scale;
	}
	Temperature(double value,char scale){
		this.value = value;
		this.scale = scale;
	}
	double degreesC() {
		if(scale=='F') {
			return (5*(value-32))/9;
		}
		return value;
	}
	double degreesF() {
		if(scale=='C') {
			return (9*(value/5.0))+32;
		}
		return value;
	}
	void setValue(double value) {
		this.value = value;
	}
	void setScale(char scale) {
		this.scale = scale;
	}
	void setValueAndScale(double value,char scale) {
		this.value = value;
		this.scale =scale;
	}
	double returnValue() {
		return value;
	}
	char returnScale() {
		return scale;
	}
}
