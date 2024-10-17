package p1;

public class Reservation {
    private Room room;
    private String guestName;
    private double totalAmount;

    // Constructor
    public Reservation(Room room, String guestName) {
        this.room = room;
        this.guestName = guestName;
        this.totalAmount = room.getPrice();  // Reservation amount is based on room price
    }

    // Getter for guest name
    public String getGuestName() {
        return guestName;
    }

    // Getter for total amount
    public double getTotalAmount() {
        return totalAmount;
    }

    // Display the booking details
    public void displayBookingDetails() {
        System.out.printf("Booking for %s - Room %d (%s), Total: $%.2f%n",
                guestName, room.getRoomNumber(), room.getRoomType(), totalAmount);
    }
}

