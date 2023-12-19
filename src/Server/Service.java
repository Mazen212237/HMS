package Server;

import RMI.ReceptionServices;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Service extends UnicastRemoteObject implements ReceptionServices {

    private List<Room> availableRooms;
    private List<Room> allRooms;
    private List<Food> menu;
    private List<Guest> guestList;

    public Service() throws RemoteException {
        availableRooms = new ArrayList<>();
        menu = new ArrayList<>();
        guestList = new ArrayList<>();
    }

    @Override
    public List<Room> displayRoomAvailability() throws RemoteException {
        
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if ("available".equalsIgnoreCase(room.getStatusRoom())) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public List<Guest> addVisitor() throws RemoteException {
                Guest newGuest = new Guest("New Guest", "newUsername", "newPassword", "newEmail",
                        "newPhoneNumber", "newDOB", "newAddress");
                addGuest(newGuest);
                return getGuestList();
            
    }

    @Override
    public List<Room> getAllRooms() throws RemoteException {
        return allRooms;
    }

    private List<Room> getAvailableRooms() {
        return availableRooms;
    }

    public List<Food> getMenu() {
        return menu;
    }

    private List<Guest> getGuestList() {
       
        return guestList;
    }

    private void addGuest(Guest newGuest) {
        
        guestList.add(newGuest);
        for (Guest guest : guestList) {
            if (!guest.equals(newGuest)) {
                newGuest.setVisitor(guest);
            }
        }
    }
    
}
