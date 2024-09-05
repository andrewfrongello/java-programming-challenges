/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-17

Task challenge: "Write a program that prompts the user to enter an integer. If the number is a multiple of 5, print Hi Five.
If the number is divisible by 2, print Hi Even."

Program description: The program ask the user to enter a number, calculates the modulus of the number with 5 and 2, then displays the results 
back to the user. If the number is evenly divisible by 5 or 2, the modulus will be zero. To account for numbers not fitting the criteria, two 
extra cases were added so that the user will still receive an answer.
*/


import java.util.Scanner;

// Declare class OddOrEven.
class OddOrEven {
  public static void main(String[] args) {

    // Instantiate and initialize an object 'scanner', of the Scanner class, which reads from standard input.
    Scanner scanner = new Scanner(System.in);

    // Create variable for user input.
    int userNumber = 0;

    // Greet user and prompt for input.
    System.out.println("\nHello User!\n\nEnter an integer...\n");

    // Continuously prompt user until valid input is received.
    while (true) {                                                                          // Begin loop.
      if (scanner.hasNextInt()) {                                                           // If the input is an integer...
        userNumber = scanner.nextInt();                                                     // ...assign the input to the userNumber variable...
        break;                                                                              // ...and break out of the loop.
      } else {                                                                              // Otherwise...
        System.out.println("\nERROR: You entered a character that is not an integer. " +    // ...print that there was an error...
        "Please try again...\n");                                                           // ...and for the user to try again...
        scanner.next();                                                                     // ...process the invalid input to prevent an infinite loop.
      }
    }
    
    // Close scanner to relinquish memory resources.
    scanner.close();

    // Perform calculations to find criteria for logic.
    int divideByFiveCheck = userNumber % 5;
    int divideByTwoCheck = userNumber % 2;

    // Print a blank line.
    System.out.println("");
    
    // Implement logic and outputs.
    if (divideByFiveCheck == 0 ) {
      System.out.println("Hi Five!");
    }
    if (divideByTwoCheck == 0) {
      System.out.println("Hi Even!");
    }
    if (divideByFiveCheck != 0 ) {
      System.out.println("The number is not a multiple of 5...");
    }
    if (divideByTwoCheck != 0) {
      System.out.println("The number is not divisible by 2...");
    }
    System.out.println("\nThank you!\n");
  }
}