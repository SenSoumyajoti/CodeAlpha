package p4;

import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    String preference;
    double budget;

    public Destination(String name, String date, String preference, double budget) {
        this.name = name;
        this.date = date;
        this.preference = preference;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format("Destination: %s\nDate: %s\nPreference: %s\nBudget: ₹%.2f", name, date, preference, budget);
    }
}

public class TravelItineraryPlanner {

    private ArrayList<Destination> itinerary = new ArrayList<>();

    // Method to add a destination to the itinerary
    public void addDestination(String name, String date, String preference, double budget) {
        Destination destination = new Destination(name, date, preference, budget);
        itinerary.add(destination);
        System.out.println("Destination added successfully!");
    }

    // Method to display all destinations
    public void displayItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("No destinations in the itinerary yet.");
        } else {
            System.out.println("\nYour Travel Itinerary:");
            for (Destination dest : itinerary) {
                System.out.println(dest);
                System.out.println("-------------------");
            }
        }
    }

    // Method to calculate total budget
    public void calculateTotalBudget() {
        double totalBudget = 0;
        for (Destination dest : itinerary) {
            totalBudget += dest.budget;
        }
        System.out.printf("Total Budget for the trip: ₹%.2f%n", totalBudget);
    }

    // Menu to manage the travel itinerary
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Travel Itinerary Planner Menu =====");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter travel date (e.g., 2024-12-01): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter travel preference (e.g., sightseeing, relaxation): ");
                    String preference = scanner.nextLine();
                    System.out.print("Enter budget for this destination: ₹");
                    double budget = scanner.nextDouble();
                    addDestination(name, date, preference, budget);
                    break;

                case 2:
                    displayItinerary();
                    break;

                case 3:
                    calculateTotalBudget();
                    break;

                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        planner.displayMenu(); // Start the planner
    }
}
