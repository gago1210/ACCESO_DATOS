import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import database.DBScheme;

public class Entrada {

    public static void main (String [] args ) {
        //connection
        String connectionString = "mongodb+srv://$s:%s@cluster0.ox4hk.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(String.format(connectionString, DBScheme.USER,DBScheme.PASS)))
                .serverApi(serverApi)
                .build();

        MongoClient mongoClient = MongoClients.create(String.format(connectionString, DBScheme.USER,DBScheme.PASS));

        //database
        MongoDatabase database = MongoClient.getDatabase( "instituto");


        //collection
        //Create --> insertOne / InsertMany
        //Update --> update
        //Delete --> delete
        //Selet --> find
    }
}
