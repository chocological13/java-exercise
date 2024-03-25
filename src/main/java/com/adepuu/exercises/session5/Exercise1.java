package com.adepuu.exercises.session5;

import java.util.Scanner;

public class Exercise1 {

public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Ask user for array
    System.out.print("Enter size of array: ");
    int arraySize = scan.nextInt();
    int[] numbers = new int[arraySize];

    System.out.println("Enter array element:");
    for (int i = 0; i < arraySize; i++) {
      numbers[i] = scan.nextInt();
    }
    scan.nextLine();
    scan.close();

    // Show the user their array
    System.out.print("Your array is: ");
    for (int i = 0; i < arraySize; i++) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    // Initialize largest number as placeholder
    int largest = numbers[0];
    // Find the largest number
    for (int i = 0; i < arraySize; i++) {
      if (numbers[i] > largest) {
        largest = numbers[i];
      }
    }

    System.out.println("The largest number is: " + largest);
  }
}
