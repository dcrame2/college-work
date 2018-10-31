import java.util.Scanner;

/*
 * File name: GameStats.java
 *
 * Programmer: Pat Matsuda
 * ULID: mpmatsu
 *
 * Date: Sep 10, 2014
 *
 * Class: IT 168
 * Lecture Section: 1, 10, 13
 * Lecture Instructor: Patricia Matsuda
 * Lab Section: 2,3,11,12,14,15
 * LabInstructor: Nasiba Al-Rawi, Aayush Agrawal, Karl Bissereth, 
 * 					Swarup Deonepudi
 */

/**
 * This is a guessing game driver class that will produce the whole game and show the whole outcome.
 *
 * @author Dylan Cramer
 *
 */
public class GuessingGameApp
{
	private GuessingGame game;
	private GameStats stats;
	private Scanner keyboard;
	
	/**
	 * This is a run program that will run your whole program.
	 */
	public void run()
	{
		game = new GuessingGame(20, 0);
		stats = new GameStats(100, 100);
		keyboard = new Scanner(System.in);
		
		int choice = 0;		
		int range = 20;
		int numberGuess = 0;
		
		displayInstructions();
		getChoice(choice, range, numberGuess);
		displayGoodbye();
	
	}
	/**
	 * This is method that displays the instructions of the game.
	 */
	private void displayInstructions()
	{
		System.out.println("\t\t\t\t\t\tIT 168 Guessing Game\n");
		System.out.println("On the following sceen you will find a menu with three choices.");
		System.out.println("\tThefirst choice will be to play the game.");
		System.out.println("\tThe second choice you will be to change the game range.");
		System.out.println("\t\tIt can either be 1-20(the defualt) or 1-50");
		System.out.println("\tThe third choice will be to display your statistics for the session.");
		System.out.println("\tThe fourth choice will be to quit the game.");
		
		System.out.println("\nPlaying the game: ");
		System.out.println("\tYou will try to guess the number the computer has chosen.");
		System.out.println("\tafter each guess, if you haven't guessed the number,");
		System.out.println("you will be given a hint of, cold, warm, or hot.");
			
	}
	/**
	 * This is a get choice method that will let you choose what choice you want out of the 4 choices provided.
	 * @param choice
	 * @param range
	 * @param numberGuess
	 */
	private void getChoice(int choice, int range, int numberGuess)
	{
		System.out.println("\nGuessing Game Menu");
		System.out.println("\n1. Play a Game \n2. Change Number Range\n3. Statistics for Session\n4. Quit\n");
		System.out.print("Please enter your choice: ");
		choice = keyboard.nextInt();
		
		while(choice != 4){
		
			switch(choice){
				case 1: 
					numberGuess = game.playGame(stats, keyboard);
					break;
				case 2:
					range = chooseRange(range);
					break;
				case 3:
					stats.displayGameStats();
					break;
				case 4:
					choice = 4;
					break;
			}
			System.out.println("\nGuessing Game Menu");
			System.out.println("\n1. Play a Game \n2. Change Number Range\n3. Statistics for Session\n4. Quit\n");
			System.out.print("Please enter your choice: ");
			choice = keyboard.nextInt();
		
		}
		
	}
	/**
	 * This is an update game stats method that will show you the stats of the game, if you choose choice 3 for the game.
	 * @param numGuess
	 * @param range
	 */
	
	private void updateGameStats(int numberGuess, int range)
	{
		 if(range == 20)
         {
                 stats.setNumGuess(numberGuess);
         }
		 if(range == 50)
         {
                 stats.setNumGuess(numberGuess);
         }
         stats.determineBestGame(range, numberGuess);
		
	}
	/**
	 * This is a choose range class that will let you change the range for the game, if you choose choice 3.
	 * @param range
	 * @return range
	 */
	
	private int chooseRange(int range)
	{
		System.out.print("Please enter 20 or 50 for the range: ");
		range = keyboard.nextInt();
		if(range != 50 && range != 20){
			System.out.println("You entered an invalid range.");
		}
		else{
			
		}
		range = game.getRange(range);
		return range;
		
	}
	/**
	 * This is a display goodbye method that will say goodbye to you, if you choose number 4.
	 */
	
	private void displayGoodbye()
	{
		System.out.println("Thanks for playing the IT 168 Guessing game. Game over.");
	}
	/**
	 * This is a method that will apply the running of the method.
	 * @param args
	 */
	public static void main(String[] args)
	{
		GuessingGameApp application = new GuessingGameApp();
		
		
		application.run();
		
	}
}

