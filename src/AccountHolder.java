/* Purpose: To write a program that creates bank account information and executes
 * various transaction details.
 * Author: Tammy Robinson
 * Date: 01/23/2016, Due Date: 01/30/2016
 * File Name: trobinson1Lab510
 * AccountHolder.java
 * Lab 01
 */

// import packages
import java.text.SimpleDateFormat;
import java.util.Calendar;

// define class
public class AccountHolder {

	// define class fields
	private static double annualInterestRate;
	private double balance;
	private double [] balances = new double[20];
	
	private final int NUM_OF_MONTHS = 12;
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	/**
	 * This constructor accepts arguments that represent the initial account balance.
	 * The initial balance must be positive.
	 * @param	initBal		double - the initial balance given by the user
	 * @return	none
	 */
	public AccountHolder(double initBal) {
		// set initial balance to balance member
		balance = initBal; 
		System.out.println("\nThank you,");
	}
	
	/**
	 * Updates the account holder's balance to reflect the earned interest
	 * each month. The earned interest is added to the account holder's 
	 * current balance.
	 * @param	void
	 * @return	void
	 */
	public void monthlyInterest(){
		balance += balance * (annualInterestRate / 12.0);
	}
	
	/**
	 * Allows the annualInterestRate to be updated and sets the annualInterestRate
	 * to the new specified rate.
	 * @param	rate	double - the new interest rate that should be set to the annualInterestRate class member
	 * @return	void
	 */
	public static void modifyMonthlyInterest(double rate){
		double updatedRate = rate / 100;
		annualInterestRate = updatedRate;
	}

	/**
	 * Increases the current account balance by the given amount.
	 * @param	dep		double - the amount to add to the current balance
	 * @return	void
	 */
	public void deposit(double dep){
		// increase current account balance
		System.out.println("\nCurrent Balance: \t" + this.toString(balance));
		
		double newBal = balance + dep;
		System.out.println("New Balance: \t\t" + this.toString(newBal));
		System.out.println("\nCurrent date = " + timeStamp + "\nProgrammed by Tammy Robinson\n");
		
		balance += dep;
	}
	
	/**
	 * Decreases the current account balance by the given amount. An alert should
	 * be presented to the user if the account balance drops below $100.00. A $50.00
	 * fee will be incurred if the account balance drops below $500.00.
	 * @param	wd		double - the amount to take away from the current balance
	 * @return	void
	 */
	public void withdrawal(double wd){
		// show current balance
		System.out.println("\nCurrent Balance: \t" + String.format("$%.2f", balance));
		
		// determine balance after withdrawal and check for rules
		double newBal = balance - wd;
		if(balance >= 500.0 && newBal < 500.0 ) {
			// charge $50 when balance drops below $500.00 at time of withdrawal
			System.out.println("\nYou were charged a $50.00 fee for this transaction");
			balance = (balance - 50.0) - wd;
			
			System.out.println("New Balance: \t\t" + this.toString(balance));
		} else {
			System.out.println("New Balance: \t\t" + this.toString(newBal));
			balance -= wd;
		}
		System.out.println("\nCurrent date = " + timeStamp + "\nProgrammed by Tammy Robinson\n");
	}
	
	/** 
	 * Formats a double value and converts it to a string to be passed through an 
	 * output statement.
	 * @return		the account balance in a formatted string
	 * @see 		java.lang.Object#toString()
	 */
	public String toString(double bal){
		return String.format("$%.2f", bal);
	}
	
	/**
	 * Returns the current account balance
	 * @return	double 
	 */
	public double getBalance(){
		return balance;
	}
	
	/**
	 * Returns the current interest rate
	 * @return	double 
	 */
	public double getRate(){
		return annualInterestRate;
	}
	
	/**
	 * Displays a report showing interest being added to the users account over a period of 
	 * 12 months in a table format. 
	 * Also displays the updated account balance to show earned interest after updating 
	 * the annual interest rate.
	 * @param 		bool	helps determine which output should be shown; shows table if true
	 * @return		void 
	 */
	public void showData(boolean bool){
		// define local variables 
		int y = NUM_OF_MONTHS;
		balances[0] = balance;
		
		if(bool) {
			// display output 
			System.out.println("\n12-Month Balance Outlook at " + annualInterestRate * 100 + "% interest");
			System.out.println("\nMonth\t\t" + "Balance (with Interest)\t"); 
			System.out.println("______\t\t" + "_______________________\t" + "\n"); 
			System.out.println("\t\t" + this.toString(balances[0]) + " (Base)\n"); 
			
			// calculate the new balance for each month w. interest included
			for(int i = 1; i <= y; i++) {
				monthlyInterest(); // perform adding interest to the balance
				balances[i] = balance; // set the balance to a field in the array
				System.out.print(i + "\t\t" + this.toString(balances[i]) + "\n"); 
			}		
		} else {
			monthlyInterest(); // update balance to show earned interest
			
			// display output
			System.out.println("\nAfter setting the interest rate to " + annualInterestRate * 100 + "%\n"
					+ "the following month's balance will be:\n");
			System.out.print(this.toString(balance) + "\n"); 
		}
		System.out.println("\nCurrent date = " + timeStamp + "\nProgrammed by Tammy Robinson\n");
	}
}
