/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;



import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class DB {
   private MongoDatabase database;
    ConnectionString connectionURI =new ConnectionString("mongodb+srv://HMS:HMS@cluster0.4ootvqe.mongodb.net/?retryWrites=true&w=majority");
    MongoClient mongoClient = MongoClients.create(connectionURI);
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();
    
    public DB() {
      Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
       mongoLogger.setLevel(Level.SEVERE);
        database = mongoClient.getDatabase("HMS");
    }
    //Add Doc
    public void addDoc(Document input, String Collection){
        this.collection=database.getCollection(Collection);
        this.collection.insertOne(input);
        System.out.println("Inserted Doc");
    }
    //Lookup OneDoc
    public Document SearchOneDoc(Document input, String collection){
        this.collection=database.getCollection(collection);
        Document result= this.collection.find().first();
        System.out.println("Found One Document");
        return result;
    }
    
    //Lookup MultipleDoc
    public ArrayList<Document> SearchMultipleDoc(Document input, String collection){
        this.collection=database.getCollection(collection);
        MongoCursor<Document> cursor= this.collection.find().iterator();
        
        ArrayList<Document> temp= new ArrayList<Document>();
        try {
            while (cursor.hasNext()) {
                temp.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        
        return temp;
    }
    
    public void InsertGuest(Guest g){
       Document temp = Document.parse(gson.toJson(g));
       addDoc(temp,"Guest");
        System.out.println("Added Guest");
    }
    
    
    
//        public void close() {
//        client.close();
//    }
    
}
