/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-06-20

Task challenge: "Write a program that prompts the user to enter a year and displays the animal for the year."
for year % 12:
  0 = monkey
  1 = rooster
  2 = dog
  3 = pig
  4 = rat
  5 = ox
  6 = tiger
  7 = rabbit
  8 = dragon
  9 = snake
  10 = horse
  11 = sheep

Program description: The program asks the user to enter a year and checks that is it an int. This is done via a while loop to continuously prompt the
user until a valid input is recieved. Once an int is recieved, the year modulus 12 is computed and stored in a variable which is then evaluated
in a switch statement returning the zodic animal of that respective year back to the user.
*/


// Import necessary classes.
import java.util.Scanner;

// Create class ChineseZodiac.
class ChineseZodiac {

  // Create the main method.
  public static void main(String[] args) {

    // Initialize and instantiate a Scanner object.
    Scanner scanner = new Scanner(System.in);

    // Declare local variable to store user input.
    int year = 0;

    // Greet user and explain the program.
    System.out.println("\nWelcome back, User!\nEnter a year and I will tell you which sign of the Chinese zodiac for that year.\n");

    // Continuously prompt the user for input until a valid input is received.
    while (true) {                                                                                        // Begin loop.
      System.out.println("Enter a year: ");                                                             // Prompt the user for input.
      if (scanner.hasNextInt()) {                                                                         // If the input is an integer...
        year = (scanner.nextInt());                                                                       // ...assign the input to the year variable...
        break;                                                                                            // ...and break out of the loop.
      } else {                                                                                            // Otherwise...
        System.out.println("\nERROR: You must enter an integer. Please check and try again...\n");      // ...return an error mesage to the user...
        scanner.next();                                                                                   // ...process the invalid input to prevent an infinite loop.
      }
    }

    // Close scanner to relinquish resources.
    scanner.close();

    // Implement switch case logic to find the zodic animal of the year and return output to user.
    int switchValue = year % 12;
    String animal = "";
    switch (switchValue) {
      case 0:
        animal = "monkey";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 1:
        animal = "rooster";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 2:
        animal = "dog";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 3:
        animal = "pig";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 4:
        animal = "rat";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 5:
        animal = "ox";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 6:
        animal = "tiger";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 7:
        animal = "rabbit";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 8:
        animal = "dragon";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 9:
        animal = "snake";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 10:
        animal = "horse";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
      case 11:
        animal = "sheep";
        System.out.println("\nThis is the year of the " + animal + "!\n");
        break;
    }
  }
}