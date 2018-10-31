/*
 * File name: SailBoatDriver.java
 *
 * Programmer: Dylan Cramer
 * ULID: 805056044
 *
 * Date: Oct 8, 2014
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Pat Matsuda
 * Lab Section:11
 * Lab Instructor: Swarup Donepudi
 */

/**
 * <insert class description here>
 *
 * @author Dylan Cramer
 *
 */
import java.util.Scanner;
public class SailBoatDriver
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		AddessBook book = new AddessBook();
		AddessBook book1 = new AddessBook(null, null, null, "239 E. Hwy 98" , "Destin" , "FL" , "32540", "8507291000");
		SailBoatRental rental = new SailBoatRental();
		
		book.readCustomerInfo(keyboard);
		System.out.print("Enter start date in form mm/dd/yyyy: ");
		rental.setRentalDate(keyboard.nextLine());
		System.out.print("Enter number of sail boats: ");
		rental.setNumOfBoatsRented(keyboard.nextInt());
		System.out.print("Enter number of days: ");
		rental.setNumOfDaysRented(keyboard.nextInt());
		
		System.out.println();
		book.formatPhone();
		book.displayContactInfo();
		System.out.println();
		rental.displayReceipt();
		System.out.println();
		rental.displayGoodbye();
		
		book1.formatMailingLabel();
		
		
		 
	}

}
