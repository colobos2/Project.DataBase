package services.mongodb;

import com.mongodb.client.MongoClients;

public class DeleteCollection {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create()) {
            var database = mongoClient.getDatabase("Project");
            var todoCollection = database.getCollection("project6");
            todoCollection.drop();
        }
    }
}
