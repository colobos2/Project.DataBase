package services.mongodb;

import com.mongodb.client.MongoClients;

public class CreateDB {
    public static void main(String[] args) {

        try (var mongoClient = MongoClients.create()) {
            var database = mongoClient.getDatabase("Project");
        }
    }
}
