package p1;
import java.util.ArrayList;
class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    // Constructor
    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    // Initialize rooms with room numbers, types, and prices
    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Single", 100));
        rooms.add(new Room(201, "Double", 150));
        rooms.add(new Room(202, "Double", 150));
        rooms.add(new Room(301, "Suite", 300));
        rooms.add(new Room(302, "Suite", 300));
    }

    // Display available rooms
    public void showAvailableRooms() {
        System.out.println("\n=== Available Rooms ===");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                room.displayRoomDetails();
            }
        }
    }

    // Search for a room by type
    public Room searchRoomByType(String roomType) {
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && !room.isBooked()) {
                return room;
            }
        }
        return null;
    }

    // Make a reservation
    public void makeReservation(String guestName, String roomType) {
        Room availableRoom = searchRoomByType(roomType);
        if (availableRoom != null) {
            availableRoom.bookRoom();
            Reservation reservation = new Reservation(availableRoom, guestName);
            reservations.add(reservation);
            System.out.println("Room successfully booked!");
            reservation.displayBookingDetails();
        } else {
            System.out.println("Sorry, no available rooms of the requested type.");
        }
    }

    // Show all reservations
    public void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations yet.");
        } else {
            System.out.println("\n=== Booking Details ===");
            for (Reservation reservation : reservations) {
                reservation.displayBookingDetails();
            }
        }
    }

    // Process payment for a reservation
    public void processPayment(String guestName) {
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                System.out.printf("Payment of $%.2f processed for %s%n", reservation.getTotalAmount(), guestName);
                return;
            }
        }
        System.out.println("No reservation found for the given guest name.");
    }
}