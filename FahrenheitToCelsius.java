/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-08
Task challenge: "Write a program that asks the user for the current temperature in degrees Fahrenheit and converts it to degrees Celsius..."
Description: The program asks for the user to input a temperature in degrees fahrenheit, calculates the corresponding temperature in degrees
  celsius, then displays the result back to the user. In this code, I decided to validate the user input by first capturing it as a string,
  then parsing it with 'BigDecimal()' since it is able to handle null input from user (user presses Enter with nothing typed). The other method
  I found was nextBigDecimal() but it does not handle null input.
*/


// Import necessary classes.
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

// Declare class FahrenheitToCelsius.
class FahrenheitToCelsius {

  // Main method.
  public static void main(String[] args) {

    // Instantiate and initialize an object 'scanner', of the Scanner class, which reads from standard input.
    Scanner scanner = new Scanner(System.in);

    // Instantiate and initialize three objects of the BigDecimal class, to use as local variables.
    final BigDecimal MIN_VALUE = new BigDecimal("-459.67");          // MIN_VALUE is as a constant equal to absolute zero.
    final BigDecimal MAX_VALUE = new BigDecimal("9.9e12");           // MAX_VALUE is as a constant equal to the maximum recorded temperature.
    BigDecimal degreesF = new BigDecimal(0);                         // degreesF will store the user input for calculations later.

    // Greet user and explain valid inputs and limitations.
    System.out.println("\nHello User!\n\nEnter a temperature in degrees Fahrenheit and I will show you the corresponding temperature in degrees celsius.\n" +
      "The number should be between " + MIN_VALUE + " which is absolute zero, and " + MAX_VALUE + " which is the maximum recorded temperature of 9.9 TRILLION degrees F. " +
      "Wow that's hot!\n");

    System.out.println("Please note the following:\n1. You can use scientific (E) notation, with or without the plus (+) sign. For example, \"9.9E12\" and \"9.9E+12\" are both valid inputs.\n" +
      "2. Do not enter commas.\n3. Fractional answers are rounded up to two decimal places.\n");

    // Continuously prompt user until valid input is received.
    while (true) {                                                                             // Begin loop.
      System.out.println("Enter a temperature in degrees F...");                             // Ask user for input.
      String input = scanner.nextLine();                                                       // Create local string variable 'input' to capture user input.
      try {                                                                                    // Try the following...
        degreesF = new BigDecimal(input);                                                         // Initialize userTemp object equal to the user input string.
        if (degreesF.compareTo(MIN_VALUE) >= 0 && degreesF.compareTo(MAX_VALUE) <= 0) {           // If user input is valid BigDecimal and within the valid range...
          break;                                                                                  // Exit the while loop (continue on line 62).
        } else {                                                                               // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nYou must enter a number within the valid range (" + MIN_VALUE + " to " + MAX_VALUE + ")." +
            "\nPlease try again...\n");
          }
      } catch (NumberFormatException invalidInput) {  // Handle exceptions for characters in user input that are not a valid repesentation of a BigDecimal (from line 47).
        System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
          "outside of the valid range.\nYou must enter a number within the valid range (" + MIN_VALUE + " to " + MAX_VALUE + ").\nPlease try again...\n");
      }
    }

    // Close scanner to relinquish memory resources.
    scanner.close();

    // Perform BigDecimal calculations to find temperature in degree celsius per formula, [C = (5 / 9)(F - 32)].
    BigDecimal numerator = new BigDecimal("5");                                                   // Create 'numerator' variable for 5 / 9 calculation.
    BigDecimal denominator = new BigDecimal("9");                                                 // Create 'denominator' variable for 5 / 9 calculation.
    BigDecimal fiveDividedByNine = numerator.divide(denominator, 15, RoundingMode.HALF_UP);     // Get the value of 5 / 9 and store as variable called 'fraction'.
    BigDecimal fMinus32 = degreesF.subtract(new BigDecimal("32"));                                // Get value of F - 32 and store in 'fMinus32' variable.
    BigDecimal degreesC = fMinus32.multiply(fiveDividedByNine);                                       // Get degrees celsius by multiplying fMinus32 by 'fraction'.
    
    // Perform some post-calculation formatting to standardize outputs and enhance user readability.
    DecimalFormat df = new DecimalFormat("#,###.##");
    String fahrenheitFormatted = df.format(degreesF);
    String celsiusFormatted = df.format(degreesC);

    // Display results to user.
    System.out.println("\nYou entered a valid temperature of " + fahrenheitFormatted + " degrees fahrenheit which is equal to ... " + celsiusFormatted + " degrees celsius.\n");
    System.out.println("Thank you!\n");

  }
}