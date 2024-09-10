package services.mongodb;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import services.Postgres.GetInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AddDocumentToMongo {

    public static void main(String[] args) throws SQLException {
        try (var mongoClient = MongoClients.create()) {
            var database = mongoClient.getDatabase("Project");
            var todoCollection = database.getCollection("project6");

            List<Map> docs = GetInfo.getInfo();
            for (int i=0;i<docs.size();i++){
            var todoDocument = new Document(docs.get(i));
                todoCollection.insertOne(todoDocument);}
            }
        }
    }


