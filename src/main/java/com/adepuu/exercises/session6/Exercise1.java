package com.adepuu.exercises.session6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {

  /**
   * Write a Java Program to Enter numbers to calculate average and enter 'q' to finish.
   * <p>
   * Input: 1, 2, 3, 4, 5, q Output: 3
   * <p>
   * Input: 1, 2, 3, a, b, 4, 5, q Output: 3
   * <p>
   * Explanation: print &ldquo;Invalid input. Please enter a valid number or 'q' to finish.&rdquo; if user not inserting the
   * expected number or character.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    List<Integer> numbers = new ArrayList<>();
    // initialize boolean
    boolean validInput = true;

    System.out.println("Please enter numbers to average. Press 'q' to stop the input.");
    while (validInput) {
    try {
      if (scan.hasNextInt()) {
        int num = scan.nextInt();
        numbers.add(num);
      } else {
        String exit = scan.next();
        if (exit.equalsIgnoreCase("q")) {
          validInput = false;
        } else {
          throw new InputMismatchException("Please enter number or 'q' to stop input");
        }
      }
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        validInput = true;
      }
      scan.nextLine();
    }
    scan.close();

    System.out.println("Your numbers are: " + numbers);

    System.out.println("Your average is: " + average(numbers));
  }

  public static float average(List<Integer> numbers) {
    float total = 0;
    for (int number : numbers) {
      total += number;
    }

    return total / numbers.size();
  }
}
