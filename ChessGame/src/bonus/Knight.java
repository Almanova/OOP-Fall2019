package bonus;

import java.util.ArrayList;

public class Knight extends Piece {
	public Knight(String color, Position position) {
		super(color);
		createUnicode(position);
	}
	
	public void createUnicode(Position position) {
		String unicode = "";
		if (this.color.equals("white")) {
			unicode = "\u2658";
		}
		else {
			unicode = "\u265E";
		}
		setUnicodeAndPosition(unicode, position);
	}
	
	public boolean checkInAvailableMoves(Position b, Board board) {
		availablemoves = new ArrayList<Position>();
		Position p;
		p = new Position(getPosition().y - 2, getPosition().x + 1);
		availablemoves.add(p);
		p = new Position(getPosition().y - 1, getPosition().x + 2);
		availablemoves.add(p);
		p = new Position(getPosition().y + 1, getPosition().x + 2);
		availablemoves.add(p);
		p = new Position(getPosition().y + 2, getPosition().x + 1);
		availablemoves.add(p);
		p = new Position(getPosition().y + 2, getPosition().x - 1);
		availablemoves.add(p);
		p = new Position(getPosition().y + 1, getPosition().x - 2);
		availablemoves.add(p);
		p = new Position(getPosition().y - 1, getPosition().x - 2);
		availablemoves.add(p);
		p = new Position(getPosition().y - 2, getPosition().x - 1);
		availablemoves.add(p);
		
		for (Position pos: availablemoves) {
			if (b.equals(pos))
				return true;
		}
		return false;
	}
}
