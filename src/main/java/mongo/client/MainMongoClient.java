package mongo.client;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

public class MainMongoClient {
    public static void main(String[] args) {
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(100).build();
//    MongoClient client = new MongoClient(new MongoClientURI("localhost://testbase"));
//    MongoClient client = new MongoClient(new ServerAddress("localhost",27017));
        MongoClient client = new MongoClient(new ServerAddress(), options);
        MongoDatabase database = client.getDatabase("testDB").withReadPreference(ReadPreference.secondary());
        MongoCollection<Bson> collection = database.getCollection("collection", Bson.class);
    }
}
