package com.adepuu.exercises.session5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise4 {

  /**
   * Java Array Program to Remove Duplicate Elements From an Array
   * <p>
   * Input: [ 1, 2, 2, 3, 3, 3, 4, 5 ] Output: [ 1, 2, 3, 4, 5 ]
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Prompt user for input
    System.out.print("Enter array size: ");
    int arraySize = scan.nextInt();

    // Prompt for elements
    int[] nums = new int[arraySize];
    System.out.println("Enter array element: ");
    for (int i = 0; i < arraySize; i++) {
      nums[i] = scan.nextInt();
    }
    scan.nextLine();
    scan.close();

    System.out.println("Your array is " + Arrays.toString(nums));

    System.out.println("Your new array is " + removeDupes(nums));
  }

  public static ArrayList<Integer> removeDupes(int[] arr) {
    // initialize an array list for the unique list
    ArrayList<Integer> uniqueList = new ArrayList<>();

    // Loop
    for(int i = 0; i < arr.length; i++) {
      boolean isDupe = false;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          // remove if it's a dupe
          isDupe = true;
          break;
        }
      }
      if (!isDupe) {
        uniqueList.add(arr[i]);
      }
    }
    return uniqueList;
  }
}
