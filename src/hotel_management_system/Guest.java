/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management_system;

import java.util.ArrayList;

/**
 *
 * @author gamer
 */
public class Guest extends User{
    private String GuestID;
    private User Guest;
    private ArrayList<User> Visitor;
    private ArrayList<String> Notification;


   
    
    
    public String getGuestID() {
        return GuestID;
    }

    public void setGuestID(String GuestID) {
        this.GuestID = GuestID;
    }

    public User getGuest() {
        return Guest;
    }

    public void setGuest(User Guest) {
        this.Guest = Guest;
    }

    public void setGuest(String name, String userName, String password, String email, String phoneNumber, String DOB, String Address) {
        this.Guest.setName(name);
        this.Guest.setPassword(password);
        this.Guest.setAddress(Address);
        this.Guest.setEmail(email);
        this.Guest.setUserName(userName);
        this.Guest.setDOB(DOB);
        this.Guest.setPhoneNumber(phoneNumber);
    }
        
    
    public ArrayList<User> getVisitor() {
        return Visitor;
    }

    public void setVisitor(User Visitor) {
        this.Visitor.add(Visitor);
    }

    public ArrayList<String> getNotification() {
        return Notification;
    }

    public void setNotification(String Notification) {
        this.Notification.add(Notification);
    }
    
    
}
