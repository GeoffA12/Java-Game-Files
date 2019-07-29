import java.util.Scanner;
public class MazeRunner {
	static Maze myMap = new Maze();
	public static void main(String[] args) {
		System.out.println("Hi! Welcome to the Maze game. First, we will show you the map and explain the rules.");
		System.out.println("Your map will look like all \".\" Characters and one \"x\" character. The x represents your current position and the . Represents an unknown space.");
		System.out.println("As you move through the map the “.” Will turn into either walls (“-“) or free spaces (“*”). There might even be more surprises in store for you as well.");
		myMap.printMap();
		// Test the while loop for whether or not the game was won. Continue if it wasn't won. 
		boolean win = myMap.didIWin();
		int counter = 0;
		while (win == false) {
			String userChoice = userMove();
			canIMoveCheck(userChoice);
			navigatePit(userChoice);
			win = myMap.didIWin();
			counter++;
			System.out.println("Number of moves: " + counter);
			if (counter == 50) {
				System.out.println("Warning. You have made 50 moves, and you only have 50 left before game closes.");
			}
			else if (counter == 75) {
				System.out.println("Alert! You have made 75 moves, and you only have 25 remaining.");
			}
			else if (counter == 90) {
				System.out.println("Warning! You only have 10 moves left!");
			}
			else if (counter == 100) {
				System.out.println("Game over!");
				System.exit(0);
			}
		}
		System.out.println("Congratulations! You made it out alive in " + counter + " moves!");
	}	
	// Get the user's choice here. Make sure it is a valid option and return it to main
	public static String userMove() {
		Scanner userInput = new Scanner(System.in);
		String userChoice = "";
		String again = "y";
		while (again.equals("y")) {
			System.out.println("Where would you like to move? ");
			userChoice = userInput.next();
			if (!userChoice.equalsIgnoreCase("L") && !userChoice.equalsIgnoreCase("R") && !userChoice.equalsIgnoreCase("D") && !userChoice.equalsIgnoreCase("U")) {
				System.out.println("Please enter a valid choice of L, D, R or U");
				again = "y";
			}
			else {
				again = "n";
			}
		}
		userChoice = userChoice.toUpperCase();
		return userChoice;
	}
	
	public static void canIMoveCheck(String choice) {
		if (choice.equals("U")) {
			boolean answer = myMap.canIMoveUp();
			if (answer == false) {
				System.out.println("Sorry, you hit a wall.");
			}
			else {
				myMap.moveUp();
			}
		}
		else if (choice.equals("L")) {
			boolean answer = myMap.canIMoveLeft();
			if (answer == false) {
				System.out.println("Sorry, you hit a wall.");
			}
			else {
				myMap.moveLeft();
			}
		}
		else if (choice.equals("R")) {
			boolean answer = myMap.canIMoveRight();
			if (answer == false) {
				System.out.println("Sorry, you hit a wall.");
			}
			else {
				myMap.moveRight();
			}
		}
		else if (choice.equals("D")) {
			boolean answer = myMap.canIMoveDown();
			if (answer == false) {
				System.out.println("Sorry, you hit a wall.");
			}
			else {
				myMap.moveDown();
			}
		}
		myMap.printMap();
	}
	
	// Navigate the map for pits. If there is a pit, then ask the user if they want to jump over it.
	public static void navigatePit(String direction) {
		// System.out.println(direction);
		Scanner userInput = new Scanner(System.in);
		boolean awol = myMap.isThereAPit(direction);
		if (awol == true) {
			System.out.println("Watch out! There is a pit ahead. Press y to jump. Press any other key to not jump: ");
			String userAnswer = userInput.next();
			userAnswer = userAnswer.toLowerCase();
			if (userAnswer.startsWith("y")) {
				myMap.jumpOverPit(direction);
				myMap.printMap();
			}
			else {
				System.out.println("You didn't jump. You will stay in the same spot.");
			}
		}
	}
}
