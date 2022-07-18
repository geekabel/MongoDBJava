package com.esgis.mongoJava;

import com.esgis.mongoJava.model.Product;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoJava {

    public static void main(String[] args) {
        try {
            // Connexion a  MongoDB Server on localhost, port 27017 (default) michmicha
            final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            // Connexion a la bdd
            final MongoDatabase database = mongoClient.getDatabase("commerce");
            System.out.println("Connexion a la base donnée etablie \n");

            //Inserer un document dans la bdd "commerce"
           MongoCollection<Document> collection = database.getCollection("produits");

            // supprimer une collection et recommencer
            collection.drop();




        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
}