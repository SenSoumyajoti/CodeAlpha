package p1;
import java.util.Scanner;


// Main class
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Process Payment");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room type (Single, Double, Suite): ");
                    String roomType = scanner.nextLine();
                    hotel.makeReservation(guestName, roomType);
                    break;
                case 3:
                    hotel.showReservations();
                    break;
                case 4:
                    System.out.print("Enter guest name to process payment: ");
                    String paymentGuest = scanner.nextLine();
                    hotel.processPayment(paymentGuest);
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you for using the Hotel Reservation System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
