/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-19

Task challenge: "This program first prompts the user to enter a year as an int value and checks if it is a leap year. A year is a leap year
if it is divisible by 4 but not by 100, or it is divisible by 400."

Program description: The program ask the user to enter a number, then checks if it is a leap year, then displays the results back to the user.
*/


// Import necessary classes.
import java.util.InputMismatchException;
import java.util.Scanner;

// Create class LeapYearChecker.
class LeapYearChecker {

  // Create the main method.
  public static void main(String[] args) {

    // Initialize and instantiate a Scanner object.
    Scanner scanner = new Scanner(System.in);

    // Declare local variable to store user input.
    int year = 0;

    // Greet user and explain the program.
    System.out.println("\nWelcome back, User!\nEnter a year and I will tell you if it is a leap year or not.\n");

    // Continuously prompt the user for input until a valid year is received.
    while (true) {
      System.out.println("Enter a year: ");
      if (scanner.hasNextInt()) {
        year = (scanner.nextInt());
        break;
      } else {
        System.out.println("\nERROR: You must enter an integer. Please check and try again...");
        scanner.next();
      }
    }

    // Close scanner to relinquish resources.
    scanner.close();

    // Check if the year is a leap year or not.
    if (((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))) {
      System.out.println("This is a leap year!\n");
    }
    else {
      System.out.println("This is not a leap year.\n");
    }
  }
}