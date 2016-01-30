package com.kenwalger.mongoJava;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoJava {

    public static void main(String[] args) {
        try {
            // Connect to MongoDB Server on localhost, port 27017 (default)
            final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            // Connect to Database "cartoon"
            final MongoDatabase database = mongoClient.getDatabase("cartoon");
            System.out.println("Successful database connection established. \n");

        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
}