/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;



import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class DB {
   private MongoDatabase database;
    ConnectionString connectionURI =new ConnectionString("mongodb+srv://HMS:HMS@cluster0.4ootvqe.mongodb.net/?retryWrites=true");
    MongoClient mongoClient = MongoClients.create(connectionURI);
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();
    
    public DB() {
      Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        mongoLogger.setLevel(Level.WARNING);
        database = mongoClient.getDatabase("HMS");
    }
    //Add Doc
    public void addDoc(Document input, String Collection){
        this.collection=database.getCollection(Collection);
        this.collection.insertOne(input);
        System.out.println("Inserted Doc");
    }
    //Lookup OneDoc
    public Document SearchOneDoc(String input,String field, String collection){
        this.collection=database.getCollection(collection);
        Document result= this.collection.find(Filters.eq(field,input)).first();
        System.out.println("Found One Document");
        return result;
    }

    //Login as Guest
    public String LoginGuest(String username, String password){
        String result;
        Document temp=SearchOneDoc(username,"userName","Guest");
        if(temp==null){
            result="Username doesn't Exist";
            System.out.println(result);
            return null;
        }
        else {
            Guest g= gson.fromJson(temp.toJson(), Guest.class);
            if (Objects.equals(g.getPassword(), password)){
                result="Welcome "+g.getName();
                System.out.println(result);
                return result;
            }
            else {
                result="Wrong Password";
                System.out.println(result);
                return result;
            }
        }
    }
    //Login as Receptionist
    public String LoginReceptionist(String username, String password){
        String result;
        Document temp=SearchOneDoc(username,"userName","Receptionist");
        if(temp==null){
            result="Username doesn't Exist";
            System.out.println(result);
            return null;
        }
        else {
            Receptionist r= gson.fromJson(temp.toJson(), Receptionist.class);
            if (Objects.equals(r.getPassword(), password)){
                result="Welcome "+r.getName();
                System.out.println(result);
                return result;
            }
            else {
                result="Wrong Password";
                System.out.println(result);
                return result;
            }
        }
    }

    public String LoginAdmin(String username, String password){
        String result;
        Document temp=SearchOneDoc(username,"userName","Admin");
        if(temp==null){
            result="Username doesn't Exist";
            System.out.println(result);
            return null;
        }
        else {
            Admin a= gson.fromJson(temp.toJson(), Admin.class);
            if (Objects.equals(a.getPassword(), password)){
                result="Welcome "+a.getName();
                System.out.println(result);
                return result;
            }
            else {
                result="Wrong Password";
                System.out.println(result);
                return result;
            }
        }
    }
    
    public void insertBooking(Booking booking) {
        Document bookingDoc = Document.parse(gson.toJson(booking));
        addDoc(bookingDoc, "Booking");
        System.out.println("Added Booking");
    }

    // Retrieve all bookings from the "Booking" collection
    public ArrayList<Booking> getAllBookings() {
        MongoCollection<Document> collection = database.getCollection("Booking");
        FindIterable<Document> documents = collection.find();

        ArrayList<Booking> bookings = new ArrayList<>();
        for (Document document : documents) {
            Booking booking = gson.fromJson(document.toJson(), Booking.class);
            bookings.add(booking);
        }

        return bookings;
    }

    // Retrieve bookings for a specific user from the "Booking" collection
    public ArrayList<Booking> getBookingsForUser(String userId) {
        MongoCollection<Document> collection = database.getCollection("Booking");
        FindIterable<Document> documents = collection.find(Filters.eq("userId", userId));

        ArrayList<Booking> bookings = new ArrayList<>();
        for (Document document : documents) {
            Booking booking = gson.fromJson(document.toJson(), Booking.class);
            bookings.add(booking);
        }

        return bookings;
    }

    //Lookup MultipleDoc
    public ArrayList<Document> SearchMultipleDoc(String input,String field, String collection){
        this.collection=database.getCollection(collection);

        //Retrieves Documents and assigns it to Cursor
        MongoCursor<Document> cursor= this.collection.find(Filters.eq(field,input)).iterator();
        
        ArrayList<Document> temp= new ArrayList<Document>();
        //Will move from cursor to an ArrayList
        try {
            while (cursor.hasNext()) {temp.add(cursor.next());}
        } finally {cursor.close();}

        System.out.println("Successfully Found Multiple Documents");
        return temp;
    }
    
    
    public void InsertGuest(String name, String userName, String password, String email, String phoneNumber, String DOB, String Address){
        Guest g=new Guest(name,userName,password,email,phoneNumber,DOB,Address);
        Document temp = Document.parse(gson.toJson(g));
        addDoc(temp,"Guest");
        System.out.println("Added Guest");
    }
    
    
    
        public void close() {
        mongoClient.close();
    }
    
}
