package bonus;

import java.lang.Math;

abstract class Piece {
	private String unicode;
	private Color color;
	private Position position;
	
	public Piece(String unicode, Color color, int y, char x) {
		this.unicode = unicode;
		this.color = color;
		Position position = new Position(y, x);
		this.position = position;
	}
	
	public Piece(String unicode, Color color, Position position) {
		this.unicode = unicode;
		this.color = color;
		this.position = position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String getUnicode() {
		return unicode;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public static boolean checkMoveInLine(Position a, Position b) {
		if (a.getX() == b.getX() || a.getY() == b.getY())
			return true;
		return false;
	}
	
	public static boolean checkMoveInDiagonal(Position a, Position b) {
		if (Math.abs(a.getX() - b.getX()) == Math.abs(a.getY() - b.getY()))
			return true;
		return false;
	}
	
	public boolean isCurrentPlayer() {
		if (this.color == Game.getColor())
			return true;
		return false;
	}
	
	public static boolean checkForPiecesInDiagonal(Position a, Position b, Board board) {
		Values values = new Values(a, b);
		int miny = values.getMinY(), minx = values.getMinX();
		while (miny < values.getMaxY() && minx < values.getMaxX()) {
			miny++;
			minx++;
			if (board.representation[miny][minx] != null)
				return false;
		}
		return true;
	}
	
	public static boolean checkForPiecesInLine(Position a, Position b, Board board) {
		Values values = new Values(a, b);
		int miny = values.getMinY(), minx = values.getMinX();
		if (a.getX() == b.getX()) {
			while (miny < values.getMaxY()) {
				miny++;
				if (miny == values.getMaxY())
					break;
				if (board.representation[miny][a.getX()] != null)
					return false;
			}
		}
		else if (a.getY() == a.getY()) {
			while (minx < values.getMaxX()) {
				minx++;
				if (minx == values.getMaxX())
					break;
				if (board.representation[a.getY()][minx] != null)
					return false;
			}
		}
		return true;
	}
	
	abstract public boolean isLegalMove(Position a, Position b);
}
