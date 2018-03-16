package homeworks.two.two;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import mongo.document.Helper;
import org.bson.Document;

import java.util.ArrayList;

public class MainHomeWork22 {
    public static void main(String[] args) {

        MongoCollection<Document> collection = new MongoClient().getDatabase("students").getCollection("grades");
        ArrayList<Document> into = collection
                .find(Filters.gte("score", 65))
//                .sort(Sorts.ascending("score"))
                .sort(new Document("score", 1))
                .into(new ArrayList<>());
        into.forEach(Helper::printJson);

    }
}
