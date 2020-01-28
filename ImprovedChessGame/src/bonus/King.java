package bonus;

import java.lang.Math;

public class King extends Piece {

	public King(String unicode, Color color, int y, char x) {
		super(unicode, color, y, x);
	}
	
	public static boolean checkMoveInLine(Position a, Position b) {
		if ((a.getX() == b.getX() && Math.abs(a.getY() - b.getY()) == 1)|| 
			(a.getY() == b.getY() && Math.abs(a.getX() - b.getX()) == 1))
			return true;
		return false;
	}
	
	public static boolean checkMoveInDiagonal(Position a, Position b) {
		if (Math.abs(a.getX() - b.getX()) == Math.abs(a.getY() - b.getY()) &&
			Math.abs(a.getX() - b.getX()) == 1)
			return true;
		return false;
	}
	
	public boolean isLegalMove(Position a, Position b) {
		return checkMoveInLine(a, b) || checkMoveInDiagonal(a, b);
	}
}
