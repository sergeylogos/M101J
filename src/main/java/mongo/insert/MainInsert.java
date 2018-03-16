package mongo.insert;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class MainInsert {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("course");
        MongoCollection<Document> collection = database.getCollection("insetrTest");
        collection.drop();

//        collection.insertOne(new Document("name" ,"vasya"));
        List<Document> documents = Arrays.asList(new Document("name", "petya").append("age", 30), new Document("name", "koko").append("age", 31), new Document("name", "lesha").append("age", 20));
        collection.insertMany(documents);


    }
}
