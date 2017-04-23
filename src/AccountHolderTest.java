/* Purpose: To write a program that creates bank account information and executes
 * various transaction details.
 * Author: Tammy Robinson
 * Date: 01/23/2016, Due Date: 01/30/2016
 * File Name: trobinson1Lab510
 * AccountHolderTest.java
 * Lab 01
 */

// import packages
import java.util.*;

// define class
public class AccountHolderTest{

	// define main method
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		// declare local variables
		Scanner sc = new Scanner(System.in);
		double initial_balance, deposit_amt, withdrawal_amt;
		double interest_rate = 4.0;
		int i = 0;
		
		System.out.println("Welcome!\n");
		
		//prompt the user for the initial account balance
		do
		{
			
			System.out.print("Please enter your account balance: ");
			initial_balance = sc.nextDouble();
			
			if(initial_balance < 0) {
				i = 1;
				System.out.println("\nInvalid balance provided. Please try again.");
			}else
				i = 0;
		}
		while(i == 1); // end do-while
		
		// store balance by calling the account holder constructor
		AccountHolder ah = new AccountHolder(initial_balance);
		
		//prompt user for deposit amount; must be positive
		do{
			System.out.print("Please enter an amount to deposit: ");
			deposit_amt = sc.nextDouble();	
			
			if(deposit_amt < 0){
				i = 1;
				System.out.println("\nInvalid amount. Please try again.");
			}else {
				i = 0;
				ah.deposit(deposit_amt);
			}	
		}while(i == 1); // end do-while
		
		//prompt user for withdrawal amount
		do
		{
			System.out.print("\nPlease enter an amount to withdraw: ");
			withdrawal_amt = sc.nextDouble();
			double balance = ah.getBalance();
			
			if(balance >= 100 && ((balance - withdrawal_amt) < 100)){
				i = 1;
				System.out.println("\nWARNING: Your account balance will drop below $100.00"
						+ "\nif you complete this transaction. Please try a different amount.");
			}else if(withdrawal_amt < 0){
				i = 1;
				System.out.println("\nInvalid amount. Please try again.");
			}else{
				i = 0;
				ah.withdrawal(withdrawal_amt);
			}
		}while(i == 1); // end do-while
		
			
		//set initial annual interest rate to 4% and display added interest over 12 months
		ah.modifyMonthlyInterest(interest_rate); // formats rate and check that it is valid 
		ah.showData(true);
			
		//update the annual interest rate to 5% and display the final bal after 12 months
		do {
			System.out.print("Enter your updated annual interest rate as a whole number: ");
			interest_rate = sc.nextDouble();
			ah.modifyMonthlyInterest(interest_rate);
			
			double rate = ah.getRate();
			if(rate < 0 || rate > 1.0){
				i = 1;
				System.out.println("\nInvalid interest rate provided. Please try again.");
			}else {
				i = 0;
				ah.showData(false);
			}
		}while(i == 1); // end do-while
		
		// close the scanner object
		sc.close(); 
	}
}
