package com.qamer91.Utilities;

/*
Author: Ahmed Amer
 */

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBUtils {

    MongoClient mongo ;

    public MongoDBUtils(String dbUrl , int portNumber) throws MongoSocketException {

        //Creating object of type ServerAddress to hold DB Url & Port Number
        ServerAddress serverAddress = new ServerAddress(dbUrl, portNumber);

        //DB Credentials (Won't need it if you're running in developer trusted environment
        MongoCredential credentials = MongoCredential.createCredential("mongoadmin", "admin",
                "adminpassword".toCharArray());

        //Connection options
        MongoClientOptions options = MongoClientOptions.builder().serverSelectionTimeout(10000).build();

        try {
            mongo = new MongoClient(serverAddress, credentials, options);
        }
        //TODO : Fix catching exception since it's not working
        catch (MongoSocketException socketException){
            System.out.println("Couldn't connect to MongoDB");
        }

        }


    public Document checkVisitIsUpdated (String visitId) throws Exception{

        MongoDatabase database = mongo.getDatabase("admin");
        MongoCollection<Document> mongoCollection = database.getCollection("visits");
        Document visitDetailsDoc;

        try {
            visitDetailsDoc = mongoCollection.find(eq("_id", new ObjectId(visitId))).first();
            return visitDetailsDoc;
        }
        catch (Exception e){

            System.out.println("Visit Doc is not Found");
            return null ;
        }
    }

    public String createNewVisit(){

        ObjectId visitID = new ObjectId();
        Document visitDocument = new Document("_id", visitID);
        visitDocument.append("licenseId" , "LcdeWTdXPlQgjMVXbpRYzBT");
        visitDocument.append("siteName" , "Rest Assured Site Name");
        visitDocument.append("licenseIssueDate" , "14410405");

        //MongoDb structure is Database contains collections, collections contains documents,
        // documents are the actual data, equivalent to an entry in SQL databases
        mongo.getDatabase("admin").getCollection("visits").insertOne(visitDocument);
        return visitID.toString();

    }

    public void deleteVisit (String visitDocumentIdToBeDeleted) {
        mongo.getDatabase("admin").getCollection("visits").
                deleteOne(Filters.eq("_id", new ObjectId(visitDocumentIdToBeDeleted)));

    }

    public void closeDBConnection(){
        mongo.close();
    }
}

