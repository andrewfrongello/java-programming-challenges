/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-18

Task challenge: "Body Mass Index (BMI) is a measure of health on weight. It can be calculated by taking your weight in kilograms and dividing
by the square of your height in meters. The interpretation of BMI for people 16 years or older is as follows:
  * Below 18.5 = underweight
  * 18.5 to 24.9 = normal
  * 25.0 to 29.9 = overweight
  * Above 30.0 = obese"

Program description: The program asks the user to to enter their height and weight, calculates their BMI, finds the category which they are
considered part of (underweight, normal, overweight, or obese), then displays the results back to the user. The program uses two while loops
to continuously prompt the user for input until valid inputs are received. The results logic is implemented using a while loop to allow the
use of break statements which prevents the evaluation of further cases once a match is found. One important note here is in line 93 where,
originally, I had set scale to 2 and found that some inputs were causing the program to hang. While debugging, I realized that having the
scale set to 2 was generating results that were between categories (e.g. the BMI was between 24.9 and 24.99). Setting the scale to 1 fixed
this issue.

To do:
  * Add methods to help user calculate their height and weight if they do not know it in meters and kilograms.
*/

// Import necessary classes.
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

// Declare class BmiCalculator.
class BmiCalculator {

  public static void main(String[] args) {
    
    // Instantiate and initialize scanner object.
    Scanner scanner = new Scanner(System.in);

    // Create variable for user input.
    final BigDecimal MIN_VALUE = new BigDecimal("0");         // Use zero for height and weight to prevent user from entering negative numbers.
    final BigDecimal MAX_HEIGHT = new BigDecimal("2.75");     // Use 2.75 meters for max height, which is the maximum recorded height for a person.
    final BigDecimal MAX_WEIGHT = new BigDecimal("635");      // Use 635 kg as max weight, which is the maximum recorded weight for a person.
    BigDecimal userWeight = new BigDecimal(0);
    BigDecimal userHeight = new BigDecimal(0);

    // Greet user and explain program.
    System.out.println("\nHello User :)\n\nEnter you height and weight and I will show you your body mass index (BMI).\n");

    // Continuously prompt user for height until a valid input is received.
    while (true) {                                                                          // Begin loop.
      System.out.println("Enter your height in meters..." +                                 // Ask user to enter their height.
        "(must be between 0 and 2.75 with no more than 2 decimal places): ");               // Provide input limitations.
      String input = scanner.nextLine();                                                    // Create string variable 'input' to capture user input.
      try {                                                                                 // Try the following...
        userHeight = new BigDecimal(input);                                                     // Initialize miles object equal to the user input string.
        if (userHeight.stripTrailingZeros().scale() <= 2 &&                                     // If user input has 2 or less decimal place AND...
          userHeight.compareTo(MIN_VALUE) > 0 &&                                                // ...is greater than zero AND...
          userHeight.compareTo(MAX_HEIGHT) <= 0) {                                              // ...is less than or equal to the max height...
          break;                                                                            // Exit the loop (continues on line 71).
        } else {                                                                            // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: You either entered a character, a number greater than 2 decimal places, or a number outside of the valid range.\n" +
            "Please check and try again...\n");
        }
      } catch (NumberFormatException invalidInput) {    // Handle exceptions for characters in user input that are not a valid repesentation of a BigDecimal (from line 55).
        System.out.println("\nERROR: You either entered a character, a number greater than 2 decimal places, or a number outside of the valid range.\n" +
          "Please check and try again...\n");
      }
    }
    
    // Do the same thing for weight.
    while (true) {                                                                          // Begin loop.
      System.out.println("\nEnter your weight in kilograms..." +                            // Ask user to enter their weight.
        "(must be between 0 and 635 with no more than 2 decimal places): ");                // Provide input limitations.
      String input = scanner.nextLine();                                                    // Create string variable 'input' to capture user input.
      try {                                                                                 // Try the following...
        userWeight = new BigDecimal(input);                                                     // Initialize miles object equal to the user input string.
        if (userWeight.stripTrailingZeros().scale() <= 2 &&                                     // If user input has 2 or less decimal place AND...
          userWeight.compareTo(MIN_VALUE) > 0 &&                                                // ...is greater than zero AND...
          userWeight.compareTo(MAX_WEIGHT) <= 0) {                                              // ...is less than or equal to the max weight...
          break;                                                                            // Exit the while loop (continue on line 92).
        } else {                                                                            // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: You either entered a character, a number greater than 2 decimal places, or a number outside of the valid range.\n" +
            "Please check and try again...\n");
        }
      } catch (NumberFormatException invalidInput) {    // Handle exceptions for characters in user input that are not a valid repesentation of a BigDecimal (from line 76).
        System.out.println("\nERROR: You either entered a character, a number greater than 2 decimal places, or a number outside of the valid range.\n" +
          "Please check and try again...\n");
      }
    }

    // Close scanner to relinquish memory resources.
    scanner.close();

    // Perform calculations, BMI = kg / m^2
    BigDecimal heightSquared = userHeight.multiply(userHeight).setScale(10, RoundingMode.HALF_UP);      // Set scale to 10 to preserve precision.
    BigDecimal bmi = userWeight.divide(heightSquared, 1, RoundingMode.HALF_UP);                            // Set scale to 1 for logic loop below.

    // Find the interpretation value.
    // The while loop will allow us to use break statements to prevent further conditions from being evaluated after a match is found.
    String category = "";                                                      // Create String variable to hold the result.
    while (true) {                                                             // Begin loop.
      if (bmi.compareTo(BigDecimal.valueOf(18.5)) < 0) {                   // If BMI is below 18.5...
        category = "underweight";                                              // ...assign value of 'underweight' to the category variable...
        break;                                                                 // ...and break from the loop (continues on line 115).
      }
      if (bmi.compareTo(BigDecimal.valueOf(18.5)) >= 0 &&                  // If BMI is greater than or equal to 18.5 AND...
        bmi.compareTo(BigDecimal.valueOf(24.9)) <= 0) {                    // ...less than or equal to 24.9...
        category = "normal";                                                   // ...assign value of 'normal' to the category variable...
        break;                                                                 // ...and break from the loop (continues on line 115).
      }
      if (bmi.compareTo(BigDecimal.valueOf(25.0)) >= 0 &&                  // If BMI is greater than or equal to 25.0 AND...
        bmi.compareTo(BigDecimal.valueOf(29.9)) <= 0) {                    // ...less than or equal to 29.9...
        category = "overweight";                                               // ...assign the value of 'overweight' to the category variable...
        break;                                                                 // ...and break from the loop (continues on line 115).
      }
      if (bmi.compareTo(BigDecimal.valueOf(30.0)) > 0) {                   // If BMI is greater than 30.0...
        category = "obese";                                                    //...assign the value of 'obese' to the category variable...
        break;                                                                 //...and break from the loop (continues on line 115).
      }
    }

    // Display results back to user.
    System.out.println("\nAccording to your height of " + userHeight + " meters and your weight of " + userWeight + " kilograms, your BMI is " + bmi + " which is considered \"" + category + "\".");
    System.out.println("\nThank you!\n");
  }
}