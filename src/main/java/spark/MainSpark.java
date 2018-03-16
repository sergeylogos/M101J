package spark;

public class MainSpark {
    public static void main(String[] args) {
     Spark.get("/", new Route() {
         public Object handle(Request request, Response response) throws Exception {
             return "hello spark";
         }
     });
    }
}
