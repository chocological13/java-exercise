package com.adepuu.exercises.session5;

import java.util.Scanner;

public class Exercise7 {

  /**
   * Java String Program to Check Anagram
   * <p>
   * Example 1: Input: s = "anagram", t = "nagaram" Output: true
   * <p>
   * Example 2: Input: s = "rat", t = "car" Output: false
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter first word: ");
    String s = scan.nextLine();

    System.out.print("Enter second word: ");
    String t = scan.nextLine();
    scan.close();

    System.out.println(isAnagram(s, t));
  }

  public static boolean isAnagram(String s, String t) {
    // check the length, bc diff length means not anagram
    if (s.length() != t.length()) {
      return false;
    }

    // turn to lowercase to do comparison later
    s = s.toLowerCase();
    t = t.toLowerCase();

    // create an array to store occurrences of each character (using int ASCII)
    // array size of 26 bc we alr turned the string to lowercase
    // initially, this array will have 26 0s in the array
    int[] count = new int[26];

    // iterate through string s and increment the count
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      // [s.charAt(i) - 'a'] is gonna be the difference between the ASCII value of the character which will give us
      // the index of count[] whose value we will increment
    }

    // now we iterate through string s
    for (int i = 0; i < t.length(); i++) {
      // but instead, we are going to decrement the occurrence
      count[t.charAt(i) - 'a']--;
      // if any occurrence becomes negative, it means there's a character in t that does not exist in s
      if (count[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
