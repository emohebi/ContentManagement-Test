/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonogDB;

import ConnectionManager.InitialConnection;
import ContentDataContract.CrawlData;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.bson.Document;


/**
 *
 * @author Ehsan
 */
public class SearchDocuments {
    
    
    MongoDatabase db;      
    MongoCollection<Document> collection;
    ArrayList<CrawlData> listOfData;
    
    public SearchDocuments() {
        db = InitialConnection.connector(); 
        collection = db.getCollection("webkeyscollection");
    }
    
    public void Search(String regex){
        listOfData = new ArrayList<>();
        collection.find(new BasicDBObject());
        Pattern j = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        BasicDBObject query = new BasicDBObject("text", j);
        FindIterable<Document> result = collection.find(query);
        try (MongoCursor<Document> cursor = result.iterator()) {
               while(cursor.hasNext()) {
                   Document doc = cursor.next();
                   CrawlData data = new CrawlData();
                   data.setId(doc.get("_id").toString());
                   data.setAuthor(doc.getString("author"));
                   data.setHeadline(doc.getString("headline"));
                   data.setUrl(doc.getString("url"));
                   data.setText(doc.getString("text"));
                   listOfData.add(data);
               }
            }
    }

    public ArrayList<CrawlData> getListOfData() {
        return listOfData;
    }

    public void setListOfData(ArrayList<CrawlData> listOfData) {
        this.listOfData = listOfData;
    }
    
    
}
