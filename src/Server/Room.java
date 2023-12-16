/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.lang.Integer;
import java.lang.String;
/**
 *
 * @author gamer
 */
class Room {
    String roomID;
    String statusRoom;
    String type;
    int floor;
    int noOfBeds;
    String Description;
    double Price;

    public Room(String roomID, String statusRoom, String type, Integer floor, Integer noOfBeds, String Description, Double Price) {
        this.roomID = roomID;
        this.statusRoom = statusRoom;
        this.type = type;
        this.floor = floor;
        this.noOfBeds = noOfBeds;
        this.Description = Description;
        this.Price = Price;
    }
    public Room() {
        this.roomID = "";
        this.statusRoom = "";
        this.type = "";
        this.floor =  0;
        this.noOfBeds =  0;
        this.Description = "";
        this.Price = 0.0;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(String statusRoom) {
        this.statusRoom = statusRoom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }
    
    
    
    
}
