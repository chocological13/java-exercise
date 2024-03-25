package com.adepuu.exercises.session5;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {

  //  /**
//   * Java Array Program to sort array in increasing & decreasing order
//   * <p>
//   * Example 1: Input: [ 8, 7, 5, 2], direction = &ldquo;asc&rdquo; Output: [ 2, 5, 7, 8 ]
//   * <p>
//   * Example 2: Input: [ 8, 7, 5, 2], direction = &ldquo;desc&rdquo; Output: [ 8,7, 5, 2 ]
//   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Prompt user for array
    System.out.print("Enter array size: ");
    int arraySize = scan.nextInt();
    System.out.println("Enter array elements:");
    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < arraySize; i++) {
      int number = scan.nextInt();
      numbers.add(number);
    }
    scan.nextLine();

    // Show user their array list
    System.out.println("Your current array is: " + numbers);

    // Prompt for direction
    System.out.print("How would you like to sort? (asc/desc): ");
    String direction = scan.nextLine();
    while (!(direction.equalsIgnoreCase("asc")) && !(direction.equalsIgnoreCase("desc"))) {
      System.out.println("Please only choose either asc/desc.");
      System.out.print("How would you like to sort? (asc/desc): ");
      direction = scan.nextLine();
    }
    scan.close();

    // Sort
    System.out.println("Your sorted(asc) array is: " + sort(numbers, direction));
  }

  public static ArrayList<Integer> sort(ArrayList<Integer> numbers, String dir) {
    int size = numbers.size();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        // loop through size - i - 1 because our loop decreases each time since we would already be done with
        // the iteration
        // we will compare numbers at index j and (j+1)
        // first if for asc sort
        if (dir.equalsIgnoreCase("asc")) {
          if (numbers.get(j) > numbers.get(j + 1)) {
            // initialize a temp variable to store the numbers at j index
            int temp = numbers.get(j);
            // swap j with (j + 1) if it's bigger
            numbers.set(j, numbers.get(j + 1));
            // swap (j + 1) with temp to store it back in the arraylist
            numbers.set((j + 1), temp);
          }
        } else { // this is for desc
          if (numbers.get(j) < numbers.get(j + 1)) {
            int temp = numbers.get(j);
            numbers.set(j, numbers.get(j + 1));
            numbers.set((j + 1), temp);
          }
        }
      }
    }
    return numbers;
  }
}
