/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

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
//        LoginInterface li=new Login();
//        Registry r=LocateRegistry.createRegistry(1099);
//        r.bind("Login", li);
//        
//        System.out.println("The Server is ready!");

    Guest g=new Guest();
    
        
    }
    
}
