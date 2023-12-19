package RMI;

import Server.Room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BookingInterface extends Remote {
    void selectRoom(Integer index) throws RemoteException;
    Double CalcTotal(ArrayList<Room> cart, Integer duration) throws RemoteException;
    Double Duration(Room room, String start, String end) throws RemoteException;
    void addSpa() throws RemoteException;
     public void createBooking() throws RemoteException;
}

