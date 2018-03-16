package mongo.delete;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import mongo.document.Helper;
import org.bson.Document;

import java.util.ArrayList;

public class MainDelete {
    public static void main(String[] args) {
        MongoCollection<Document> coll = new MongoClient().getDatabase("course").getCollection("testDelete");
        coll.drop();

        for (int i = 0; i < 8; i++) {
            coll.insertOne(new Document("_id", i));
        }
//        coll.deleteOne(eq("_id", 5));
//        coll.deleteMany(gte("_id", 5));


                coll
                .find()
                .into(new ArrayList<>())
                .forEach(Helper::printJson);


    }/**/
}/**/
