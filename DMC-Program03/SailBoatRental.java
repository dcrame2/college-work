/*
 * File name: SailBoatRental.java
 *
 * Programmer: Dylan Cramer
 * ULID: 805056044
 *
 * Date: Oct 7, 2014
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Pat Matsuda
 * Lab Section:11
 * Lab Instructor: Swarup Donepudi
 */

/**
 * This is a Sailboat Rental class that calculates the rental for sailboats price.
 *
 * @author Dylan Cramer
 *
 */
public class SailBoatRental
{
	
	private final double DISCOUNT = 0.15;
	private final double RETURNABLE_DEPOSITS = 75;
	private final double SPRING = 150.00; //includes months March, April, and May.
	private final double SUMMER = 250.00; //includes months June, July, and August.
	private final double FALL = 170.00; //includes months September, October, and November.
	private final double WINTER = 125.00; //includes months December, January, and February.
	
	private int numOfDaysRented;
	private int numOfBoatsRented;
	private String rentalDate = "mm/dd/yyyy";
	
	public SailBoatRental(){
		numOfDaysRented = 0;
		numOfBoatsRented = 0;
		rentalDate = null;
	}
	
	/**
	 * @return the numOfDaysRented
	 */
	public double getNumOfDaysRented()
	{
		return numOfDaysRented;
	}

	/**
	 * @param numOfDaysRented the numOfDaysRented to set
	 */
	public void setNumOfDaysRented(int numOfDaysRented)
	{
		this.numOfDaysRented = numOfDaysRented;
	}

	/**
	 * @return the numOfBoatsRented
	 */
	public double getNumOfBoatsRented()
	{
		return numOfBoatsRented;
	}

	/**
	 * @param numOfBoatsRented the numOfBoatsRented to set
	 */
	public void setNumOfBoatsRented(int numOfBoatsRented)
	{
		this.numOfBoatsRented = numOfBoatsRented;
	}

	/**
	 * @return the rentalDate
	 */
	public String getRentalDate()
	{
		return rentalDate;
	}

	/**
	 * @param rentalDate the rentalDate to set
	 */
	public void setRentalDate(String rentalDate)
	{
		this.rentalDate = rentalDate;
	}

	/**
	 * @return the dISCOUNT
	 */
	public double getDISCOUNT()
	{
		return DISCOUNT;
	}

	/**
	 * @return the sPRING
	 */
	public double getSPRING()
	{
		return SPRING;
	}

	/**
	 * @return the sUMMER
	 */
	public double getSUMMER()
	{
		return SUMMER;
	}

	/**
	 * @return the fALL
	 */
	public double getFALL()
	{
		return FALL;
	}

	/**
	 * @return the wINTER
	 */
	public double getWINTER()
	{
		return WINTER;
	}

	public double calculateTotal(){
		double total = 0;
		if(determineDiscount() == true){
			total = (calculateSailboatCost() - calculateDiscount() + calculateDeposit());
		}
		else{
			total = (determinePrice() + calculateSailboatCost());
		}
		return total;
			
	}
	public double calculateSailboatCost(){
		return (numOfDaysRented * numOfBoatsRented * determinePrice());
		
	}

	public double calculateDiscount(){
		double discountAmount = 0;
		if(numOfDaysRented > 7){
			discountAmount = (DISCOUNT * calculateSailboatCost());
		}
		return discountAmount;	
	}
	public double calculateDeposit(){
		return (RETURNABLE_DEPOSITS * numOfBoatsRented);
	}
	public double determinePrice(){
		double thePrice = 0;
		int month = Integer.parseInt(rentalDate.substring(0,2));
		if(month == 8 || month == 7 || month == 06){
			thePrice = SUMMER;
		}
		else if(month == 5 || month == 4 || month == 3){
			thePrice = SPRING;
		}
		else if(month == 2 || month == 1 || month == 12){
			thePrice = WINTER;
		}
		else if(month == 11 || month == 10 || month == 9){
			thePrice = FALL;
		}
		return thePrice;
	}
	public boolean determineDiscount(){
		if(numOfDaysRented > 7){
			return true;
		}
		else{
			return false;
		}
	}
	public void displayReceipt(){
		System.out.printf("Rental cost: $%.2f", calculateSailboatCost());
		if(determineDiscount() == true){
		System.out.printf("\nDiscount: $%.2f" , calculateDiscount() );
		}
		System.out.printf("\nDeposit: $%.2f", calculateDeposit() , "\n");
		System.out.printf("\n\nTotal: $%.2f" , calculateTotal());
	}
	public void displayGoodbye(){
		System.out.println("\nThank you for renting for us.\n");
		
		}
	}
	

