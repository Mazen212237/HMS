/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.util.ArrayList;
import java.util.UUID;
import org.bson.types.ObjectId;

/**
 *
 * @author gamer
 */
public class Guest extends User implements Observer{
    private ObjectId _id;
    private ArrayList<User> Visitor;
    private ArrayList<String> notification;

    public Guest(String name, String userName, String password, String email, String phoneNumber, String DOB, String Address) {
        super(name, userName, password, email, phoneNumber, DOB, Address);
        this.Visitor=new ArrayList<User>();
        this.notification=new ArrayList<String>();
        

        System.out.println("Created Guest Object");
    }

    public Guest() {
        super();
        this.Visitor=new ArrayList<User>();
        this.notification=new ArrayList<String>();

        System.out.println("Created Guest Object");
    }
    


   
    
    


    public ArrayList<String> getNotification() {
        return notification;
    }

    //add notification
    public void setNotification(String notification) {
        this.notification.add(notification);
    }

    
    //return bool if managed to remove or not
    public boolean removeNotification(Integer index){
        return this.notification.remove(index);
    }


    public ObjectId get_id() {
        return _id;
    }

    public ArrayList<User> getVisitor() {
        return Visitor;
    }

    public void setVisitor(User Visitor) {
        this.Visitor.add(Visitor);
    }
    
    public boolean removeVisitor(Integer index){
        boolean remove = this.Visitor.remove(index);
        return remove;
    }
    

    public void update(String notification) {
       
        System.out.println("Guest " + _id + " received update: " + notification);
    }
    
    
}
