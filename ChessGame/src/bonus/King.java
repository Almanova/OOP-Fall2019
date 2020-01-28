package bonus;

import java.util.ArrayList;

public class King extends Piece {
	
	public King(String color) {
		super(color);
		createUnicodeAndPosition();
	}
	
	public void createUnicodeAndPosition() {
		String unicode = "";
		Position position;
		if (this.color.equals("white")) {
			unicode = "\u2654";
			position = new Position(1, 'E');
		}
		else {
			unicode = "\u265A";
			position = new Position(8, 'E');
		}
		setUnicodeAndPosition(unicode, position);
	}
	
	public boolean checkInAvailableMoves(Position b, Board board) {
		this.availablemoves = new ArrayList<Position>();
		Position p;
		availablemoves.add(new Position(getPosition().y - 1, getPosition().x));
		p = new Position(getPosition().y - 1, getPosition().x + 1);
		availablemoves.add(p);
		p = new Position(getPosition().y, getPosition().x + 1);
		availablemoves.add(p);
		p = new Position(getPosition().y + 1, getPosition().x + 1);
		availablemoves.add(p);
		p = new Position(getPosition().y + 1, getPosition().x);
		availablemoves.add(p);
		p = new Position(getPosition().y + 1, getPosition().x - 1);
		availablemoves.add(p);
		p = new Position(getPosition().y, getPosition().x - 1);
		availablemoves.add(p);
		p = new Position(getPosition().y - 1, getPosition().x - 1);
		availablemoves.add(p);
		
		for (Position pos: availablemoves) {
			if (b.equals(pos))
				return true;
		}
		return false;
	}
}
