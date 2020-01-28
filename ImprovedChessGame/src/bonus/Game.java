package bonus;

import java.util.Scanner;

public class Game {
	private static Board board;
	private static Color current;
	
	public Game(Board board) {
		Game.board = board;
		Game.current = Color.WHITE;
	}
	
	public static Color getColor() {
		return current;
	}
	
	public static Board getBoard() {
		return board;
	}
	
	public void startTheGame(Scanner input) {
		while (true) {
			String player = "";
			if (current == Color.WHITE)
				player = "Player 1";
			else 
				player = "Player 2";
			System.out.print(player + ", enter initial position: ");
			String x = input.nextLine();
			System.out.print(player + ", enter destination postion: ");
			String y = input.nextLine();
			Position a = new Position(Character.getNumericValue(x.charAt(0)), x.charAt(1));
			Position b = new Position(Character.getNumericValue(y.charAt(0)), y.charAt(1));
			board.makeMove(a, b);
			board.printTheBoard();
			if (current == Color.WHITE)
				current = Color.BLACK;
			else
				current = Color.WHITE;
		}
	}
	
	public static void main(String []args) {
		Board board = new Board();
		Game game = new Game(board);
		Scanner input = new Scanner(System.in);
		board.printTheBoard();
		game.startTheGame(input);
		input.close();
	}
}
