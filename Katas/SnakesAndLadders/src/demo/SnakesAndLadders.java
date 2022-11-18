package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakesAndLadders {
	final static int TARGET = 100;
	static Map<Integer, Integer> snakePositions = new HashMap<>();
	static Map<Integer, Integer> ladderPositions = new HashMap<>();

	public static int rollDice() {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(7);
		return (n == 0 ? 1 : n);
	}

	public static int calculatePlayerValue(int playerPosition, int diceValue) {
		int playerNewPosition = playerPosition + diceValue;

		if (playerNewPosition > TARGET)
			return playerPosition;

		if (null != snakePositions.get(playerNewPosition)) {
			System.out.println("Oops! Caught by the snake.");
			playerNewPosition = snakePositions.get(playerNewPosition);
		}

		if (null != ladderPositions.get(playerNewPosition)) {
			System.out.println("YAY! Climbing the ladder.");
			playerNewPosition = ladderPositions.get(playerNewPosition);
		}

		return playerNewPosition;
	}

	public static boolean isWin(int playerPosition) {
		return TARGET == playerPosition;
	}

	public static void startGame() {
		int player1Position = 0;
		int player2Position = 0;
		int currentPlayer = -1;
		Scanner scan = new Scanner(System.in);
		String keyPressed;
		int diceValue = 0;
		do {
			System.out.println(currentPlayer == -1 ? "\nPlayer 1's turn" : "\nPlayer 2's turn");
			System.out.println("Press 'r' to roll Dice");
			keyPressed = scan.next();
			diceValue = rollDice();

			if (currentPlayer == -1) {
				player1Position = calculatePlayerValue(player1Position, diceValue);
				System.out.println("Player 1 Position: " + player1Position);
				System.out.println("Player 2 Position: " + player2Position);
				System.out.println("-------------------------");
				if (isWin(player1Position)) {
					System.out.println("Player 1 is the winner!");
					return;
				}
			} else {
				player2Position = calculatePlayerValue(player2Position, diceValue);
				System.out.println("Player 1 Position: " + player1Position);
				System.out.println("Player 2 Position: " + player2Position);
				System.out.println("-------------------------");
				if (isWin(player2Position)) {
					System.out.println("Player 2 is the winner!");
					return;
				}
			}
			currentPlayer = -currentPlayer;
		} while ("r".equals(keyPressed));
	}

	public static void main(String[] args) {
		snakePositions.put(99, 54);
		snakePositions.put(70, 55);
		snakePositions.put(52, 42);
		snakePositions.put(25, 2);
		snakePositions.put(95, 72);

		ladderPositions.put(6, 25);
		ladderPositions.put(11, 40);
		ladderPositions.put(60, 85);
		ladderPositions.put(46, 90);
		ladderPositions.put(17, 69);
		startGame();
	}

}