/*
 * File name: GameStats.java
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
 * This is a game stats class that shows the stats from the guessing game.
 *
 * @author Dylan Cramer
 *
 */
public class GameStats
{

	private int gamesPlayed = 0;
	private int best20 = 0;
	private int best50 = 0;
	private int numGuess = 0;
	
	public GameStats(int best20, int best50){
		this.best20 = best20;
		this.best50 = best50;
		
	}
	
	/**
	 * This is a get number of guesses method that 
	 * @return the numGuess
	 */
	public int getNumGuess()
	{
		return numGuess;
	}
	
	/**
	 * This is a set number of guesses method that
	 * @param numGuess the numGuess to set
	 */
	public void setNumGuess(int numGuess)
	{
		this.numGuess = numGuess;
	}
	
	/**
	 * This is a get games played method that gets the amount of games played in the game.
	 * @return the gamesPlayed
	 */
	public int getGamesPlayed()
	{
		return gamesPlayed;
	}

	
	/**
	 * This is a method that returns your best number guessing for the range 1-20.
	 * @return the best20
	 */
	public int getBest20()
	{
		return best20;
	}
	
	/**
	 * This is a method that returns your best number guessing for the range 1-50.
	 * @return the best50
	 */
	public int getBest50()
	{
		return best50;
	}
	/**
	 * This is a games played method that increments the number of games played through out the game.
	 */
	public void gamesPlayed()
	{
		gamesPlayed++;
	}
	
	/**
	 * This is a determine best game method that determines what you got for each game.
	 * @param numOfGuess
	 * @param range
	 */
	public void determineBestGame(int numOfGuess, int range){
		if(range == 20){
			if(numOfGuess > best20){
				best20 = numOfGuess;
			}
		else if( range == 50){
				if(numOfGuess > best50){
					best50 = numOfGuess;
			}
		}
			
		}
	}
	
	/**
	 * This is a display game stats method that will show you how many games you played, your best game for 1-20, and your
	 * best game for 1-50.
	 */
	public void displayGameStats(){
		System.out.println("You have played " + gamesPlayed + " games.");
		
		if(best20 == 100)
		{
			System.out.println("You have not played a game using the 1-20 range.");
		}
		else
		{
			System.out.println("Your best game using the 1-20 range is: " + best20);
		}
		if(best50 == 100)
		{
			System.out.println("You have not played a game using the 1-50 range.");
		}
		else
		{
			System.out.println("Your best game using the 1-50 range is: " + best50);
		}
		
	}
	
}
