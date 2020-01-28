package bonus;

import java.util.ArrayList;

abstract class Piece {
	private String unicode;
	String color;
	private Position position;
	ArrayList<Position> availablemoves;

	{
		availablemoves = new ArrayList<Position>();
	}

	public Piece(String color) {
		this.color = color;
	}

	public Position getPosition() {
		return this.position;
	}

	public String getUnicode() {
		return unicode;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public abstract boolean checkInAvailableMoves(Position b, Board board);

	public void setUnicodeAndPosition(String unicode, Position position) {
		this.unicode = unicode;
		this.position = position;
	}
}
