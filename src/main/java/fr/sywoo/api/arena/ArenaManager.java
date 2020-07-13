package fr.sywoo.api.arena;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import fr.sywoo.api.mongodb.MongoDB;
import org.bson.conversions.Bson;

import java.util.UUID;

public class ArenaManager {

    private Gson gson;
    private MongoCollection<BasicDBObject> collection;

    public ArenaManager(MongoDB mongoDB) {
        this.gson = new Gson();
        this.collection = mongoDB.getMongoDatabase().getCollection("Arena", BasicDBObject.class);
    }

    public void create(ArenaData arenaData){
        BasicDBObject basicDBObject = new BasicDBObject("arenaData.uuid", arenaData.getUUID().toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found == null) {
            collection.insertOne(new BasicDBObject("arenaData", BasicDBObject.parse(gson.toJson(arenaData))));
        }
    }

    public ArenaData get(UUID uuid){
        BasicDBObject basicDBObject = new BasicDBObject("arenaData.uuid", uuid.toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("arenaData"), ArenaData.class);
        }
        return null;
    }

    public void update(ArenaData arenaData){
        BasicDBObject document = new BasicDBObject("arenaData.uuid", arenaData.getUUID().toString());
        BasicDBObject found =  collection.find(document).first();
        if (found != null){
            Bson update = new BasicDBObject("arenaData", BasicDBObject.parse(gson.toJson(arenaData)));
            collection.updateOne(found, new BasicDBObject("$set", update));
        }
    }
}

