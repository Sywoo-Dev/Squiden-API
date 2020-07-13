package fr.sywoo.api.account;

import com.mongodb.client.FindIterable;
import fr.sywoo.api.mongodb.MongoDB;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;

import java.util.*;

public class AccountManager {

    private Gson gson;
    private MongoCollection<BasicDBObject> collection;

    public AccountManager(MongoDB mongoDB) {
        this.gson = new Gson();
        this.collection = mongoDB.getMongoDatabase().getCollection("Account", BasicDBObject.class);
    }

    public void create(AccountData accountData){
        BasicDBObject basicDBObject = new BasicDBObject("accountData.uuid", accountData.getUUID().toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found == null) {
            collection.insertOne(new BasicDBObject("accountData", BasicDBObject.parse(gson.toJson(accountData))));
        }
    }

    public AccountData get(UUID uuid){
        BasicDBObject basicDBObject = new BasicDBObject("accountData.uuid", uuid.toString());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("accountData"), AccountData.class);
        }
        return null;
    }

    public AccountData get(String name){
        BasicDBObject basicDBObject = new BasicDBObject("accountData.name", name.toLowerCase());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("accountData"), AccountData.class);
        }
        return null;
    }

    public void update(AccountData accountData){
        BasicDBObject document = new BasicDBObject("accountData.uuid", accountData.getUUID().toString());
        BasicDBObject found =  collection.find(document).first();
        if (found != null){
            Bson update = new BasicDBObject("accountData", BasicDBObject.parse(gson.toJson(accountData)));
            collection.updateOne(found, new BasicDBObject("$set", update));
        }
    }

    public HashMap<String, Integer> getJumpers(){
        HashMap<String, Integer> jumpers = new HashMap<>();
        FindIterable<BasicDBObject> cursor = collection.find();
        for(BasicDBObject object : cursor){
            AccountData accountData = gson.fromJson(object.getString("accountData"), AccountData.class);
            if(accountData.getJump() == null) continue;
            jumpers.put(accountData.getName(), accountData.getJump().getSec());
        }
        return jumpers;
    }

    public List<AccountData> getAllPlayers(){
        List<AccountData> players = new ArrayList<>();
        FindIterable<BasicDBObject> cursor = collection.find();
        for(BasicDBObject object : cursor){
            AccountData accountData = gson.fromJson(object.getString("accountData"), AccountData.class);
            players.add(accountData);
        }
        return players;
    }


}

