package problem3;

public class Data {
	private double average;
	private double maximum;
	private int size;
	
	public Data() {
		average = 0;
		maximum = 0;
		size = 0;
	}
	
	public void getValue(double value) {
		if (size == 0) {
			average = value;
			maximum = value;
		}
		else {
			average = (average * size + value) / (size + 1);
			if (value > maximum)
				maximum = value;
		}
		size++;
	}
	
	public double getAverage() {
		return average;
	}
	
	public double getMaximum() {
		return maximum;
	}
	
	public static void main(String []args) {
		Analyzer analyzer = new Analyzer();
		analyzer.startAnalyzer();
	}
}
