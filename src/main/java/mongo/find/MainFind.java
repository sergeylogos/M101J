package mongo.find;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

import static mongo.document.Helper.printJson;

public class MainFind {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("course");
        MongoCollection<Document> coll = database.getCollection("findTest");
        coll.drop();
        for (int i = 0; i < 10; i++) {
            coll.insertOne(new Document("x", i));
        }

        Document first = coll.find().first();
        System.out.println(first);
        ArrayList<Document> into = coll.find().into(new ArrayList<>());
        System.out.println(into);

        MongoCursor<Document> cursor = coll.find().iterator();
        while (cursor.hasNext()) {
            Document next = cursor.next();
            printJson(next);
        }

        System.out.println(coll.count());
        

    }
}
