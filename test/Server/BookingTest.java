package Server;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    private Booking booking;
    private Room room1;
    private Room room2;

    @BeforeEach
    void setUp() {
        // Initialize a Booking instance and some Room instances for testing
        try {
            booking = new Booking("user123");
            room1 = new Room("101", "Available", "Standard", 1, 2, "Standard Room", 100.0);
            room2 = new Room("201", "Available", "Deluxe", 2, 3, "Deluxe Room", 150.0);
            Booking.setRoomList(new ArrayList<>());  // Initialize an empty room list
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSelectRoom() {
        try {
            Booking.addToRoomList(room1);
            Booking.addToRoomList(room2);

            // Test selecting an available room
            booking.selectRoom(0);
            assertEquals("Free", room1.getStatusRoom());
            assertTrue(booking.getCart().contains(room1));

            // Test selecting an already booked room
            assertThrows(IndexOutOfBoundsException.class, () -> booking.selectRoom(0));
            assertEquals("Free", room1.getStatusRoom()); // Room status should remain "Free"
            assertFalse(booking.getCart().contains(room1)); // Room should not be added to the cart again

            // Test selecting a room that does not exist
            assertThrows(IndexOutOfBoundsException.class, () -> booking.selectRoom(2));

        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Exception thrown unexpectedly.");
        }
    }

    @Test
    void testCalcTotal() {
        try {
            Booking.addToRoomList(room1);
            Booking.addToRoomList(room2);

            // Test calculating total with a single room
            booking.selectRoom(0);
            assertEquals(100.0, booking.CalcTotal((ArrayList<Room>) booking.getCart(), 1));

            // Test calculating total with multiple rooms
            booking.selectRoom(1);
            assertEquals(250.0, booking.CalcTotal((ArrayList<Room>) booking.getCart(), 2));

        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Exception thrown unexpectedly.");
        }
    }

    @Test
    void testDuration() {
        try {
            // Set start and end dates
            booking.setStartDate("2023-01-01");
            booking.setEndDate("2023-01-10");

            // Test duration calculation with valid dates
            assertEquals(9.0, booking.Duration(room1, "2023-01-01", "2023-01-10"));

            // Test duration calculation with invalid dates
            assertThrows(java.time.format.DateTimeParseException.class,
                    () -> booking.Duration(room1, "invalid_start_date", "invalid_end_date"));

        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Exception thrown unexpectedly.");
        }
    }
}
