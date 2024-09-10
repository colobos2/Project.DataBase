package services.mongodb;

import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.function.Consumer;

public class GetDataBase {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create()) {
            mongoClient.listDatabases()
                    .forEach((Consumer<Document>) System.out::println);
            mongoClient.listDatabaseNames()
                    .forEach((Consumer<String>) System.out::println);
        }
    }
}
