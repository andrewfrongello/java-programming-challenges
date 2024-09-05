/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-09

Task challenge: "Write a program that asks the user for a number representing seconds and obtains hours and minutes from the seconds."

Program description: The program asks for the user to input an amount of time in seconds, performs conversion calculations to find hours, minutes,
  and seconds, then displays the breakdown back to the user. 'Integer.parseInt(scanner.nextLine())' was used instead of 'scanner.nextInt()'
  due to it offering the same functionality but using less lines of code.
*/


// Import Scanner class from the java.util package.
import java.util.Scanner;

// Declare class TimeConverter.
class TimeConverter {

  // The main method.
  public static void main(String[] args) {

    // Instantiate and initialize the Scanner class to read from standard input.
    Scanner scanner = new Scanner(System.in);

    // Declare some local variables to help validate user input.
    // In particular, MIN_VALUE and MAX_VALUE define the range of valid input.
    final int MIN_VALUE = 1;                  // Use lower range of 1 since anything 0 or less would not really make sense.
    final int MAX_VALUE = 2_147_483_647;      // Upper range for type int.
    int userSeconds = 0;                      // Declare variable for user input.

    // Format MAX_VALUE constant to enhance user readability.
    String MAX_VALUE_FORMATTED = String.format("%,d", MAX_VALUE);

    // Greet user and explain valid inputs.
    System.out.println("\nHello User!\n\nEnter an amount of time in seconds and I will show you the hours, minutes, and seconds breakdown.\n" +
    "The number must be between " + MIN_VALUE + " and " + MAX_VALUE_FORMATTED + " ...\nDo not enter commas.\n");

    // Continuously prompt user until valid input is received.
    while (true) {                                                      // Begin loop.
      try {                                                             // Try the following...
        userSeconds = Integer.parseInt(scanner.nextLine());                // Parse user input as int and assign to the userSeconds variable.
        if (userSeconds >= MIN_VALUE && userSeconds <= MAX_VALUE) {        // If the input is an integer and within the valid range...
          break;                                                           // Break out of the while loop (i.e. program continues on line 57).
        } else {                                                        // Otherwise, print that there was an error and have user try again.
          System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
          "outside of the valid range.\nYou must enter a number within the valid range (" + MIN_VALUE + " to " + MAX_VALUE_FORMATTED + ")." +
          "\nPlease try again...\n");
        }
      } catch (NumberFormatException invalidInput) {    // Catch exceptions raised from Integer.parseInt() method on line 41 (e.g. if input is not type int).
        System.out.println("\nERROR: INVALID INPUT.\nYou either entered a character that is not a number or you entered a number that is " +
            "outside of the valid range.\nYou must enter a number within the valid range (" + MIN_VALUE + " to " + MAX_VALUE_FORMATTED + ")." +
            "\nPlease try again...\n");
      }
    }

    // Close scanner to relinquish memory resources.
    scanner.close();

    // Format the user input to enhance user readability of what they entered.
    String userSecondsFormatted = String.format("%,d", userSeconds);
    
    // Let the user know that the input was valid.
    System.out.println("\nYou entered a valid number. Here is the breakdown for " + userSecondsFormatted + " seconds...\n");

    // Perform the calculations to find hours, minutes, and seconds.
    int hours = userSeconds / 3600;
    int remainingSeconds = userSeconds % 3600;
    int minutes = remainingSeconds / 60;
    int seconds = remainingSeconds % 60;

    // Display results to user.
    System.out.println("Hours = " + hours);
    System.out.println("Minutes = " + minutes);
    System.out.println("Seconds = " + seconds +"\n");
    System.out.println("Thank you!\n");
  }
}