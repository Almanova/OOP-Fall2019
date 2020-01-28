package bonus;

public class Position {
	int y;
	int x;
	
	public Position(int y, char x) {
		convertToArrayIndices(y, x);
	}
	
	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public void convertToArrayIndices(int y, char x) {
		if (y == 1)
			this.y = 7;
		else if (y == 2)
			this.y = 6;
		else if (y == 3)
			this.y = 5;
		else if (y == 4)
			this.y = 4;
		else if (y == 5)
			this.y = 3;
		else if (y == 6)
			this.y = 2;
		else if (y == 7)
			this.y = 1;
		else
			this.y = 0;
		String alphabet = "ABCDEFGH";
		this.x = alphabet.indexOf(Character.toString(x));
	}
	
	@Override
	public boolean equals(Object o) {
		Position p = (Position) o;
		return this.x == p.x && this.y == p.y; 
	}
}
