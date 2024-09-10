package connections;

import com.mongodb.client.MongoClients;

public class MongodbConnect {
    public static void main(String[] args) {
       connect();
        }

    static void connect() {
        try (var mongoClient = MongoClients.create()) {
            System.out.println("Connection to MongoDB established");
        }
    }
}
