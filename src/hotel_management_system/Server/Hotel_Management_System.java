/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import RMI.BookingInterface;
import RMI.LoginInterface;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author gamer
 */
public class Hotel_Management_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        DB db= new DB();
        LoginInterface li=new Login();
        BookingInterface Book=new Booking("1");
        Registry r=LocateRegistry.createRegistry(1099);
        r.bind("Login", li);
        r.bind("Book", Book);

        System.out.println("The Server is ready!");

        db.close();
        //testing DB connection, insert and read

//    Guest g=new Guest("Mazen","mazenalnahdi","123","mazen@gmail.com","01024688420","2002/03/28","Rehab");
//    DB db= new DB();
//    //db.InsertGuest(g);
//    String message=db.LoginGuest("mazenalnahdi","123");
//        System.out.println(message);
//
    }
    
}
