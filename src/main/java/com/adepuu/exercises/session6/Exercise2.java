package com.adepuu.exercises.session6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercise2 {
    /**
     * Complete the file reader program below
     * and handle all edge cases using try-catch-finally based on the logic given
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        try {
          readFileContents(fileName);
        } catch (NullPointerException e) {
          e.getCause();
        }
        scanner.close();
    }

    static void readFileContents(String fileName) {
        BufferedReader reader = null;
        try {
          reader = new BufferedReader(new FileReader(fileName));
          String line;
          while ((line = reader.readLine()) != null) {
            System.out.println(line);
          }
        } catch (IOException e) {
          System.out.println("There was an error opening file " + e.getMessage());
        } finally{
          if (reader != null) {
            try {
              reader.close();
            } catch (IOException e2) {
              System.out.println("Now there's an error closing the file D:");
              e2.printStackTrace();
            }
          }
        }
    }
}
