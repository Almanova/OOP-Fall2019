package problem1;

public class Temperature {
	private double value;
	private char scale;
	
	public Temperature(char scale) {
		setScale(scale);
	}
	
	public Temperature(double value) {
		setValue(value);
	}
	
	public Temperature(double value, char scale) {
		setValueAndScale(value, scale);
	}
	
	public Temperature() {
		this.value = 0;
		this.scale = 'C';
	}
	
	public void setValue(double value) {
		this.value = value;
		this.scale = 'C';
	}
	
	public void setScale(char scale) {
		this.scale = scale;
		this.value = 0;
	}
	
	public void setValueAndScale(double value, char scale) {
		this.value = value;
		this.scale = scale;
	}
	
	public String toCelcius() {
		String temp = "";
		if (scale == 'C') {
			temp += "" + value;
			temp += scale;
		}
		else {
			temp += "" + (5 * (value - 32) / 9);
			temp += "C";
		}
		return temp;
	}
	
	public String toFahrenheit() {
		String temp = "";
		if (scale == 'F') {
			temp += "" + value;
			temp += scale;
		}
		else {
			temp += "" + (9 * (value / 5) + 32);
			temp += "F";
		}
		return temp;
	}
	
	public char getScale() {
		return scale;
	}
	
	public static void main(String []args) {
		Temperature t = new Temperature(20);
		System.out.println(t.toCelcius() + " " + t.toFahrenheit());
		System.out.println(t.getScale());
	}
}
