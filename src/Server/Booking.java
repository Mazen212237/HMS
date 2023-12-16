/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author gamer
 */
class Booking {
    String BookingID;
    private static ArrayList<Room> roomList;
    ArrayList<Room> cart;
    //date format is year,month,day
    String startDate;
    String endDate;

    
    Double totalPrice;


    //adds room to the cart
    public void selectRoom(Integer index){
        
        if("Available".equals(roomList.get(index).getStatusRoom()))
        {
            roomList.get(index).setStatusRoom("Free");
            cart.add(roomList.get(index));
        }
    }
    
    
    //function that Calculate the total from the selected Rooms and duration 
    public Double CalcTotal(ArrayList<Room> Cart, Integer duration) throws ParseException{
        for(Room i: Cart){
            totalPrice+=Duration(i,startDate,endDate);
        }
         return  totalPrice;
        
    }
    
    
    //calcs the length and cost of stay for selected room
    public Double Duration(Room room,String start, String end) throws ParseException{
        //comparing time
        LocalDate Start=LocalDate.parse(start);
        LocalDate End=LocalDate.parse(end);
        Integer Length= (Integer) Start.compareTo(End);
        // Calc price of selected Room
        Double Price;
        Price = (Double) (room.getPrice()*Length);
        
        return Price;
    }

     // Decorate the booking with a spa and add the cost to the total
    public void addSpa() {
        // Create a SpaDecorator instance and use it to decorate the booking
        BookingDecorator spaDecorator = new SpaDecorator();
        totalPrice = spaDecorator.decorateBooking(totalPrice);
    } 
    
}
