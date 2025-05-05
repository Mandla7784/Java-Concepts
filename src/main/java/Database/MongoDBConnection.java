package Database;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;


public class MongoDBConnection {
      private static  MongoClient mongoClient;
       private static final String uri = "mongodb://localhost:27017/";
        // Construct a ServerApi instance using the ServerApi.builder() method
       static { // initializng mongoClient once
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings= MongoClientSettings.builder().applyConnectionString(new ConnectionString(uri))
                    .serverApi(serverApi).build();

            // Create a new client and connect to the server
           mongoClient = MongoClients.create(settings);

            MongoDatabase database = mongoClient.getDatabase("admin");

            // Send a ping to confirm a successful connection
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println(database.getName());
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");

        }

   public  static  MongoDatabase getDatabase(String dbName){
           return  mongoClient.getDatabase(dbName);

   }



}
