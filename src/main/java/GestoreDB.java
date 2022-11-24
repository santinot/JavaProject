package src.main.java;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;

//Classe per inviare le misurazioni al database
public class GestoreDB {
    private final MongoClient client ;
    private final MongoDatabase database ;

    public GestoreDB(String username, String password, String url, String name) {
            this.client = new MongoClient(new MongoClientURI("mongodb://" + username + ":" + password + "@" +url+ "/admin"));
            this.database= client.getDatabase(name);
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void inserimento(JSONObject jsonObject){
        switch ((int) jsonObject.get("ID") / 100) {
            case 1 -> database.getCollection("Temperatura").insertOne(Document.parse(jsonObject.toJSONString()));
            case 2 -> database.getCollection("Aria").insertOne(Document.parse(jsonObject.toJSONString()));
            case 3 -> database.getCollection("Acqua").insertOne(Document.parse(jsonObject.toJSONString()));
            default -> database.getCollection("Errore").insertOne(Document.parse(jsonObject.toJSONString()));
        }
    }
}
