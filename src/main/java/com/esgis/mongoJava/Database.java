package com.esgis.mongoJava;

import com.esgis.mongoJava.model.Categorie;
import com.esgis.mongoJava.model.Product;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class Database {
    private MongoClient mongo;
    private DBCollection table;
    private MongoCollection<Document> collection;
    private MongoDatabase database;
    public Database(Object Product){
            try {
                mongo = new MongoClient("localhost",27017);
                database = mongo.getDatabase("commerce");
            } catch (Exception e){
                e.printStackTrace();
            }
        }


    public void InsertProduct(List<Product> ProductList) {
        for (int i = 0; i < ProductList.size(); i++) {
            BasicDBObject document = new BasicDBObject();
            document.put("Nom du produit", ProductList.get(i).getName());
            document.put("Prix", ProductList.get(i).getPrice());
            document.put("Quanité", ProductList.get(i).getQuantity());
            table.insert(document);
        }
    }

    public void InsertCategorie(List<Categorie> CategorieList) {
        for (int i = 0; i < CategorieList.size(); i++) {
            BasicDBObject document = new BasicDBObject();
            document.put("Nom Catégorie", CategorieList.get(i).getLibelle());
            table.insert(document);
        }
    }
}
