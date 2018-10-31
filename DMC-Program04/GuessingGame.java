/*
 * File name: GuessingGame.java
 *
 * Programmer: Dylan Cramer
 * ULID: 805056044
 *
 * Date: Oct 22, 2014
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Pat Matsuda
 * Lab Section:11
 * Lab Instructor: Swarup Donepudi
 */

/**
 * This is a guessing game class that pretty much does eveything to randomly generating a number and establishing the game.
 *
 * @author Dylan Cramer
 *
 */
import java.util.Random;
import java.util.Scanner;
public class GuessingGame
{
	Scanner keyboard = new Scanner(System.in);
	GameStats stat = new GameStats(0,0);
	
	private final double HOT = .10;
	private final double WARM = .25;
	
	private int range;
	private int mysteryNumber;
	int guess;
	int numOfGuess;
	

	/**
	 * @param stats
	 * @param range
	 * @param mysteryNumber
	 */
	public GuessingGame(int range, int mysteryNumber)
	{
		super();
		this.range = range;
		this.mysteryNumber = mysteryNumber;
	}


	/**
	 * This a range method that get the range and
	 * @return the rangeEnd
	 */
	public int getRange(int range)
	{
		this.range = range;
		return range;
	}
	/**
	 * This is a play game method that shows everything about the game.
	 * @return
	 */
	public int playGame(GameStats stat, Scanner keyboard){
		

		Random random = new Random();
		mysteryNumber = random.nextInt(range);
		System.out.println("Lets play. I have chosen my number.\n");
		
		while(guess != mysteryNumber)
		{
			
			this.makeGuess();
			this.evaluateGuess();
			numOfGuess++;
			while(guess == mysteryNumber){
				System.out.println("It took you " + numOfGuess + " guesses to get the mystery number.");
				break;
			}
			stat.determineBestGame(numOfGuess, range);
		}
		stat.gamesPlayed();
		
		return numOfGuess;			
	}
	/**
	 * This is a make guess method that validates the ranges used in the game and also asks for a guess to guess
	 * the mystery number.
	 */
	public void makeGuess(){
		boolean valid = true;
		System.out.print("Enter your guess: ");
		guess = keyboard.nextInt();
		if(guess > range){
			valid = false;
			System.out.println("Guess is out of range.");
		}
		else if(guess < 0){
			valid = false;
			System.out.println("Guess is out of range.");
		}
		else{
			valid = true;
		}
		 
	}
	/**
	 * This is a evaluate guess method that determines how close the your guess is to the number and will display either
	 * hot, warm or cold.
	 */
	public void evaluateGuess(){
		
		if(guess == mysteryNumber){
			System.out.println("\nYou guessed the number!!!");
		}			
		else if(( mysteryNumber + (range * HOT) + 1) > guess && guess > (mysteryNumber - (range * HOT) - 1)){
			System.out.println("Hot. Try again.\n");
			
		}
		else if((mysteryNumber + (range * WARM) + 1) > guess && guess > (mysteryNumber - (range * WARM) - 1)){
			System.out.println("Warm. Try again.\n");
		}
		else{
			System.out.println("Cold. Try again.\n");
		}
		}
	
		
	}
	
	

