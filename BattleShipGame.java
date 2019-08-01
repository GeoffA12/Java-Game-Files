import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class BattleShipGame {
	
	public static char[][] masterArray = new char[10][10];
	public static void main(String[] args) {
		System.out.println("****Welcome to the Battleships game****");
		System.out.println();
		System.out.println("Right now, the sea is empty:");
		System.out.println();
		// char[][] masterArray = new char[10][10];
		printMap(masterArray);
		System.out.println();
		System.out.println("It's your turn to place your ships on the board!");
		userMap();
		System.out.println();
		System.out.println("Now it's the computer's turn to place their ships.");
		computerMap();
		System.out.println();
		System.out.println("Now that the computer is finished, it's time to play!");
		System.out.println();
		gameOn();
		

	}
	
	
	public static void printMap (char[][] battleMap1) {
		System.out.println("   0123456789    ");
		for (int i = 0; i < battleMap1.length; i++) {
			System.out.print(i + " |");
			for (int j = 0; j < battleMap1[0].length; j++) {
				Character findIndex = battleMap1[i][j];
				if (findIndex == '#') {
					findIndex = ' ';
				}
				System.out.print(findIndex);
			}
			System.out.print("| " + i);
			System.out.println();
		}
		System.out.println("   0123456789    ");
		// System.out.println(Arrays.deepToString(battleMap1));
	}
	
	public static void userMap () {
		Scanner userInput = new Scanner(System.in);
		int x1;
		int y1;
		for (int i = 1; i < 6; i++) {
			do {
				try {
					System.out.println("Enter an x coordinate for ship " + i + ": ");
					String s1 = userInput.nextLine();
					x1 = Integer.parseInt(s1);
					System.out.println("Enter a y coordinate for ship " + i + ": ");
					String s2 = userInput.nextLine();
					y1 = Integer.parseInt(s2);
					break;
				}
				catch (Exception e) {
					System.out.println("I couldn't parse your input. Try again!");
				}
			} while (true);
			// System.out.println("Enter an x coordinate for ship " + i + ": ");
			// int x1 = userInput.nextInt();
			// System.out.println("Enter a y coordinate for ship " + i + ": ");
			// int y1 = userInput.nextInt();
			if (x1 > 9 || x1 < 0 || y1 > 9 || y1 < 0) {
				System.out.println("Please enter valid coordinates! Must be between 0-9");
				i--;
				continue;
			}
			if (masterArray[x1][y1] == '@') {
				System.out.println("You can't place two ships in the same place!");
				i--;
				continue;
			}
			masterArray[x1][y1] = '@';
		}
		System.out.println("Here's where you placed your ships...");
		System.out.println();
		printMap(masterArray);
		// return oceanMap1;
		
	}
	
	public static void computerMap() {
		Random rand = new Random();
		for (int i = 1; i < 6; i++) {
			int x1 = rand.nextInt(9) + 0;
			int y2 = rand.nextInt(9) + 0;
			if (masterArray[x1][y2] == '@' || masterArray[x1][y2] == '#') {
				i--;
				continue;
			}
			masterArray[x1][y2] = '#';
		}
		System.out.println();
		printMap(masterArray);
		// return oceanMap2;
	}
	
	public static void gameOn () {
		int userScore = 5;
		int compScore = 5;
		Scanner userInput = new Scanner(System.in);
		int u1;
		int u2;
		Random comp = new Random();
		while (userScore > 0 && compScore > 0) {
			do {
				try {
					System.out.println("YOUR TURN");
					System.out.println("Enter an X coordinate: ");
					String s1 = userInput.nextLine();
					u1 = Integer.parseInt(s1);
					System.out.println("Enter a Y coordinate: ");
					String s2 = userInput.nextLine();
					u2 = Integer.parseInt(s2);
					break;
					
				}
				catch (Exception e) {
					System.out.println("I couldn't parse your integer. Make sure it's an actual integer!");
				}
			} while (true);
			
			if (u1 > 9 || u1 < 0 || u2 > 9 || u2 < 0) {
				System.out.println("Enter a guess between 0-9!");
				continue;
			}
			
			if (masterArray[u1][u2] == '-' || masterArray[u1][u2] == '!' || masterArray[u1][u2] == 'x') {
				System.out.println("The space has already been guessed.");
				continue;
			}
			if (masterArray[u1][u2] == 0) {
				System.out.println("You missed.");
				masterArray[u1][u2] = '-';
			}
			
			if (masterArray[u1][u2] == '@') {
				System.out.println("Oh no! You sunk one of your own ships.");
				masterArray[u1][u2] = 'x';
				userScore--;
			}
			if (masterArray[u1][u2] == '#') {
				System.out.println("BOOM! You hit one of the computer's ships!");
				masterArray[u1][u2] = '!';
				compScore--;
			}
			
			System.out.println("COMPUTER'S TURN");
			int c1;
			int c2;
			do {
				c1 = comp.nextInt(9) + 0;
				c2 = comp.nextInt(9) + 0;
			} while (masterArray[c1][c2] == '-' || masterArray[c1][c2] == '!' || masterArray[c1][c2] == 'x');
			
			if (masterArray[c1][c2] == 0) {
				System.out.println("Computer missed.");
				masterArray[c1][c2] = '-';
			}
			if (masterArray[c1][c2] == '@') {
				System.out.println("The computer hit one of your ships!");
				masterArray[c1][c2] = 'x';
				userScore--;
			}
			if (masterArray[c1][c2] == '#') {
				System.out.println("The computer hit one of their own ships!");
				masterArray[c1][c2] = '!';
				compScore--;
			}
			
			System.out.println("Here is the current state of the game board");
			printMap(masterArray);
			System.out.println();
			System.out.println("Your ships: " + userScore + " | Computer ships: " + compScore);
			System.out.println(userScore);
			System.out.println(compScore);
		}
		if (compScore == 0) {
			System.out.println("Hooray! you won!");
		}
		else if (userScore == 0) {
			System.out.println("The computer won.");
		}
			
		
		
	}
}
