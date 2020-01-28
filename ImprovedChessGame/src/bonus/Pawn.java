package bonus;

public class Pawn extends Piece {
	private boolean tookfirstmove;
	private boolean capturing;
	
	public Pawn (String unicode, Color color, int y, char x) {
		super(unicode, color, y, x);
	}
	
	public Pawn (String unicode, Color color, Position position) {
		super(unicode, color, position);
	}
	
	public void setTookFirstMove() {
		tookfirstmove = true;
	}
	
	public void setCapturing(boolean capturing) {
		this.capturing = capturing;
	}
	
	public boolean isLegalMove(Position a, Position b) {
		if (this.getColor() == Color.WHITE && !tookfirstmove && !capturing) {
			if ((a.getY() - 1 == b.getY() && a.getX() == b.getX()) ||
				(a.getY() - 2 == b.getY() && a.getX() == b.getX()))
			return true;
		}
		else if (this.getColor() == Color.WHITE && tookfirstmove && !capturing) {
			if (a.getY() - 1 == b.getY() && a.getX() == b.getX())
				return true;
		}
		else if (this.getColor() == Color.BLACK && !tookfirstmove && !capturing) {
			if ((a.getY() + 1 == b.getY() && a.getX() == b.getX()) ||
				(a.getY() + 2 == b.getY() && a.getX() == b.getX()))
				return true;
		}
		else if (this.getColor() == Color.BLACK && tookfirstmove && !capturing) {
			if (a.getY() + 1 == b.getY() && a.getX() == b.getX())
				return true;
		}
		else if (this.getColor() == Color.WHITE && capturing) {
			if ((a.getY() - 1 == b.getY() && a.getX() + 1 == b.getX()) ||
				(a.getY() - 1 == b.getY() && a.getX() - 1 == b.getX())) {
				setCapturing(false);
				return true;
			}
		}
		else if (this.getColor() == Color.BLACK && capturing) {
			if ((a.getY() + 1 == b.getY() && a.getX() + 1 == b.getX()) ||
				(a.getY() + 1 == b.getY() && a.getX() - 1 == b.getX())) {
				setCapturing(false);
				return true;
			}
		}
		return false;
	}
}
