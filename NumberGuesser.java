/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-07-01

Task challenge: "Using do-while loops write a program that randomly generates an integer between 0 and 100, inclusive. The program prompts the user
to enter a number continuously until the number matches the randomly generated number. For each user input, the program tells the user whether the
input is too low or too high, so the user can choose the next input intelligently."

Program description: The program generates a random number from 0 to 100 and stores it in the RANDOM_NUMBER constant. The program uses a do-while
loop to continuously prompt the user to guess the random number until they guess correctly. Within the do section of the loop, a nested
while loop is used to ensure that the program does not continue until an interger from 0 to 100 is received. After valid input is received, a 
simple conditional section is used to direct the program based on the user's guess in respects to the random number. If lower than the number,
the user is prompted to guess higher, and vice versa. If equal, the program exits.
*/


import java.util.Scanner;

class NumberGuesser {

  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);                 // Create scanner instance.
    final int RANDOM_NUMBER = (int)(Math.random() * 101);     // Generate a random number from 0 to 100.
    int userGuess = 0;                                        // Initialize userGuess variable.
    System.out.println("\nWelcome Back User!\n\n" +           // Greet user and explain what to do.
    "I chose a random number from 0 to 100. Take " +
    "a guess what it is!");

    do {                                                      // Do the following...

      while (true) {                                          // Continuous user prompt until input is integer.
        if (scanner.hasNextInt()) {                           // If the input is an integer...
          userGuess = (scanner.nextInt());                    // Assign user input to the userGuess variable.
          if (userGuess >= 0 && userGuess <= 100) {           // If the input is 0 to 100...
            break;                                            // break.
          } else {                                            // Otherwise (if it's not 0 to 100)...
            System.out.println("ERROR... " +                  // Let user know there was an error and prompt again.
            "Guess a number from 0 and 100: \n");
          }
        } else {                                              // If the input was not an integer...
          System.out.println("ERROR... " +                    // Let the user know there was an error and prompt again.
          "Guess a number from 0 and 100: \n");
          scanner.next();                                     // Discard the non-integer input and ready scanner for next input.
        }
      }
      
      if (userGuess > RANDOM_NUMBER) {                        // If the user's guess was higher than the number...
        System.out.println("Lower...\n");                   // Let user know to guess lower.

      } else if (userGuess < RANDOM_NUMBER) {                 // If the user's guess was lower than the number...                
        System.out.println("Higher...\n");                  // Let the user know to guess higher.

      } else if (userGuess == RANDOM_NUMBER) {                // If the user guessed the correct number...
        System.out.println("\nYou got it!\n");              // Let the user know they guessed correctly.             
        scanner.close();                                      // Close the scanner instance.
        break;                                                // Break from the do-while loop.
      }

    } while (userGuess != RANDOM_NUMBER);                     // Repeat loop while user guess is not equal to the random number.

  }
}