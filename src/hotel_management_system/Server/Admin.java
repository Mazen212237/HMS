/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author gamer
 */
public class Admin extends User{
    private static Admin ad;
    private Admin(){
        super();
    }
    
    public static Admin getInstance(){
        if(ad==null){
            ad=new Admin();
        }
        return ad;
    }
    
}
