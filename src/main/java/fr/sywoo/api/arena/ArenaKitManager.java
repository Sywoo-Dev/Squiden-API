package fr.sywoo.api.arena;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import fr.sywoo.api.mongodb.MongoDB;
import org.bson.conversions.Bson;

import java.util.UUID;

public class ArenaKitManager {

    private Gson gson;
    private MongoCollection<BasicDBObject> collection;

    public ArenaKitManager(MongoDB mongoDB) {
        this.gson = new Gson();
        this.collection = mongoDB.getMongoDatabase().getCollection("ArenaKit", BasicDBObject.class);
    }

    public void create(KitArenaData arenaData){
        BasicDBObject basicDBObject = new BasicDBObject("arenaKit.uuid", arenaData.getUUID().toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found == null) {
            collection.insertOne(new BasicDBObject("arenaKit", BasicDBObject.parse(gson.toJson(arenaData))));
        }
    }

    public KitArenaData get(UUID uuid){
        BasicDBObject basicDBObject = new BasicDBObject("arenaKit.uuid", uuid.toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("arenaKit"), KitArenaData.class);
        }
        return null;
    }

    public void update(KitArenaData arenaData){
        BasicDBObject document = new BasicDBObject("arenaKit.uuid", arenaData.getUUID().toString());
        BasicDBObject found =  collection.find(document).first();
        if (found != null){
            Bson update = new BasicDBObject("arenaKit", BasicDBObject.parse(gson.toJson(arenaData)));
            collection.updateOne(found, new BasicDBObject("$set", update));
        }
    }
}

