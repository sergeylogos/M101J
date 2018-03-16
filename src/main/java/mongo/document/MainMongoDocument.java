package mongo.document;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

import static mongo.document.Helper.printJson;

public class MainMongoDocument {
    public static void main(String[] args) {
        Document document = new Document("name", "serj");
        document.append("age", 30)
                .append("wife" , new Document("name" , "helen"));

        printJson(document);
        BsonDocument bsonDocument = new BsonDocument("key", new BsonString("uuuytuy"));

    }
}
