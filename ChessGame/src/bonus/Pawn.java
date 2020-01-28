package bonus;

import java.util.ArrayList;

public class Pawn extends Piece {
	boolean tookfirstmove;
	boolean capturing;
	
	public Pawn(String color, Position position) {
		super(color);
		createUnicode(position);
		this.tookfirstmove = false;
		this.capturing = false;
	}
	
	public void createUnicode(Position position) {
		String unicode = "";
		if (this.color.equals("white")) {
			unicode = "\u2659";
		}	
		else {
			unicode = "\u265F";
		}
		setUnicodeAndPosition(unicode, position);
	}
	
	public boolean checkInAvailableMoves(Position b, Board board) {
		availablemoves = new ArrayList<Position>();
		
		if (color.equals("white") && !tookfirstmove && !capturing) {
			availablemoves.add(new Position(getPosition().y - 1, getPosition().x));
			availablemoves.add(new Position(getPosition().y - 2, getPosition().x));
		}
		else if (color.equals("white") && tookfirstmove && !capturing) {
			availablemoves.add(new Position(getPosition().y - 1, getPosition().x));
		}
		else if (color.equals("white") && capturing) {
			availablemoves.add(new Position(getPosition().y - 1, getPosition().x - 1));
			availablemoves.add(new Position(getPosition().y - 1, getPosition().x + 1));
		}
		else if (color.equals("black") && !tookfirstmove && !capturing) {
			availablemoves.add(new Position(getPosition().y + 1, getPosition().x));
			availablemoves.add(new Position(getPosition().y + 2, getPosition().x));
		}
		else if (color.equals("black") && tookfirstmove && !capturing) {
			availablemoves.add(new Position(getPosition().y + 1, getPosition().x));
		}
		else if (color.equals("black") && capturing) {
			availablemoves.add(new Position(getPosition().y + 1, getPosition().x + 1));
			availablemoves.add(new Position(getPosition().y + 2, getPosition().x - 1));
		}
		
		capturing = false;
		
		for (Position pos: availablemoves) {
			if (b.equals(pos))
				return true;
		}
		return false;
	}
}
