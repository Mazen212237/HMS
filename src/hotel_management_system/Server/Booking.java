package Server;

import RMI.BookingInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Booking extends UnicastRemoteObject implements BookingInterface {
    private static ArrayList<Room> roomList;
    ArrayList<Room> cart;
    String startDate;
    String endDate;
    Double totalPrice;
    String userId;  // Assuming each booking is associated with a user

    // Other members...

    public Booking(String userId) throws RemoteException {
        super();
        this.userId = userId;
        // Initialize other variables here if needed
    }
    
     public static void setRoomList(List<Room> roomList) {
        Booking.roomList = (ArrayList<Room>) roomList;
    }
     
    public static List<Room> getRoomList() {
        return roomList;
    }
    
    public static void addToRoomList(Room room) {
        roomList.add(room);
    }
    
    public List<Room> getCart() {
        return cart;
    }

    @Override
    public void selectRoom(Integer index) throws RemoteException {
        if ("Available".equals(roomList.get(index).getStatusRoom())) {
            roomList.get(index).setStatusRoom("Free");
            cart.add(roomList.get(index));
        }
    }

    @Override
    public Double CalcTotal(ArrayList<Room> cart, Integer duration) throws RemoteException {
        for (Room i : cart) {
            totalPrice += Duration(i, startDate, endDate);
        }
        return totalPrice;
    }

    @Override
    public Double Duration(Room room, String start, String end) throws RemoteException {
        LocalDate Start = LocalDate.parse(start);
        LocalDate End = LocalDate.parse(end);
        int length = Start.compareTo(End);
        double price = room.getPrice() * length;
        return price;
    }

    @Override
    public void addSpa() throws RemoteException {
        BookingDecorator spaDecorator = new SpaDecorator();
        totalPrice = spaDecorator.decorateBooking(totalPrice);
    }
   

    // Additional methods...

    // Method to insert the booking into the database
    public void saveBookingToDatabase() {
        DB db = new DB();  // Assuming you have a constructor for your DB class
        db.insertBooking(this);
    }

    // Method to retrieve all bookings from the database
    public static ArrayList<Booking> getAllBookingsFromDatabase() {
        DB db = new DB();
        return db.getAllBookings();
    }

    // Method to retrieve bookings for a specific user from the database
    public static ArrayList<Booking> getBookingsForUserFromDatabase(String userId) {
        DB db = new DB();
        return db.getBookingsForUser(userId);
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    public void createBooking(String userId, String startDate, String endDate, ArrayList<Room> cart, Room room) throws RemoteException {
        DB db = new DB();
        Booking booking = new Booking(userId);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.cart = cart;
        booking.Duration(room, startDate, endDate);
        booking.CalcTotal(cart, Integer.SIZE);
        
        db.insertBooking(booking);
        System.out.println("Successfully created a booking");
    }

    @Override
    public void createBooking() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
