package bonus;

public class Queen extends Piece {
	
	public Queen(String unicode, Color color, int y, char x) {
		super(unicode, color, y, x);
	}
	
	public boolean isLegalMove(Position a, Position b) {
		boolean check;
		if (a.getX() == b.getX() || a.getY() == b.getY()) {
			check = super.checkForPiecesInLine(a, b, Game.getBoard());
		}
		else {
			check = super.checkForPiecesInDiagonal(a, b, Game.getBoard());
		}
		return (super.checkMoveInLine(a, b) || super.checkMoveInDiagonal(a, b)) &&
			check;
	}
}
