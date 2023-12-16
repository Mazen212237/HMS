/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import RMI.LoginInterface;

/**
 *
 * @author gamer
 */
public class Login extends UnicastRemoteObject implements LoginInterface{

    public Login() throws RemoteException{
    }

   
    @Override
    public String Login(String username) throws RemoteException {
        String colGuest="Guest";
        String colReceptionist="Receptionist";
        String colAdmin="Admin";
        //create DB connection for each collection
        DB dbGuest= new DB(colGuest);
        DB dbRec=new DB(colReceptionist);
        DB dbAdmin=new DB(colAdmin);
        
        //Retrieve document from any collection
        if(null!=dbGuest.getGuest(username)){
            Guest g=dbGuest.getGuest(username);
            System.out.println("Guest Found");
            return "Guest";
        }
        else if(null!=dbRec.getRecep(username)){
            Receptionist r=dbRec.getRecep(username);
            System.out.println("Receptionist Found");
            return "Receptionsit";
        }
        else if(null!=dbAdmin.getAdmin(username)){
            Admin a=dbAdmin.getAdmin(username);
            System.out.println("Admin Found");
            return "Admin";
        }
        System.out.println("No User Found");
        return "empty";
    }
    
    //Create Guest Object and add to DB
    @Override
    public void Signup(String name, String userName, String password, String email, String phoneNumber, String DOB, String Address){
        String colGuest="Guest";
        DB dbGuest= new DB(colGuest);
        dbGuest.insertGuest(name, userName, password, email, phoneNumber, DOB, Address);
        System.out.println("Successfully Signed In");
    }
}
