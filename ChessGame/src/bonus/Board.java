package bonus;

import java.util.ArrayList;

public class Board {
	ArrayList<Piece> whitepieces;
	ArrayList<Piece> blackpieces;
	ArrayList<ArrayList<String> > representation;
	// Piece[][] p
	//p[1][2] = new Bishop();
	
	// p[1][3].isLegalMove(new Position("e4"));
	{
		clearBoard();
		
		whitepieces = new ArrayList<Piece>();
		blackpieces = new ArrayList<Piece>();
		
		King whiteking = new King("white");
		whitepieces.add(whiteking);
		King blackking = new King("black");
		blackpieces.add(blackking);
		Queen whitequeen = new Queen("white");
		whitepieces.add(whitequeen);
		Queen blackqueen = new Queen("black");
		blackpieces.add(blackqueen);
		Rook whiterook1 = new Rook("white", new Position(1, 'A'));
		whitepieces.add(whiterook1);
		Rook whiterook2 = new Rook("white", new Position(1, 'H'));
		whitepieces.add(whiterook2);
		Rook blackrook1 = new Rook("black", new Position(8, 'A'));
		blackpieces.add(blackrook1);
		Rook blackrook2 = new Rook("black", new Position(8, 'H'));
		blackpieces.add(blackrook2);
		Bishop whitebishop1 = new Bishop("white", new Position(1, 'C'));
		whitepieces.add(whitebishop1);
		Bishop whitebishop2 = new Bishop("white", new Position(1, 'F'));
		whitepieces.add(whitebishop2);
		Bishop blackbishop1 = new Bishop("black", new Position(8, 'C'));
		blackpieces.add(blackbishop1);
		Bishop blackbishop2 = new Bishop("black", new Position(8, 'F'));
		blackpieces.add(blackbishop2);
		Knight whiteknight1 = new Knight("white", new Position(1, 'B'));
		whitepieces.add(whiteknight1);
		Knight whiteknight2 = new Knight("white", new Position(1, 'G'));
		whitepieces.add(whiteknight2);
		Knight blackknight1 = new Knight("black", new Position(8, 'B'));
		blackpieces.add(blackknight1);
		Knight blackknight2 = new Knight("black", new Position(8, 'G'));
		blackpieces.add(blackknight2);
		String alphabet = "ABCDEFGH";
		for (int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn("white", new Position(2, alphabet.charAt(i)));
			whitepieces.add(pawn);
		}
		for (int i = 0; i < 8; i++) {
			Pawn pawn = new Pawn("black", new Position(7, alphabet.charAt(i)));
			blackpieces.add(pawn);
		}
	}
	
	public Board() {

	}
	
	public void clearBoard() {
		representation = new ArrayList<ArrayList<String> >();
		for (int i = 0; i < 8; i++) {
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 0; j < 8; j++) 
				row.add("[ ]");
			representation.add(row);
		}
	}
	
	public void printTheBoard() {
		clearBoard();
		for (Piece piece: whitepieces) {
			representation.get(piece.getPosition().y).set(piece.getPosition().x, "[" + piece.getUnicode() + "]");
		}
		for (Piece piece: blackpieces) {
			representation.get(piece.getPosition().y).set(piece.getPosition().x, "[" + piece.getUnicode() + "]");
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(representation.get(i).get(j));
			}
			System.out.print("\n");
		}
	}
}
