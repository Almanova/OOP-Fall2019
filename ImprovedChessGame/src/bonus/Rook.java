package bonus;

public class Rook extends Piece {

	public Rook(String unicode, Color color, int y, char x) {
		super(unicode, color, y, x);
	}
	
	public boolean isLegalMove(Position a, Position b) {
		return super.checkMoveInLine(a, b) && super.checkForPiecesInLine(a, b, Game.getBoard());
	}
}
