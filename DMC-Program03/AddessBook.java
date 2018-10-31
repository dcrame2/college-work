/*
 * File name: AddressBook.java
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
 * This is a Address book class that displays the customer information that is entered.
 *
 * @author Dylan Cramer
 *
 */
import java.util.Scanner;
public class AddessBook
{
	SailBoatRental boat = new SailBoatRental();
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	private String address;
	private String town;
	private String stateCode;
	private String zipCode;
	private String phoneNumber;
	
	public AddessBook(String firstName, String middleName, String lastName, String address,
			String town, String stateCode, String zipCode, String phoneNumber){
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.address = address;
			this.town = town;
			this.stateCode = stateCode;
			this.zipCode = zipCode;
			this.phoneNumber = phoneNumber;
		}
	
	public AddessBook(){
		this.firstName = null;
		this.middleName = null;
		this.lastName = null;
		this.address = null;
		this.town = null;
		this.stateCode = null;
		this.zipCode = null;
		this.phoneNumber = null;
		
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName()
	{
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	/**
	 * @return the town
	 */
	public String getTown()
	{
		return town;
	}
	/**
	 * @param town the town to set
	 */
	public void setTown(String town)
	{
		this.town = town;
	}
	/**
	 * @return the stateCode
	 */
	public String getStateCode()
	{
		return stateCode;
	}
	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode()
	{
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public void readCustomerInfo(Scanner customerInfo){
		System.out.println("Welcome to Silver Beach Rentals\n");
		System.out.println("Please enter customer information: ");
		System.out.print("Enter first name: ");
		setFirstName(customerInfo.nextLine());
		System.out.print("Enter last name: ");
		setLastName(customerInfo.nextLine());
		System.out.print("Enter street address: ");
		setAddress(customerInfo.nextLine());
		System.out.print("Enter city: ");
		setTown(customerInfo.nextLine());
		System.out.print("Enter state: ");
		setStateCode(customerInfo.nextLine());
		System.out.print("Enter zip code: ");
		setZipCode(customerInfo.nextLine());
		System.out.print("Enter phone number in form 9999999999: ");
		setPhoneNumber(customerInfo.nextLine());
	}
	public void displayContactInfo(){
		System.out.println("Customer: ");
		System.out.println(getFirstName() + " " + getLastName());
		System.out.println(getAddress());
		System.out.println(getTown() + ", " + getStateCode() + " " + getZipCode());
		System.out.println(getPhoneNumber());
	}
	public void formatPhone(){
		phoneNumber = String.format("(%s)%s-%s", phoneNumber.substring(0, 3), phoneNumber.substring(3, 6), phoneNumber.substring(6, 10));
	}
	
		public void formatMailingLabel(){
	        if (firstName == null)
	        {
	            firstName = "Silver Beach Rentals";
	            lastName = " \n";
	            address = String.format("%s\n", address);
	            town = String.format("%s ", town);
	            stateCode = String.format(" %s,", stateCode);
	            zipCode = String.format(" %s", zipCode);
	            
	        }
	        
	        else 
	        {
	            firstName = String.format("%s ", firstName);
	            
	            lastName = String.format("%s\n", lastName);
	           address = String.format("%s\n", address);
	            town = String.format("%s ", town);
	            stateCode = String.format(" %s,", stateCode);
	            zipCode = String.format(" %s", zipCode);
	        }
	       
	    }
	
}
