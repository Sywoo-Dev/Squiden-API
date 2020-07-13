package fr.sywoo.api.uhcconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import fr.sywoo.api.mongodb.MongoDB;

public class ConfigManager {

    private Gson gson;
    private MongoCollection<BasicDBObject> collection;

    public ConfigManager(MongoDB mongoDB) {
        this.gson = new Gson();
        this.collection = mongoDB.getMongoDatabase().getCollection("Configs", BasicDBObject.class);
    }

    public void create(ConfigData configData){
        BasicDBObject basicDBObject = new BasicDBObject("configData.uuid", configData.getUUID().toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found == null) {
            collection.insertOne(new BasicDBObject("configData", BasicDBObject.parse(gson.toJson(configData))));
        }
    }

    public ConfigData get(UUID uuid){
        BasicDBObject basicDBObject = new BasicDBObject("configData.uuid", uuid.toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("configData"), ConfigData.class);
        }
        return null;
    }

    public void update(ConfigData configData){
        BasicDBObject document = new BasicDBObject("configData.uuid", configData.getUUID().toString());
        BasicDBObject found =  collection.find(document).first();
        if (found != null){
            Bson update = new BasicDBObject("configData", BasicDBObject.parse(gson.toJson(configData)));
            collection.updateOne(found, new BasicDBObject("$set", update));
        }
    }

    public List<ConfigData> getAllPlayers(){
        List<ConfigData> players = new ArrayList<>();
        FindIterable<BasicDBObject> cursor = collection.find();
        for(BasicDBObject object : cursor){
            ConfigData configData = gson.fromJson(object.getString("configData"), ConfigData.class);
            players.add(configData);
        }
        return players;
    }


}

