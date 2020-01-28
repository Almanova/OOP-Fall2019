package bonus;

public class Bishop extends Piece {
	
	public Bishop (String unicode, Color color, int y, char x) {
		super(unicode, color, y, x);
	}
	
	public boolean isLegalMove(Position a, Position b) {
		return super.checkMoveInDiagonal(a, b) && super.checkForPiecesInDiagonal(a, b, Game.getBoard());
	}
}
