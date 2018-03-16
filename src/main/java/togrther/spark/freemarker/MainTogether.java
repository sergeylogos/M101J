package togrther.spark.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class MainTogether {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(MainTogether.class, "/template/");

        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("test", "hello!");
                StringWriter writer = new StringWriter();
                Template template = configuration.getTemplate("index.ftl");
                template.process(map, writer);
                return writer;
            }

        });

        Spark.get("/saveGet", (Request req, Response res) -> {
            String name = req.queryParams("name");
            System.out.println(name);
            return "hey you";
        });

        Spark.get("/path/:variable", ((request, response) -> {
            System.out.println(request.params("variable"));

            return ":variable   ";
        }));

        Spark.post("/savePost" , (request, response) -> {
            System.out.println(request.queryParams("surname"));
            return null;});


    }
}
