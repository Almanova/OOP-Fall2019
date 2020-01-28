package bonus;

import java.util.ArrayList;

public class Bishop extends Piece{
	public Bishop(String color, Position position) {
		super(color);
		createUnicode(position);
	}
	
	public void createUnicode(Position position) {
		String unicode = "";
		if (this.color.equals("white")) {
			unicode = "\u2657";
		}
		else {
			unicode = "\u265D";
		}
		setUnicodeAndPosition(unicode, position);
	}
	public static boolean checkInAvailableMoves(Position a, Position b, Board board) {}
	
	{
		
		
	}
	//  checkInAvailableMoves(this.position, b, board);
	public boolean checkInAvailableMoves(Position b, Board board) {
		availablemoves = new ArrayList<Position>();
		Position p;
		int xx, yy;
		xx = getPosition().x;
		yy = getPosition().y;
		while (xx <= 7 && xx >= 0 && yy >= 0 && yy <= 7) {
			xx--;
			yy--;
			if (yy < 0 || yy > 7 || xx < 0 || xx > 7)
				break;
			else if (board.representation.get(yy).get(xx).equals("[ ]")) {
				p = new Position(yy, xx);
				availablemoves.add(p);
			}
			else
				break;
		}
		xx = getPosition().x;
		yy = getPosition().y;
		while (xx <= 7 && xx >= 0 && yy >= 0 && yy <= 7) {
			yy--;
			xx++;
			if (yy < 0 || yy > 7 || xx < 0 || xx > 7)
				break;
			else if (board.representation.get(yy).get(xx).equals("[ ]")) {
				p = new Position(yy, xx);
				availablemoves.add(p);
			}
			else
				break;
		}

		xx = getPosition().x;
		yy = getPosition().y;
		while (xx <= 7 && xx >= 0 && yy >= 0 && yy <= 7) {
			yy++;
			xx++;
			if (yy < 0 || yy > 7 || xx < 0 || xx > 7)
				break;
			else if (board.representation.get(yy).get(xx).equals("[ ]")) {
				p = new Position(yy, xx);
				availablemoves.add(p);
			}
			else
				break;
		}
		xx = getPosition().x;
		yy = getPosition().y;
		while (xx <= 7 && xx >= 0 && yy >= 0 && yy <= 7) {
			xx--;
			yy++;
			if (yy < 0 || yy > 7 || xx < 0 || xx > 7)
				break;
			else if (board.representation.get(yy).get(xx).equals("[ ]")) {
				p = new Position(yy, xx);
				availablemoves.add(p);
			}
			else
				break;
		}
		
		for (Position pos: availablemoves) {
			if (b.equals(pos))
				return true;
		}
		return false;
	}
}
