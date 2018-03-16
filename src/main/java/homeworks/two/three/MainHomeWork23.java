package homeworks.two.three;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;

import static com.mongodb.client.model.Projections.exclude;
import static java.util.Comparator.comparingDouble;

public class MainHomeWork23 {
    public static void main(String[] args) {
        MongoCollection<Document> collection = new MongoClient()
                .getDatabase("students")
                .getCollection("grades");

        ArrayList<Document> tempColl = new ArrayList<>();


        ArrayList<Document> into = collection
                .find(Filters.eq("type", "homework"))
                .projection(exclude("_id"))
                .sort(new Document("student_id", 1))
                .into(new ArrayList<>());


        int controlID = 0;
        int maxID = into
                .stream()
                .max((o1, o2) -> o1.getInteger("student_id") - o2.getInteger("student_id"))
                .get().getInteger("student_id");


        ArrayList<Document> forRemove = new ArrayList<>();
        while (controlID <= maxID) {
            ArrayList<Document> documents = new ArrayList<>();

            Iterator<Document> iterator = into.iterator();
            while (iterator.hasNext()) {
                Document next = iterator.next();
                if (next.getInteger("student_id") == controlID) {
                    documents.add(next);

                }

            }
            forRemove.add(documents.stream().min(comparingDouble(o -> o.getDouble("score"))).get());

            controlID++;
        }

        System.out.println(forRemove.size());

//        while(controlID<into.size())


    }/**/

}/**/
