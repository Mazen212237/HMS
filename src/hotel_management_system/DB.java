/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management_system;


import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class DB {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();
    
    
    public DB(String Col) {
      Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("HMS"); // Database name
        collection = database.getCollection(Col); // Collection name
        
    }
  //Guest Func List
    //Create
    public void insertGuest(Guest g) {
        collection.insertOne(Document.parse(gson.toJson(g)));
        System.out.println("Guest inserted.");
    }
    
   //Retrieve
        public ArrayList<Guest> getStaffbyFilter(String field, String value) {
        ArrayList<Guest> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq(field, value)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Guest.class));
        }
        return result;
    }
        
    //Update
    public void updateGuestInfo(Guest g) {
        Document doc = Document.parse(gson.toJson(g));
        collection.replaceOne(Filters.eq("name", g.getName()), doc);
        collection.replaceOne(Filters.eq("password", g.getPassword()), doc);
        collection.replaceOne(Filters.eq("address", g.getAddress()), doc);
        collection.replaceOne(Filters.eq("email", g.getEmail()), doc);
        collection.replaceOne(Filters.eq("username", g.getUserName()), doc);
        collection.replaceOne(Filters.eq("DOB", g.getDOB()), doc);
        collection.replaceOne(Filters.eq("phonenumber", g.getPhoneNumber()), doc);
        System.out.println(g.getName()+" has succesfully updated their account");
    }
    
    public void updateStaffEmail( String name,String newEmail) {   
        collection.updateOne(Filters.eq("name",name), Updates.set("email",newEmail));
    }
       
    public void deleteStaff(String name) {
        collection.deleteOne(Filters.eq("name", name));
    }

    
    


        public void close() {
        client.close();
    }
    
}
