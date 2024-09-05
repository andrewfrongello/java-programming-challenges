/*
Name: Andrew Frongello
Class section: COP2800-2245-2501
Instructor: Jose Aparicio Yanes
Date: 2024-07-03

Task challenge: "Suppose that the tuition for a university is $10,000 this year 
and tuition increases 7% every year. Write a program that calculates in how many 
years the tuition will be doubled. Use while loops."

Program description: The program first initializes two variables representing the
beginning tuition of 10,000 and the year, AND two constants representing the
annual tuition increase of 7% and the target value of 20,000. DecimalFormat is
used to provide standard financial formatting for the tuition variable for when it
needs to be displayed to the user. A while loop is then used to find the tuition of
each subsequent year until the tuition doubles (reaches the target value of 20,000).
I set the termination expression to be when the value of tuition is greater than the
target value. This stops the loop one decrement before crossing the target value.
So, to find the final year, one last increment is performed after the loop. The
result is then shown to the user.
*/


import java.math.BigDecimal;
import java.text.DecimalFormat;

class TuitionCalculatorWhiles {
  public static void main(String[] args) {
    
    BigDecimal tuition = new BigDecimal(10000);
    final BigDecimal INCREASE = new BigDecimal(0.07);
    final BigDecimal TARGET = new BigDecimal(20000);
    int year = 1;

    DecimalFormat df = new DecimalFormat("$#,###.00");
    String tuitionFormatted = df.format(tuition);

    while (tuition.compareTo(TARGET) <= 0) {
      System.out.println("\nYear: " + year);
      System.out.println("Tuition: " + tuitionFormatted);
      tuition = tuition.add(tuition.multiply(INCREASE));
      tuitionFormatted = df.format(tuition);
      year++;
    }

    tuition = tuition.add(tuition.multiply(INCREASE));
    tuitionFormatted = df.format(tuition);
    System.out.println("\nYear: " + year);
    System.out.println("Tuition: " + tuitionFormatted);
    System.out.println("\nYour tuition will double after " + year + " years.\n");
  }
}