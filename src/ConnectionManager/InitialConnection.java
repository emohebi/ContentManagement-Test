/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionManager;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class InitialConnection {
    
    public static MongoDatabase connector() {
            MongoClientURI connectionString = new MongoClientURI("mongodb://ehsan:d11475290@aws-us-east-1-portal.13.dblayer.com:10372/admin");
            MongoClient mongoClient = new MongoClient(connectionString);
            MongoDatabase database = mongoClient.getDatabase("iSantia");
            return database;
    }
    
}
