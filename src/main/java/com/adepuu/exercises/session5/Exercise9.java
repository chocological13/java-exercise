package com.adepuu.exercises.session5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise9 {

  /**
   * Java Program to get the number of temps you have to wait after the i-th day to get a warmer temperature
   * <p>
   * Example 1: Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0]
   * <p>
   * Example 2: Input: temperatures = [30,40,50,60] Output: [1,1,1,0]
   * <p>
   * Example 3: Input: temperatures = [30,60,90] Output: [1,1,0]
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter array size: ");
    int arraySize = scan.nextInt();

    List<Integer> temps = new ArrayList<>();
    System.out.println("Enter temperatures: ");
    for (int i = 0; i < arraySize; i++) {
      int num = scan.nextInt();
      temps.add(num);
    }

    System.out.println("Your current array of temperature is: " + temps);

    List<Integer> tempDays = new ArrayList<>();
    for (int i = 0; i < arraySize; i++) {
//      System.out.println("iteration i: " + i + " " + tempDays);
      for (int j = i + 1; j < arraySize; j++) {
        if (temps.get(j) > temps.get(i)) {
          int dayDiff = j - i;
          tempDays.add(dayDiff);
          break;
        }
//        System.out.println("iteration i: " + i + " and j: " + j + " " + tempDays);
      }

      // if there are no warmer days after temp at day(i), we use try catch method to see if the array list in that
      // index is null (it doesn't exist bc we didn't add anything to it from the if statement) and assign 0 to it.
      try {
        tempDays.get(i);
      } catch (IndexOutOfBoundsException e) {
        tempDays.add(i, 0);
      }
//      System.out.println("current array: " + tempDays);
    }

    System.out.print("How many days till it's warmer: " + tempDays);
  }
}
