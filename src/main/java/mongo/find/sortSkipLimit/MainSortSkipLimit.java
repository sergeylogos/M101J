package mongo.find.sortSkipLimit;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import mongo.document.Helper;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

import static com.mongodb.client.model.Sorts.descending;

public class MainSortSkipLimit {
    public static void main(String[] args) {
        MongoDatabase database = new MongoClient().getDatabase("course");
        MongoCollection<Document> coll = database.getCollection("findWithSortLimit");
        coll.drop();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                coll.insertOne(new Document("i", i).append("j", j));
            }
        }


        Bson projection = Projections.fields(Projections.include("i", "j"), Projections.excludeId());
//        Bson sort = new Document("i", -1).append("j",-1);
//        Bson sort = Sorts.ascending("i");
//        Bson sort = orderBy(ascending("i"), descending("j"));
        Bson sort = descending("j", "i");
        coll
                .find()
                .projection(projection)
                .sort(sort)
                .skip(10)
                .limit(10)
                .into(new ArrayList<>())
                .forEach(Helper::printJson);


    }/**/
}/**/
