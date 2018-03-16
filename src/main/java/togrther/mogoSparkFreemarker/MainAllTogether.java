package togrther.mogoSparkFreemarker;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.bson.Document;
import spark.Spark;
import togrther.spark.freemarker.MainTogether;

import java.io.StringWriter;

public class MainAllTogether {
    public static void main(String[] args) {
        /*DB config*/
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("course");
        MongoCollection<Document> coll = database.getCollection("allTogether");
        coll.drop();
        coll.insertOne(new Document("test", "SERJZ"));
        /*freemarker config*/
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(MainTogether.class, "/template/");

        /*Spark config and use*/
        Spark.get("/", (request, response) -> {
            StringWriter writer = new StringWriter();
            Template template = cfg.getTemplate("index.ftl");
            template.process(coll.find().first(), writer);


            return writer;
        });
    }
}
