package bonus;

import java.lang.Math;

public class Knight extends Piece {
	
	public Knight(String unicode, Color color, int y, char x) {
		super(unicode, color, y, x);
	}
	
	public boolean isLegalMove(Position a, Position b) {
		if ((Math.abs(a.getX() - b.getX()) == 1 && Math.abs(a.getY() - b.getY()) == 2) ||
			(Math.abs(a.getX() - b.getX()) == 2 && Math.abs(a.getY() - b.getY()) == 1))
			return true;
		return false;
	}
}
