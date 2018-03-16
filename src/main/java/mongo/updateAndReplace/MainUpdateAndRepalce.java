package mongo.updateAndReplace;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import mongo.document.Helper;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.gte;

public class MainUpdateAndRepalce {
    public static void main(String[] args) {

        MongoCollection<Document> coll = new MongoClient()
                .getDatabase("course")
                .getCollection("updateAndReplace");

        coll.drop();

        for (int i = 0; i < 8; i++) {
            Document document = new Document("_id", i)
                    .append("x", i)
                    .append("y", true);

            coll.insertOne(document);
        }

//        coll.replaceOne(eq("x", 5), new Document("x", 20).append("updated", true));
//        coll.updateOne(eq("x", 5), new Document("$set", new Document("x", 20).append("updated", true)));

//        coll.updateOne(eq("x", 5), Updates.set("x", 20));
//        coll.updateOne(eq("x", 5), combine(set("x", 20),set("y", false),set("updated", true)));
//        coll.updateOne(eq("_id", 9), combine(set("x", 20),set("y", false),set("updated", true)),
//                new UpdateOptions().upsert(true));

        coll.updateMany(gte("_id", 5), Updates.inc("x",5));

        coll
                .find()
                .into(new ArrayList<>())
                .forEach(Helper::printJson);


    }/**/
}/**/
