package com.adepuu.exercises.session7;

import java.util.ArrayList;
import java.util.List;

// Define interface
interface Ticketable {
  void printTicketDetails();
}
// Define a Ticket class
class Ticket implements Ticketable {

  // private instances for encapsulation
  private int ticketId;
  private String eventName;
  private double price;
  private boolean available;

  // static variables
  public static int totalTicketsSold = 0;

  // constructor for the class
  public Ticket (int ticketId, String eventName, double price) {
    this.ticketId = ticketId;
    this.eventName = eventName;
    this.price = price;
    this.available = true;
  }

  // getter methods for the instances variables
  public int getTicketId() {
    return ticketId;
  }

  public String getEventName() {
    return eventName;
  }

  public double getPrice() {
    return price;
  }

  public static int getTotalTicketsSold() {
    return totalTicketsSold;
  }

  public boolean isAvailable() {
    return available;
  }

  // setter method
  // when tickets are sold, set the availability to false and increment total sold
  public void soldTicket() {
    available = false;
    totalTicketsSold++;
  }

  // methods for desired behaviors
  public void issueConfirmation() {
    System.out.println("Ticket confirmation:");
    System.out.println("Ticket ID: " + ticketId);
    System.out.println("Event Name: " + eventName);
    System.out.println("Price: $" + price);
  }

  // implement interface
  @Override
  public void printTicketDetails() {
    System.out.println("Ticket Details:");
    System.out.println("Ticket ID: " + ticketId);
    System.out.println("Event Name: " + eventName);
    System.out.println("Price: $" + price);
  }
}

public class TicketingSystem {

  /**
   * Write a Java Program using OOP about simple ticketing system for an event.
   * <p>
   * Feature Acceptance Criteria: - Ticket Creation: The system should allow for the creation of a new ticket with a
   * unique identifier, event name, and price. - Ticket Booking: Users should be able to book a ticket by selecting an
   * event and providing their details. - Ticket Validation: The system should check if the ticket is still available
   * for booking. - Ticket Confirmation: After booking, the system should issue a confirmation ticket to the user.
   * <p>
   * OOP Concept-wise Acceptance Criteria: - Classes and Objects: The system should define a Ticket class that serves as
   * a blueprint for creating ticket objects. Each ticket object should represent a unique ticket for an event. -
   * Encapsulation: The Ticket class should encapsulate the ticket details (e.g., ticket ID, event name, price) by
   * making them private and providing public getter and setter methods to access and modify these details. - Static
   * Keyword: The Ticket class should use a static field to keep track of the total number of tickets sold,
   * demonstrating the use of static variables. - Interface Implementation (Optional): Ticket class could implement an
   * interface (e.g., Ticketable) that defines methods for printing ticket details, ensuring that all ticket types
   * adhere to a common contract.
   * <p>
   * Start your project from the main method below ;) have fun!
   */
  public static void main(String[] args) {
    List<Ticket> tickets = new ArrayList<>();

    // Create tickets
    createTicket(tickets, 1234, "Coachella", 1000);
    createTicket(tickets, 2345, "Coachella at home", 1000);

    // Book ticket
    bookTicket(tickets, 1234);
    bookTicket(tickets, 1234);
    bookTicket(tickets, 12345);

    // Check how many tickets are available
    System.out.println("Total tickets sold: " + Ticket.getTotalTicketsSold());
  }

  // method for creating ticket
  public static void createTicket(List<Ticket> tickets, int ticketId, String eventName, double price) {
    Ticket newTicket = new Ticket(ticketId, eventName, price);
    tickets.add(newTicket);
    System.out.println("Ticket created successfully!");
    newTicket.printTicketDetails();
  }

  // method for booking ticket
  public static void bookTicket(List<Ticket> tickets, int ticketId) {
    for (Ticket ticket : tickets) {
      if (ticket.getTicketId() == ticketId) {
        if (ticket.isAvailable()) {
          ticket.soldTicket();
          ticket.issueConfirmation();
        } else {
          System.out.println("Ticket for event " + ticket.getEventName() + " is not available");
        }
        return;
      } else {
        System.out.println("Ticket with ID " + ticketId + " not found");
        return;
      }
    }
  }
}
