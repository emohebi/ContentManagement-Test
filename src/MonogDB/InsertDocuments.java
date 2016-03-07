/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonogDB;

import ConnectionManager.InitialConnection;
import ContentDataContract.CrawlData;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Ehsan
 */
public class InsertDocuments {
    
    private ArrayList<CrawlData> listOfData = new ArrayList<>(); 
    MongoDatabase db;      
    MongoCollection<Document> collection;
    
    public InsertDocuments() {
        db = InitialConnection.connector(); 
        collection = db.getCollection("webkeyscollection");
    }
  
    public InsertDocuments(ArrayList<CrawlData> listOfData) {
        db = InitialConnection.connector(); 
        collection = db.getCollection("webkeyscollection");
        this.listOfData = listOfData;
    }
    
    public void Add(CrawlData data){
        Document doc = new Document("author", data.getAuthor())
               .append("url", data.getUrl())
               .append("headline", data.getHeadline())
               .append("text", data.getText());
                collection.insertOne(doc);
    }

    public ArrayList<CrawlData> getListOfData() {
        return listOfData;
    }

    public void setListOfData(ArrayList<CrawlData> listOfData) {
        this.listOfData = listOfData;
    }
    
    
}
