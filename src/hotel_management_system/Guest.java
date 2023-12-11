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
public class Guest{
    private String GuestID;
    private ArrayList<User> Visitor;
    private ArrayList<String> Notification;


    public Guest() {
        this.GuestID = "";
        this.Visitor = new ArrayList<User>();
        this.Notification = new ArrayList<String>();
    }
    
    
    public String getGuestID() {
        return GuestID;
    }

    public void setGuestID(String GuestID) {
        this.GuestID = GuestID;
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
