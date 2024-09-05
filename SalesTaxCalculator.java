/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-13
Task challenge: "Write a program that will ask the user to enter the amount of a purchase. The program should then compute the state and county 
  sales tax. Assume the state sales tax is 4 percent and the county sales tax is 2 percent. The program should display the amount of the purchase, 
  the state sales tax, the county sales tax, the total sales tax, and the total of the sale (which is the sum of the amount of purchase plus the 
  total sales tax). Hint: Use the value 0.02 to represent 2 percent, and 0.04 to represent 4 percent."
Description: The program ask the user to enter the amount of a sale, computes the sales tax, finds the total amount of the sale, and then displays
  the results back to the user. A while loop is used to continuously ask the user for input until a valid amount is entered, which can either be 
  a whole number or a decimal amount no greater than 2 decimal places, AND must be greater than zero.
*/


// Import necessary classes.
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

// Declare class SalesTaxCalculator.
class SalesTaxCalculator {

  // The main method.
  public static void main(String[] args) {

    // Instantiate and initialize the Scanner class to read from standard input.
    Scanner scanner = new Scanner(System.in);

    // Create local variables.
    final BigDecimal STATE_TAX = new BigDecimal("0.04");
    final BigDecimal COUNTY_TAX = new BigDecimal("0.02");
    final BigDecimal MIN_VALUE = new BigDecimal(0);
    BigDecimal saleAmount = new BigDecimal(0);

    // Greet user and explain inputs.
    System.out.println("\nGreetings User!\n\nEnter a sales price and I will show you the total including state and county sales tax.\n");

    System.out.println("Please note the following:\n1. The input should be an amount over zero.\n2. You can enter an integer or decimal amount.\n" +
      "3. If a decimal amount is entered, do not enter anything greater than 2 decimal places.\n4. Do not enter commas.\n");

    // Continuously prompt user until valid input is received.
    while (true) {                                                   // Begin loop.
      System.out.println("Enter the sale amount ...");             // Ask user for input.
      String input = scanner.nextLine();                             // Create local string variable 'input' to capture user input.
      try {                                                          // Try the following...
        saleAmount = new BigDecimal(input);                            // Initialize saleAmount object equal to the user input string.
        if (saleAmount.stripTrailingZeros().scale() <= 2 &&            // If user input has less than 2 decimal values AND...
          saleAmount.compareTo(MIN_VALUE) > 0) {                       // ...is greater than zero.
          break;                                                       // Exit the while loop (continue on line 63).
        } else {                                                    // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
          }
      } catch (NumberFormatException invalidInput) {  // Handle exceptions for characters in user input that are not a valid repesentation of a BigDecimal (from line 48).
        System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
      }
    }

    // Close scanner to relinquish memory resources.
    scanner.close();

    // Format input for better readability.
    DecimalFormat df = new DecimalFormat("#,###.00");
    String startingAmountFormatted = df.format(saleAmount);

    // Perform calculations.
    BigDecimal stateTax = saleAmount.multiply(STATE_TAX).setScale(2, RoundingMode.HALF_UP);;
    BigDecimal countyTax = saleAmount.multiply(COUNTY_TAX).setScale(2, RoundingMode.HALF_UP);;
    BigDecimal totalTax = stateTax.add(countyTax).setScale(2, RoundingMode.HALF_UP);;
    BigDecimal finalAmount = saleAmount.add(totalTax).setScale(2, RoundingMode.HALF_UP);;

    // Provide output to user.
    System.out.println("\nSale amount = $" + startingAmountFormatted);
    System.out.println("State tax @ 4% = $" + stateTax);
    System.out.println("County tax @ 2% = $" + countyTax);
    System.out.println("Total tax = $" + totalTax);
    System.out.println("Final amount = $" + finalAmount);
    System.out.println("\nThank you!\n");

  }
}