/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-13
Task challenge: "Write a program that asks the user for the number of miles driven and the gallons of gas used. It should calculate the car's 
  miles-per-gallon and display the result on the screen."
Description: The program asks the user to enter the miles driven and the gallons of gas used, calculates the MPG, and displays it back to the user.
*/


// Import necessary classes.
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

// Declare class GasEfficiencyCalculator.
class GasEfficiencyCalculator {

  // The main method.
  public static void main(String[] args) {

    // Instantiate and initialize the Scanner class to read from standard input.
    Scanner scanner = new Scanner(System.in);

    // Create local variables.
    final BigDecimal MIN_VALUE = new BigDecimal(0);
    BigDecimal miles = new BigDecimal(0).setScale(2);
    BigDecimal gallons = new BigDecimal(0).setScale(2);

    // Greet user and explain inputs.
    System.out.println("\nGreetings User!\n\nEnter the number of miles driven and the gallons of gas used and I will show you your miles per gallon!\n");

    System.out.println("Please note the following:\n1. The inputs should be an amount over zero.\n2. You can enter an integer or decimal amount. " +
      "If a decimal amount is entered, do not enter anything greater than 1 decimal place.\n4. Do not enter commas.\n" +
      "5. Fractional answers are rounded up to two decimal places.\n");

    // Continuously prompt user until valid input is received.
    while (true) {                                                        // Begin loop.
      System.out.println("Enter the number of miles driven... ");       // Ask user for input.
      String input = scanner.nextLine();                                  // Create local string variable 'input' to capture user input.
      try {                                                               // Try the following...
        miles = new BigDecimal(input);                                       // Initialize miles object equal to the user input string.
        if (miles.stripTrailingZeros().scale() <= 1 &&                       // If user input has less than 1 decimal place AND...
          miles.compareTo(MIN_VALUE) > 0) {                                  // ...is greater than zero.
          break;                                                          // Exit the while loop (continue on line 57).
        } else {                                                          // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
          }
      } catch (NumberFormatException invalidInput) {  // Handle exceptions for characters in user input that are not a valid repesentation of a BigDecimal (from line 43).
        System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
      }
    }

    while (true) {                                                        // Begin loop.
      System.out.println("\nEnter gallons of gas used... ");            // Ask user for input.
      String input = scanner.nextLine();                                  // Create local string variable 'input' to capture user input.
      try {                                                               // Try the following...
        gallons = new BigDecimal(input);                                     // Initialize gallons object equal to the user input string.
        if (gallons.stripTrailingZeros().scale() <= 1 &&                     // If user input has less than 1 decimal place AND...
          gallons.compareTo(MIN_VALUE) > 0) {                                // ...is greater than zero.
          break;                                                             // Exit the while loop (continue on line 76).
        } else {                                                          // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
          }
      } catch (NumberFormatException invalidInput) {  // Handle exceptions for characters in user input that are not a valid repesentation of a BigDecimal (from line 61).
        System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nPlease try again...\n");
      }
    }

    // Close scanner to relinquish memory resources.
    scanner.close();

    // Perform the calculation to find MPG.
    BigDecimal milesPerGallon = miles.divide(gallons, 2, RoundingMode.HALF_EVEN);

    // Display results to user.
    System.out.println("\nMiles traveled = " + miles);
    System.out.println("Gallons used = " + gallons);
    System.out.println("Miles per gallon = " + milesPerGallon);
    System.out.println("\nThank you!\n");

  }
}
