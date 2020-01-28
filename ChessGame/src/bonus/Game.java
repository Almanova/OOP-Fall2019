package bonus;

import java.util.Scanner;

public class Game {
	Board board;
	String current;
	int movingindex;
	int captureindex;
	
	public Game(Board board) {
		this.board = board;
		this.current = "white";
		this.movingindex = -1;
		this.captureindex = -1;
	}
	
	public void resetMovingAndCapture() {
		this.movingindex = -1;
		this.captureindex = -1;
	}
	
	public void getMovingPiece(Position a) {
		if (current.equals("white")) {
			for (int i = 0; i < board.whitepieces.size(); i++) {
				if (a.equals(board.whitepieces.get(i).getPosition())) {
					movingindex = i;
					break;
				}
			}
		}
		else {
			for (int i = 0; i < board.blackpieces.size(); i++) {
				if (a.equals(board.blackpieces.get(i).getPosition())) {
					movingindex = i;
					break;
				}
			}
		}
	}
	
	public void checkForCapture(Position a, Position b) {
		if (current.equals("white")) {
			for (int i = 0; i < board.blackpieces.size(); i++) {
				if (board.blackpieces.get(i).getPosition().equals(b))
					captureindex = i;
			}
			if (board.whitepieces.get(movingindex) instanceof Pawn &&
				captureindex != -1) {
				Pawn p = (Pawn)board.whitepieces.get(movingindex);
				p.capturing = true;
			}
		}
		else {
			for (int i = 0; i < board.whitepieces.size(); i++) {
				if (board.whitepieces.get(i).getPosition().equals(b))
					captureindex = i;
			}
			if (board.blackpieces.get(movingindex) instanceof Pawn &&
				captureindex != -1) {
				Pawn p = (Pawn)board.blackpieces.get(movingindex);
				p.capturing = true;
			}
		}
	}
	
	public boolean isLegalMove(Position a, Position b) {
		if (b.x < 0 && b.x > 7 && b.y < 0 && b.y > 7)
			return false;
		else if (current.equals("white")) {
			for (Piece piece: board.whitepieces) {
				if (b.equals(piece.getPosition()))
					return false;
			}
			return board.whitepieces.get(movingindex).checkInAvailableMoves(b, board);
		}
		else {
			for (Piece piece: board.blackpieces) {
				if (b.equals(piece.getPosition()))
					return false;
			}
			return board.blackpieces.get(movingindex).checkInAvailableMoves(b, board);
		}
	}
	
	public void makeMove(Position a, Position b) {
		if (current.equals("white")) {
			if (captureindex != -1)
				board.blackpieces.remove(captureindex);
			board.whitepieces.get(movingindex).setPosition(b);
			if (board.whitepieces.get(movingindex) instanceof Pawn) {
				Pawn p = (Pawn)board.whitepieces.get(movingindex);
				p.tookfirstmove = true;
			}
		}
		else {
			if (captureindex != -1)
				board.blackpieces.remove(captureindex);
			board.blackpieces.get(movingindex).setPosition(b);
			if (board.blackpieces.get(movingindex) instanceof Pawn) {
				Pawn p = (Pawn)board.blackpieces.get(movingindex);
				p.tookfirstmove = true;
			}
		}
	}
	
	public void startTheGame() {
		board.printTheBoard();
		Scanner input = new Scanner(System.in);
		while (true) {
			String player;
			if (current == "white")
				player = "Player 1";
			else 
				player = "Player 2";
			System.out.println(player + ", enter initial position: ");
			String x = input.nextLine();
			System.out.println(player + ", enter destination position: ");
			String y = input.nextLine();
			Position a = new Position(Character.getNumericValue(x.charAt(0)), x.charAt(1));
			Position b = new Position(Character.getNumericValue(y.charAt(0)), y.charAt(1));
			getMovingPiece(a);
			checkForCapture(a, b);
			if(isLegalMove(a, b))
				makeMove(a, b);
			else 
				System.out.println("Illegal move!");
			board.printTheBoard();
			if (current.equals("white"))
				current = "black";
			else {
				current = "white";
			}
			resetMovingAndCapture();
		}
	}
	
	public static void main(String []args) {
		Board board = new Board();
		Game game = new Game(board);
		game.startTheGame();
	}
}
