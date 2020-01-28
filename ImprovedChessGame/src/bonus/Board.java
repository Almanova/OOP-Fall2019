package bonus;

public class Board {
	Piece[][] representation;
	
	public Board() {
		
	}
	
	{
		representation = new Piece[8][8];
		representation[7][4] = new King("\u2654", Color.WHITE, 1, 'E');
		representation[0][4] = new King("\u265A", Color.BLACK, 8, 'E');
		representation[7][3] = new Queen("\u2655", Color.WHITE, 1, 'D');
		representation[0][3] = new Queen("\u265B", Color.BLACK, 8, 'D');
		representation[7][0] = new Rook("\u2656", Color.WHITE, 1, 'A');
		representation[0][0] = new Rook("\u265C", Color.BLACK, 8, 'A');
		representation[7][7] = new Rook("\u2656", Color.WHITE, 1, 'H');
		representation[0][7] = new Rook("\u265C", Color.BLACK, 8, 'H');
		representation[7][2] = new Bishop("\u2657", Color.WHITE, 1, 'C');
		representation[0][2] = new Bishop("\u265D", Color.BLACK, 8, 'C');
		representation[7][5] = new Bishop("\u2657", Color.WHITE, 1, 'F');
		representation[0][5] = new Bishop("\u265D", Color.BLACK, 8, 'F');
		representation[7][1] = new Knight("\u2658", Color.WHITE, 1, 'B');
		representation[0][1] = new Knight("\u265E", Color.BLACK, 8, 'B');
		representation[7][6] = new Knight("\u2658", Color.WHITE, 1, 'G');
		representation[0][6] = new Knight("\u265E", Color.BLACK, 8, 'G');
		String alphabet = "ABCDEFGH";
		for (int i = 0; i < 8; i++) {
			representation[6][i] = new Pawn("\u2659", Color.WHITE, new Position(2, alphabet.charAt(i)));
		}
		for (int i = 0; i < 8; i++) {
			representation[1][i] = new Pawn("\u265F", Color.BLACK, new Position(7, alphabet.charAt(i)));
		}
	}
	
	public void printTheBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (representation[i][j] != null) {
					System.out.print("[" + representation[i][j].getUnicode() + "]");
				}
				else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}
	
	public void makeMove(Position a, Position b) {
		Piece p = representation[a.getY()][a.getX()];
		if (p instanceof Pawn && representation[b.getY()][b.getX()] != null)
				((Pawn) p).setCapturing(true);
		if (p.isLegalMove(a, b) && p.isCurrentPlayer()) {
			if (p instanceof Pawn)
				((Pawn) p).setTookFirstMove();
			representation[b.getY()][b.getX()] = p;
			representation[a.getY()][a.getX()] = null;
			p.setPosition(b);
		}
		else
			System.out.println("Illegal move!");
	}
}
