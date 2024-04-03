package com.adepuu.exercises.session11;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Queue {
    /**
     * Write a Java queue program that can scale dynamically
     * <p>
     * As a developer, I want to implement a Java queue program that can scale dynamically using a linked list, so that I can efficiently manage data storage and retrieval in my applications.
     * <p>
     * Notes:
     * The program doesn't require a menu system; focus should be on data structure implementation.
     * <p>
     * Acceptance Criteria:
     * - Functionality: The program must be able to perform basic queue operations (enqueue, dequeue, peek) on a linked list.
     * - Dynamic Scaling: The queue should automatically scale in size as elements are added or removed, without any manual resizing required by the user.
     * - Performance: The program should maintain constant time complexity for enqueue and dequeue operations, ensuring efficient data management.
     * - Memory Efficiency: The queue should use memory efficiently, allocating and deallocating memory dynamically as needed.
     * - Error Handling: The program should handle edge cases gracefully, such as attempting to dequeue an element from an empty queue, and provide clear error messages.
     */
    private Node head;
    private Node tail;
    int queueSize;

    private static class Node {
      Node next;
      int data;

      Node(int data) {
        this.data = data;
        this.next = null;
      }
    }

    public Queue() {
      head = null;
      tail = null;
      queueSize = 0;
    }

    public boolean isEmpty() {
      return this.queueSize == 0;
    }

    public int getQueueSize() {
      return queueSize;
    }

    private void enqueue(int data) {
      Node newNode = new Node(data);

      if (head == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
      queueSize++;
    }

    public void dequeue() {
      try {
        if (isEmpty()) {
          throw new EmptyStackException();
        } else {
          head = head.next;

          if(head == null) {
            tail = null;
          }

          queueSize--;
          System.out.println("Data dequeued!");
        }
      } catch (EmptyStackException e) {
        System.out.println("Queue is currently empty, nothing to dequeue!");
      }
    }

    private void peek() {
      try {
        if (!isEmpty()) {
          System.out.println("Current queue size is: " + this.getQueueSize());
          System.out.println("Data at the top of the queue is: " + head.data);
        } else {
          throw new EmptyStackException();
        }
      } catch (EmptyStackException e) {
        System.out.println("Queue is empty, no data to show!");
      }
    }

    // ? I can't really figure this out, apparently current.next is null
    // ? Not sure if I path it wrongly
//    public void display() {
//      try {
//        if (!isEmpty()) {
//          ArrayList<Integer> queueData = new ArrayList<>();
//
//          Node current = this.head;
//          while (current != null) {
//            queueData.add(current.data);
//            current = current.next;
//          }
//
//          System.out.println("Your current queue data is: " + queueData.toString());
//        } else {
//          throw new IllegalStateException();
//        }
//      } catch (IllegalStateException e) {
//        System.out.println("Queue is empty :(");
//      }
//    }

  public static void main(String[] args) {
    Queue newQueue = new Queue();

    newQueue.enqueue(1);
    newQueue.enqueue(5);
    newQueue.enqueue(7);
    newQueue.enqueue(9);
    newQueue.peek();
    System.out.println();
    newQueue.dequeue();
    newQueue.peek();
  }
}
