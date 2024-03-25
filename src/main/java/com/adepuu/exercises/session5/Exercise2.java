package com.adepuu.exercises.session5;

import java.util.Scanner;

public class Exercise2 {

  /**
   * Java Array Program For Array Rotation Input: arr[] = {1, 2, 3, 4, 5, 6, 7},  d = 2 Output:  3 4 5 6 7 1 2
   * Explanation: d=2 so 2 elements are rotated to the end of the array. So, 1 2 is rotated back So, Final result: 3, 4,
   * 5, 6, 7, 1, 2
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Prompt user for input
    // Array size
    System.out.print("Enter array size: ");
    int arraySize = scan.nextInt();

    // Array elements
    System.out.println("Enter array elements:");
    int[] numbers = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
      numbers[i] = scan.nextInt();
    }

    // Show the user their array
    System.out.print("Your current array is: ");
    for (int i = 0; i < arraySize; i++) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    // Int that the user is looking to rotate to the back
    System.out.print("Enter how many times to rotate: ");
    int d = scan.nextInt();
    scan.nextLine();
    scan.close();

    // Look for the number
    for (int i = 0; i < d; i++) {
      // Create a placeholder to keep the first number
      int temp = numbers[0];

      for (int j = 1; j < arraySize; j++) {
        // Shift each element to the left by one position
        numbers[j - 1] = numbers[j];
      }
      // Move the first element to the end
      numbers[arraySize - 1] = temp;
    }

    // Print out new array
    System.out.print("Your new array is: ");
    for (int i = 0; i < arraySize; i++) {
      System.out.print(numbers[i] + " ");
    }
  }
}
