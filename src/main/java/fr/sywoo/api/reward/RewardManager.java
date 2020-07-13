package fr.sywoo.api.reward;

import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import fr.sywoo.api.mongodb.MongoDB;

public class RewardManager {

    private Gson gson;
    private MongoCollection<BasicDBObject> collection;

    public RewardManager(MongoDB mongoDB) {
        this.gson = new Gson();
        this.collection = mongoDB.getMongoDatabase().getCollection("Rewards", BasicDBObject.class);
    }

    public void create(Reward reward){
        BasicDBObject basicDBObject = new BasicDBObject("rewards.rewardName", reward.getRewardName());
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found == null) {
            collection.insertOne(new BasicDBObject("rewards", BasicDBObject.parse(gson.toJson(reward))));
        }
    }

    public Reward get(String name){
        BasicDBObject basicDBObject = new BasicDBObject("rewards.rewardName", name);
        BasicDBObject found = collection.find(basicDBObject).first();
        if (found != null) {
            return gson.fromJson(found.getString("rewards"), Reward.class);
        }
        return null;
    }

    public void update(Reward reward){
        BasicDBObject document = new BasicDBObject("rewards.rewardName", reward.getRewardName());
        BasicDBObject found =  collection.find(document).first();
        if (found != null){
            Bson update = new BasicDBObject("rewards", BasicDBObject.parse(gson.toJson(reward)));
            collection.updateOne(found, new BasicDBObject("$set", update));
        }
    }

}
