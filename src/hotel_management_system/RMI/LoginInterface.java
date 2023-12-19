/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gamer
 */
public interface LoginInterface extends Remote{
    String Login(String username, String password) throws RemoteException;
    void Signup(String name, String userName, String password, String email, String phoneNumber, String DOB, String Address) throws RemoteException;
}
