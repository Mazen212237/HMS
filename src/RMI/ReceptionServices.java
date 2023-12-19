package RMI;

import Server.Food;
import Server.Room;
import Server.Guest;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ReceptionServices extends Remote {

    List<Room> displayRoomAvailability() throws RemoteException;

    List<Food> getMenu() throws RemoteException;
    
    List<Guest> addVisitor() throws RemoteException;
    
    List<Room> getAllRooms() throws RemoteException;
 
    
}
