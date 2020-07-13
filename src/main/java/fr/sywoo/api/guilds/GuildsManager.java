package fr.sywoo.api.guilds;

import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import fr.sywoo.api.mongodb.MongoDB;

public class GuildsManager {
	
    private Gson gson;
    private MongoCollection<BasicDBObject> collection;

    public GuildsManager(MongoDB mongoDB) {
        this.gson = new Gson();
        this.collection = mongoDB.getMongoDatabase().getCollection("Guilds", BasicDBObject.class);
    }

    public void create(Guilds guilds){
        BasicDBObject basicDBObject = new BasicDBObject("guilds.name", guilds.getName());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found == null) {
            collection.insertOne(new BasicDBObject("guilds", BasicDBObject.parse(gson.toJson(guilds))));
        }
    }

    public Guilds get(String name){
        BasicDBObject basicDBObject = new BasicDBObject("guilds.name", name);
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("guilds"), Guilds.class);
        }
        return null;
    }

    public void update(Guilds guilds){
        BasicDBObject document = new BasicDBObject("guilds.name", guilds.getName());
        BasicDBObject found =  collection.find(document).first();
        if (found != null){
            Bson update = new BasicDBObject("guilds", BasicDBObject.parse(gson.toJson(guilds)));
            collection.updateOne(found, new BasicDBObject("$set", update));
        }
    }
    
    public void delete(Guilds guilds){
        BasicDBObject document = new BasicDBObject("guilds.name", guilds.getName());
        BasicDBObject found = collection.find(document).first();
        if(found != null){
            collection.deleteOne(found);
        }
    }
}
