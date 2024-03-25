package com.adepuu.exercises.session5;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {

  /**
   * Write a Java Program to Check if Array Contain Duplicates
   * <p>
   * Example 1: Input: nums = [1,2,3,1] Output: true
   * <p>
   * Example 2: Input: nums = [1,2,3,4] Output: false
   * <p>
   * Example 3: Input: nums = [1,1,1,3,3,4,3,2,4,2] Output: true
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Prompt user for input
    System.out.print("Enter array size: ");
    int arraySize = scan.nextInt();

    // Prompt user for array element
    int[] nums = new int[arraySize];
    System.out.println("Enter array elements:");
    for (int i = 0; i < arraySize; i++) {
      nums[i] = scan.nextInt();
    }

    // Print out current array for user
    System.out.print("Your array is: " + Arrays.toString(nums));

    System.out.println();
    System.out.println(dupe(nums));
  }

  public static boolean dupe(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          return true;
        }
      }
    }
    return false;
  }
}
