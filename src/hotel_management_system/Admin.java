/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management_system;

/**
 *
 * @author gamer
 */
public class Admin {
    private static Admin ad;
    private Admin(){
    }
    public static Admin getInstance(){
        if(ad==null){
            ad=new Admin();
        }
        return ad;
    }
    
}
