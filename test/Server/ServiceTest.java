package Server;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private Service service;

    @BeforeEach
    public void setUp() {
        try {
            service = new Service();

            // Initialize sample data for testing
            List<Room> sampleRooms = new ArrayList<>();
            sampleRooms.add(new Room("101", "available", "Standard", 1, 2, "Cozy room", 100.0));
            sampleRooms.add(new Room("102", "occupied", "Deluxe", 1, 3, "Luxurious room", 150.0));

            List<Food> sampleMenu = new ArrayList<>();
            sampleMenu.add(new Food("Burger","Burger With Cheese", 10));
            sampleMenu.add(new Food("Pizza", "Vegetable Pizza",15));

            List<Guest> sampleGuestList = new ArrayList<>();
            sampleGuestList.add(new Guest("John Doe", "john_doe", "password", "john@example.com",
                    "123-456-7890", "1990-01-01", "123 Main St"));

            service.allRooms = sampleRooms;
            service.menu = sampleMenu;
            service.guestList = sampleGuestList;

        } catch (RemoteException e) {
        }
    }

    @AfterEach
    public void tearDown() {
        
    }

    @Test
    public void testDisplayRoomAvailability() {
        try {
            List<Room> availableRooms = service.displayRoomAvailability();
            assertNotNull(availableRooms);
            assertEquals(1, availableRooms.size()); 
        } catch (RemoteException e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    @Test
    public void testAddVisitor() {
        try {
            List<Guest> guestListBefore = service.addVisitor();
            service.addVisitor();
            List<Guest> guestListAfter = service.addVisitor();

            assertNotNull(guestListBefore);
            assertNotNull(guestListAfter);
            assertEquals(guestListBefore.size() + 1, guestListAfter.size());
        } catch (RemoteException e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    @Test
    public void testGetAllRooms() {
        try {
            List<Room> allRooms = service.getAllRooms();
            assertNotNull(allRooms);
            assertEquals(2, allRooms.size()); 
        } catch (RemoteException e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    @Test
    public void testGetMenu() {
        List<Food> menu = service.getMenu();
        assertNotNull(menu);
        assertEquals(2, menu.size()); 
    }
}
