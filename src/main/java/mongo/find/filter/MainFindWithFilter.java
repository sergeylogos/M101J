package mongo.find.filter;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mongo.document.Helper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Random;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

public class MainFindWithFilter {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase course = client.getDatabase("");
        MongoCollection<Document> collection = course.getCollection("findWithFilterTest");
        collection.drop();
        for (int i = 0; i < 10; i++) {
            collection.insertOne(
                    new Document("x", new Random().nextInt(2))
                            .append("y", new Random().nextInt(100))
                            .append("i", i)
            );

        }

//        Bson simpleFilter = new Document("x", 1);
//        ArrayList<Document> into = collection.find(simpleFilter).into(new ArrayList<Document>());
//        into.forEach(Helper::printJson);

//        Bson compositeFilter = new Document("x", 1).append("y",3);
//        ArrayList<Document> into = collection.find(compositeFilter).into(new ArrayList<Document>());
//        into.forEach(Helper::printJson);

//        Bson gtFilter = new Document("x", 1).append("y",new Document("$gt" , 3));
//        ArrayList<Document> into = collection.find(gtFilter).into(new ArrayList<Document>());
//        into.forEach(Helper::printJson);


//        Bson gtAndLtFilter = new Document("x", 1)
//                .append("y", new Document("$gt", 3).append("$lt", 7)
//                );
//        ArrayList<Document> into = collection.find(gtAndLtFilter).into(new ArrayList<Document>());
//        into.forEach(Helper::printJson);


//        Bson filterByFiltersEq = Filters.eq("x", 2);
//        ArrayList<Document> documents = collection.find(filterByFiltersEq).into(new ArrayList<Document>());
//        documents.forEach(Helper::printJson);

//        Bson filterGtAndLt = and(gt("x", 2), lt("y", 5));
//        ArrayList<Document> list = collection.find(filterGtAndLt).into(new ArrayList<>());
//        list.forEach(Helper::printJson);


//        Bson filter = and(eq("x", 0), gt("y", 10), lt("y", 90));
//        Bson exclude = new Document("_id", 0).append("y",0);
//        Bson exclude = Projections.exclude("_id");
//        ArrayList<Document> into =
//                collection
//                        .find(filter)
//                        .projection(exclude)
//                        .into(new ArrayList<>());
//        into.forEach(Helper::printJson);


        ArrayList<Document> into = collection.find(
                and(
                        eq("x", 1),
                        gt("y", 10),
                        lt("y", 90)
                )
        )
                .projection(
                        fields(
                                include("x"),
                                exclude("_id")
                        )
                )
                .into(new ArrayList<>());

        into.forEach(Helper::printJson);

    }//
}/**/
