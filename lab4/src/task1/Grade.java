package task1;

public class Grade {
	private double numerical;
	private char letter;
	
	public Grade(double numerical) {
		this.numerical = numerical;
		this.letter = 'F';
	}
	
	public double getNumerical() {
		return numerical;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public void setNumerical(double numerical) {
		this.numerical = numerical;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public void determineLetter(Grade best) {
		double[] nums = new double[4];
		char[] letters = {'A', 'B', 'C', 'D'};
		for (int i = 0; i < 4; i++) {
			nums[i] = best.getNumerical() - 10 * (i + 1);
		}
		for (int i = 0; i < 4; i++) {
			if (this.getNumerical() >= nums[i]) {
				this.setLetter(letters[i]);
				break;
			}
		}
	}
}
