package com.adepuu.exercises.session5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise6 {

  /**
   * Java Array Program to Remove All Occurrences of an Element in an Array
   * <p>
   * Input: array = [ 1, 2, 1, 3, 5, 1 ] , key = 1 Output: [2, 3, 5]
   * <p>
   * Explanation: all the occurrences of element 1 is removed from the array So, array becomes from [ 1, 2, 1, 3, 5, 1 ]
   * to Final result: [2, 3, 5]
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Please enter array size: ");
    int arraySize = scan.nextInt();

    ArrayList<Integer> numbers = new ArrayList<>();
    System.out.println("Please enter array elements: ");
    for (int i = 0; i < arraySize; i++) {
      int number = scan.nextInt();
      numbers.add(number);
    }

    System.out.print("Your current array is: " + numbers + "\n");

    System.out.print("What would you like to remove? ");
    int rm = scan.nextInt();
    scan.nextLine();
    scan.close();

    if (!(removeEl(numbers, rm).isEmpty())) {
      System.out.println("Your new array is: " + removeEl(numbers, rm));
    } else {
      System.out.println("Your number doesn't exist!");
    }
  }

  public static ArrayList<Integer> removeEl(ArrayList<Integer> numbers, int rm) {
    // Initialize new array list to store numbers
    ArrayList<Integer> newNum = new ArrayList<>();

    // Initialize a boolean to check if rm exists
    boolean exist = false;

    for (int i = 0; i < numbers.size(); i++) {
      // check if rm exists in the array list
      if (numbers.get(i) == rm) {
        exist = true;
        continue;
      }
      newNum.add(numbers.get(i));
    }
    if (!exist) {
      newNum.clear();
    }
    return newNum;
  }
}
