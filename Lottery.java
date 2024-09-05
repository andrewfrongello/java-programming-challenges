/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-19

Task challenge: "Write a program that randomly generates a lottery of a two-digit number, prompts the user to enter a two-digit number, and determines 
whether the user wins according to the following rule:
  * If the digits in the user input matches the lottery in exact order, the award is $10,000.
  * If the digits in the user input matches the lottery backwards, the award is $3,000.
  * If one digit in the user input matches a digit in the lottery, the award is $1,000."

Program description: The program generates a random number between 0 and 99. Then the program asks the user to enter a number within the same range.
User input is gathered via a while loop to check for invalid input. Once a valid number is received, the individual numbers of the random number
and the user input are found and stored in four variables. These individual numbers are then compared against each other through a series of
four cases to determine which case occurred and displays the respective output back to the user. The logic is implemented via a while loop to
allow the use of break statements such that no further cases are evaluated once a match is found.
*/


// Import necessary classes.
import java.util.Scanner;

// Create the Lottery class.
class Lottery {
  
  // Begin main function.
  public static void main(String[] args) {
    
    // Initialize and instantiate a Scanner object.
    Scanner scanner = new Scanner(System.in);

    // Generate a random number between 0 and 100.
    int randomNumber = (int)(Math.random() * 100);

    // Create a local variable to store user input.
    int userGuess = 0;

    // Greet user and explain the program.
    System.out.println("\nGreetings User!\n\nWant to test your luck?!!\n\nI generated a random number between 0 and 99..." +
    "Take a guess what it is and you may win a prize...\n");

    // Continuously prompt the user for input until a valid number is received.
    while (true) {
      System.out.println("Enter a number between 0 and 99: ");
      if (scanner.hasNextInt()) {
        userGuess = (scanner.nextInt());
        if (userGuess >= 0 && userGuess <= 99) {
          break;
        } else {
          System.out.println("\nERROR: You must enter an integer between 0 and 99. Please check and try again...");
        }
      } else {
        System.out.println("\nERROR: You must enter an integer between 0 and 99. Please check and try again...");
        scanner.next();
      }
    }

    // Close scanner to relinquish resources.
    scanner.close();

    // Show user the random number and their guess.
    System.out.println("\nOkay, you chose " + userGuess + " and the random number was " + randomNumber + ".\n");

    // Find the individual numbers of the userGuess variable.
    int userGuessNumber1 = userGuess / 10;
    int userGuessNumber2 = userGuess % 10;

    // Find the individual numbers of the randomNumber variable.
    int randomNumber1 = randomNumber / 10;
    int randomNumber2 = randomNumber % 10;

    // Find the appropriate case and display the respective output to the user.
    while (true) {
      // If the userGuess is equal to the randomNumber.
      if (userGuess == randomNumber) {
        System.out.println("You guessed the number correctly and win $10,000! Don't spend it all at once!\n");
        break;
      }
      // If the numbers are the same but reversed.
      if (userGuessNumber1 == randomNumber2 && userGuessNumber2 == randomNumber1) {
        System.out.println("You guessed both numbers correctly but not in the correct order. No worries, you win $3,000!\n");
        break;
      }
      // If any one number matches.
      if (userGuessNumber1 == randomNumber1 || userGuessNumber1 == randomNumber2 ||
        userGuessNumber2 == randomNumber1 || userGuessNumber2 == randomNumber2) {
        System.out.println("You guessed one number correctly and win $1,000! Buy me a coffee? :)\n");
        break;
      }
      // If no numbers match.
      if (userGuessNumber1 != randomNumber1 && userGuessNumber1 != randomNumber2 ||
        userGuessNumber2 != randomNumber1 && userGuessNumber2 != randomNumber2) {
        System.out.println("I'm sorry, you did not guess any numbers correctly. Feel free to try again though!\n");
        break;
      }
    }
  }
}