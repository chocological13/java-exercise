package com.adepuu.exercises.session5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise8 {

  /**
   * Java String Program to Find all Duplicates on Array
   * <p>
   * Example 1: Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
   * <p>
   * Example 2: Input: nums = [1,1,2] Output: [1]
   * <p>
   * Example 3: Input: nums = [1] Output: []
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Please enter array size: ");
    int arraySize = scan.nextInt();

    List<Integer> numbers = new ArrayList<>();
    System.out.println("Please enter array elements:");
    for (int i = 0; i < arraySize; i++) {
      int num = scan.nextInt();
      numbers.add(num);
    }

    System.out.println("Your current array is: " + numbers);
    scan.nextLine();
    scan.close();

//    if (!(findDupes(numbers).isEmpty())) {
//      System.out.println("Your new array is: " + numbers);
//    } else {
//      System.out.println("There are no duplicates in your array.");
//    }

    List<Integer> diffArr = new ArrayList<>();

    for (int i = 0; i < numbers.size(); i++) {
//      System.out.println("i iteration: " + i);
      // compare with i+1
      for (int j = i + 1; j < numbers.size(); j++) {
        // if there's a duplicate AND it's not already added into the array, add into the array
        if (!diffArr.contains(numbers.get(i)) && numbers.get(i).equals(numbers.get(j))) {
//          System.out.println("j iteration: " + j);
          diffArr.add(numbers.get(i));
          break;
        }
      }
    }

    System.out.println("Your new array is: " + diffArr);
  }

//  public static List<Integer> findDupes(List<Integer> nums) {
//    List<Integer> diffArr = new ArrayList<>();
//
//    for (int i = 0; i < nums.size(); i++) {
//      // compare with i+1
//      for (int j = i + 1; j < nums.size(); j++) {
//        System.out.println(i);
//        // if there's a duplicate AND it's not already added into the array, add into the array
//        if (!diffArr.contains(nums.get(i)) && nums.get(i).equals(nums.get(j))) {
//          System.out.println(j);
//          diffArr.add(nums.get(i));
//          break;
//        }
//      }
//    }
//    return diffArr;
//  }

  // Sir, if you see this, istg, I don't know why the method at the bottom doesn't work. I tried for like 2 hours
  // probably. I tried the debugger, I tried 4 different AIs to see where I went wrong. For some reason on iteration
  // i = 0, the j = 3. And I have no idea how that could even remotely be possible. I'm sad, angry, tired, and very
  // hungry :( But anyways I'm sorry for all the comments, I'm a little too agitated to tidy up. The method in main
  // works tho. Cheers :"
}
