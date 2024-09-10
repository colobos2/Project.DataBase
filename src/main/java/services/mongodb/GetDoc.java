package services.mongodb;

import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.function.Consumer;

public class GetDoc {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create()){
            var database = mongoClient.getDatabase("Project");
            var todoCollection = database.getCollection("project6");
            todoCollection.find().forEach((Consumer<Document>) System.out::println);;
        }
    }
}
