/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-11
Task challenge: "This program lets the user enter the amount as an integer representing cents and output a report listing the monetary 
  equivalent in single dollars, quarters, dimes, nickels, and pennies. Your program should report maximum number of dollars, then the maximum 
  number of quarters, dimes and so on, in that order."
Description: The program ask for user input in cents, calculates the demonitations, and displays the results back to the user. For validation,
  the program will continuously prompt the user for input until a positive integer is entered.
*/


// Import necessary classes.
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

// Declare class MoneyConverter.
class MoneyConverter {

  // Main method.
  public static void main(String[] args) {

    // Instantiate and initialize an object 'scanner', of the Scanner class, which reads from standard input.
    Scanner scanner = new Scanner(System.in);

    // Create local variables for user input and output.
    final BigDecimal DOLLAR_AMOUNT = new BigDecimal("100");
    final BigDecimal QUARTER_AMOUNT = new BigDecimal("0.25");
    final BigDecimal DIME_AMOUNT = new BigDecimal("0.10");
    final BigDecimal NICKEL_AMOUNT = new BigDecimal("0.05");
    final BigDecimal PENNIES_AMOUNT = new BigDecimal("0.01");
    final BigDecimal MIN_VALUE = new BigDecimal(0);
    BigDecimal userAmount = new BigDecimal(0);

    // Greet user and explain valid inputs.
    System.out.println("\nGreetings User!\n\nEnter an amount of money in cents and I will show you the breakdown in dollars, quarters, dimes, " +
      "nickels, and pennies.\n");

    System.out.println("Please note the following:\n1. Input should be positive integers only, no decimal amounts.\n2. Do not enter commas.\n");

    // Continuously prompt user until valid input is received.
    while (true) {                                                                                    // Begin loop.
      System.out.println("Enter an amount of money in cents...");                                   // Ask user for input.
      String input = scanner.nextLine();                                                              // Create local string variable 'input' to capture user input.
      try {                                                                                           // Try the following...
        userAmount = new BigDecimal(input);                                                               // Initialize userAmount object equal to the user input string.
        if (userAmount.stripTrailingZeros().scale() <= 0 && userAmount.compareTo(MIN_VALUE) > 0) {        // If user input is an integer above zero.
          break;                                                                                          // Exit the while loop (continue on line 63).
        } else {                                                                                      // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
          }
      } catch (NumberFormatException invalidInput) {  // Handle exceptions for characters in user input that are not a valid repesentation of a BigDecimal (from line 49).
        System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
      }
    }
      
    // Close scanner to relinquish memory resources.
    scanner.close();

    //Calculations section.
    BigDecimal startingAmount = userAmount.divide(DOLLAR_AMOUNT).setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal dollars = userAmount.divideToIntegralValue(DOLLAR_AMOUNT).setScale(0, RoundingMode.HALF_UP);
    BigDecimal changeAfterDollars = startingAmount.subtract(dollars);
    BigDecimal quarters = changeAfterDollars.divideToIntegralValue(QUARTER_AMOUNT).setScale(0, RoundingMode.HALF_UP);
    BigDecimal amountToSubtractQuarters = quarters.multiply(QUARTER_AMOUNT).setScale(2, RoundingMode.HALF_UP);
    BigDecimal changeAfterQuarters = changeAfterDollars.subtract(amountToSubtractQuarters);
    BigDecimal dimes = changeAfterQuarters.divideToIntegralValue(DIME_AMOUNT).setScale(0, RoundingMode.HALF_UP);
    BigDecimal amountToSubtractDimes = dimes.multiply(DIME_AMOUNT).setScale(2, RoundingMode.HALF_UP);
    BigDecimal changeAfterDimes = changeAfterQuarters.subtract(amountToSubtractDimes);
    BigDecimal nickels = changeAfterDimes.divideToIntegralValue(NICKEL_AMOUNT).setScale(0, RoundingMode.HALF_UP);
    BigDecimal amountToSubtractNickels = nickels.multiply(NICKEL_AMOUNT).setScale(2, RoundingMode.HALF_UP);
    BigDecimal changeAfterNickels = changeAfterDimes.subtract(amountToSubtractNickels);
    BigDecimal pennies = changeAfterNickels.divideToIntegralValue(PENNIES_AMOUNT).setScale(0, RoundingMode.HALF_UP);

    // Perform some post-calculation formatting for output to enhance readability for user.
    DecimalFormat df = new DecimalFormat("#,###.00");
    String startingAmountFormatted = df.format(startingAmount);

    // Display results to user.
    System.out.println("\nBreakdown for $" + startingAmountFormatted);
    System.out.println("Dollars = " + dollars);
    System.out.println("Quarters = " + quarters);
    System.out.println("Dimes = " + dimes);
    System.out.println("Nickels = " + nickels);
    System.out.println("Pennies = " + pennies);
    System.out.println("\nThank you!\n");

  }
}