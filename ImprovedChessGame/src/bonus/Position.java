package bonus;

public class Position {
	private int y;
	private int x;
	
	public Position(int y, char x) {
		convertToArrayIndices(y, x);
	}
	
	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void convertToArrayIndices(int y, char x) {
		String numbers = "87654321";
		this.y = numbers.indexOf(y + "");
		String alphabet = "ABCDEFGH";
		this.x = alphabet.indexOf(Character.toString(x));
	}
}
