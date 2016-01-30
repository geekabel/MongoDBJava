package com.kenwalger.mongoJava;

import com.mongodb.ErrorCategory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoJava {

    public static void main(String[] args) {
        try {
            // Connect to MongoDB Server on localhost, port 27017 (default)
            final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            // Connect to Database "cartoon"
            final MongoDatabase database = mongoClient.getDatabase("cartoon");
            System.out.println("Successful database connection established. \n");

            //Insert a document into the "characters" collection.
            MongoCollection<Document> collection = database.getCollection("characters");

            Document mickeyMouse = new Document();
            Document charlieBrown = new Document();

            mickeyMouse.append("_id", 1)
                    .append("characterName", "Mickey Mouse")
                    .append("creator", new Document("firstName", "Walt").append("lastName", "Disney"))
                    .append("pet", "Goofy");

            charlieBrown.append("_id", 2)
                    .append("characterName", "Charlie Brown")
                    .append("creator", new Document("firstName", "Charles").append("lastName", "Shultz"))
                    .append("pet", "Snoopy");

            try {
                collection.insertOne(mickeyMouse);
                collection.insertOne(charlieBrown);
                System.out.println("Successfully inserted documents. \n");
            } catch (MongoWriteException mwe) {
                if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                    System.out.println("Document with that id already exists");
                }
            }

        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
}