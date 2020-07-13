package fr.sywoo.api.serverdata;

import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import fr.sywoo.api.mongodb.MongoDB;

public class ServerDataManager {

    private Gson gson;
    private MongoCollection<BasicDBObject> collection;

    public ServerDataManager(MongoDB mongoDB) {
        this.gson = new Gson();
        this.collection = mongoDB.getMongoDatabase().getCollection("Servers", BasicDBObject.class);
    }

    public void create(ServersData serversData){
        BasicDBObject basicDBObject = new BasicDBObject("serverData.name", serversData.getName());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found == null) {
            collection.insertOne(new BasicDBObject("serverData", BasicDBObject.parse(gson.toJson(serversData))));
        }
    }

    public ServersData get(String name){
        BasicDBObject basicDBObject = new BasicDBObject("serverData.name", name);
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("serverData"), ServersData.class);
        }
        return null;
    }

    public void update(ServersData serversData){
        BasicDBObject document = new BasicDBObject("serverData.name", serversData.getName());
        BasicDBObject found =  collection.find(document).first();
        if (found != null){
            Bson update = new BasicDBObject("serverData", BasicDBObject.parse(gson.toJson(serversData)));
            collection.updateOne(found, new BasicDBObject("$set", update));
        }
    }

    public void delete(ServersData serverData){
        BasicDBObject document = new BasicDBObject("serverData.name", serverData.getName());
        BasicDBObject found =  collection.find(document).first();
        if(found != null){
            collection.deleteOne(found);
        }
    }
    
    public void clear() {
    	BasicDBObject document = new BasicDBObject();
    	collection.deleteMany(document);
    }

}
