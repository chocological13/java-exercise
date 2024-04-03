package com.adepuu.exercises.session11;

import static java.util.Collections.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchTree {

  /**
   * Write a Java binary search tree program that can scale dynamically
   * <p>
   * As a user, I want to insert N-numbers into a binary search tree and then search for a specific number. After
   * searching, the program should prompt me to search for another number without terminating.
   * <p>
   * Acceptance Criteria: - The program should start by prompting the user to enter the number of elements (N) they wish
   * to insert into the binary search tree. - The program should then prompt the user to enter N numbers one by one.
   * <p>
   * Acceptance Criteria: - The program should correctly insert each number into the binary search tree in a way that
   * maintains the binary search tree properties (all nodes in the left subtree are less than the root, and all nodes in
   * the right subtree are greater than the root). - The program should handle duplicate numbers appropriately, either
   * by ignoring them or by updating the existing node. - After inserting all N-numbers, the program should prompt the
   * user to enter a number to search for within the binary search tree. - The program should perform a binary search to
   * find the entered number, following the binary search tree properties. - The program should display whether the
   * number is found or not. - The program should provide a clear and straightforward way for the user to exit the
   * continuous search loop and terminate the program, such as entering a specific keyword or command.
   */

  class Node {
    int data;
    Node left;
    Node right;

    public Node (int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // BinarySearchTree
  private Node root;
  public BinarySearchTree() {
    this.root = null;
  }

  public void insert(int data) {
    root = insertRecursive(root, data);
  }
  private Node insertRecursive(Node current, int data) {
    if (current == null) {
      return new Node(data);
    }

    if (data < current.data) {
      current.left = insertRecursive(current.left, data);
    } else if (current.data < data) {
      current.right = insertRecursive(current.left, data);
    }

    return current;
  }

  public boolean search(int data) {
    return searchRecursive(root, data);
  }

  public boolean searchRecursive(Node current, int data) {
    if (current == null) {
      return false;
    }

    if (data == current.data) {
      return true;
    }

    if (data < current.data) {
      return searchRecursive(current.left, data);
    } else {
      return searchRecursive(current.right, data);
    }
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    BinarySearchTree bst = new BinarySearchTree();

    boolean searchLoop = false;
    while(!searchLoop) {
      System.out.println("Enter numbers (enter 'q' to go to search loop):");
      if (scan.hasNextInt()) {
        int num = scan.nextInt();
        scan.nextLine();
        bst.insert(num);
      } else if (scan.nextLine().equalsIgnoreCase("q")) {
        searchLoop = true;
      } else {
        System.out.println("Invalid input");
      }
    }

    while(searchLoop) {
      System.out.println("Enter a number to search for (press anything else to quit):");
      if (scan.hasNextInt()) {
        int search = scan.nextInt();
        scan.nextLine();
        boolean found = bst.search(search);
        if (found) {
          System.out.println(search + " is present in the binary tree");
        } else {
          System.out.println(search + " not found");
        }
      } else {
        scan.nextLine();
        searchLoop = false;
      }
    }

    scan.close();
  }


}
