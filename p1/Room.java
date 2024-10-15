package p1;
class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean isBooked;

    // Constructor
    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isBooked = false;
    }

    // Getter methods
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    // Method to book the room
    public void bookRoom() {
        this.isBooked = true;
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.printf("Room Number: %d, Type: %s, Price: $%.2f, Status: %s%n", 
                          roomNumber, roomType, price, isBooked ? "Booked" : "Available");
    }
}
