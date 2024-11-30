import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.List;

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

        //MongoClient mongoClient = MongoClients.create(settings);
       MongoClient mongoClient1 = MongoClients.create(String.format(connectionString, DBScheme.USER,DBScheme.PASS));

        //database
        MongoDatabase database = MongoClient.getDatabase( "Instituto");

        //collection
        MongoCollection collection = database.getCollection("collectionalumnos");
        MongoCollection <Document> collectionalumnos = database.getCollection("collectionalumnos");

        //inserto los documentos
        List<Document>listaInsercionalumnos = Arrays.asList(
                new Document ().append ("_id", "672478d2f7d96a9e53a59004").append ("rating" , "5.27").append ("age", "34").append ("name", "Kate Neal").append("gender","female").append("email","kateneal@hivedom.com").append("phone","+1 (825) 464-3051").append ("calificaation","2").append("higher_grade","DAW"),
                new Document ().append ("_id", "672478d2e698286d196506ab").append ("rating" , "9.24").append ("age", "37").append ("name", "Virginia Flowers").append("gender","female").append("email","virginiaflowers@hivedom.com").append("phone","+1 (949) 562-2204").append ("calificaation","1").append("higher_grade","DAM"),
                new Document ().append ("_id", "672478d21e269b4a57c5e051").append ("rating" , "7.12").append ("age", "33").append ("name", "Vanessa Gibbs").append("gender","female").append("email","vanessagibbs@hivedom.com").append("phone","+1 (942) 591-3521").append ("calificaation","5").append("higher_grade","DAM"),
                new Document ().append ("_id", "672478d29c4cea1c323ee84d").append ("rating" , "6.02").append ("age", "26").append ("name", "Wood Sloan").append("gender","male").append("email","woodsloan@hivedom.com").append("phone","+1 (990) 563-3488").append ("calificaation","3").append("higher_grade","DAM"),
                new Document ().append ("_id", "672478d25ada5a95d4bfb81e").append ("rating" , "8.81").append ("age", "34").append ("name", "Jaime Howard").append("gender","female").append("email","jaimehoward@hivedom.com").append("phone","+1 (894) 510-2219").append ("calificaation","7").append("higher_grade","ASIR"),
                new Document ().append ("_id", "672478d2b66e5b36013188b5").append ("rating" , "5.56").append ("age", "38").append ("name", "Chase Conley").append("gender","male").append("email","chaseconley@hivedom.com").append("phone","+1 (937) 488-2414").append ("calificaation","10").append("higher_grade","DAM"),
                new Document ().append ("_id", "672478d21456f136l4e116f").append ("rating" , "6.12").append ("age", "23").append ("name", "Dixie Woods").append("gender","female").append("email","dixiewoods@hivedom.com").append("phone","+1 (976) 408-3974").append ("calificaation","4").append("higher_grade","DAM"),
                new Document ().append ("_id", "672478d2b7dd115e7193f58f").append ("rating" , "8.81").append ("age", "39").append ("name", "Moody Arnold").append("gender","male").append("email","moodyarnold@hivedom.com").append("phone","+1 (830) 420-2446").append ("calificaation","6").append("higher_grade","DAM"),
                new Document ().append ("_id", "672478d242d0b4abb287d0fa").append ("rating" , "7.17").append ("age", "23").append ("name", "Mcmillan Singleton").append("gender","male").append("email","mcmillansingleton@hivedom.com").append("phone","+1 (904) 563-3920").append ("calificaation","10").append("higher_grade","DAW"),
                new Document ().append ("_id", "672478d202650f5e0185632a").append ("rating" , "7.55").append ("age", "34").append ("name", "Wall Best").append("gender","male").append("email","wallbest@hivedom.com").append("phone","+1 (893) 461-3843").append ("calificaation","0").append("higher_grade","ASIR")
        );
        collectionalumnos.insertMany(listaInsercionalumnos);
        System.out.println("Datos de alumnos introducidos correctamente");



        //collection
        MongoCollection collection = database.getCollection("collectionprofesores");
        List<Document>listaInsercionprofesores = Arrays.asList(
                new Document ().append ("_id", "6724775549c221e4ea993a3e").append ("rating" , "9.02").append ("age", "20").append ("name", "Victoria Foster").append("gender","female").append("email","victoriafoster@hivedom.com").append("phone","+1 (814) 589-2100").append ("subjects","Lenguaje de marcas, Sistemas informáticos, Base de datos").append("title","Ingeniero industriales"),
                new Document ().append ("_id", "672477553713dad19d93638f").append ("rating" , "6.39").append ("age", "25").append ("name", "Hudson Gates").append("gender","male").append("email","hudsongates@hivedom.com").append("phone","+1 (997) 459-3540").append ("subjects", "Sistema de gestion empresarial, Base de datos").append("title","Ingeniero informatico"),
                new Document ().append ("_id", "6724775559a0f8f473a32640").append ("rating" , "9.93").append ("age", "27").append ("name", "Elisa Mcgowan").append("gender","female").append("email","elisamcgowan@hivedom.com").append("phone","+1 (932) 507-2855").append ("subjects", "Acceso datos, Sistema de gestion empresarial, Programacion multimedia, Lenguaje de marcas, Base de datos").append("title","Ingeniero industriales"),
                new Document ().append ("_id", "6724775595741c4ccac71f7b").append ("rating" , "7.24").append ("age", "37").append ("name", "Rena Castro").append("gender","female").append("email","renacastro@hivedom.com").append("phone","+1 (851) 423-3547").append ("subjects", "Acceso datos, Sistema informaticos, Programacion multimedia").append("title","Ingeniero industriales"),
                new Document ().append ("_id", "67247755ce71f04e8c1c3e1d").append ("rating" , "8.08").append ("age", "32").append ("name", "Haney Price").append("gender","male").append("email","haneyprice@hivedom.com").append("phone","+1 (982) 579-3098").append ("subjects", "Lenguaje de marcas, Desarrollo interfaces, Sistema de gestion empresarial").append("title","Ingeniero informatico"),
                new Document ().append ("_id", "672477552b252c8a32223894").append ("rating" , "8.48").append ("age", "24").append ("name", "Bernice Hall").append("gender","female").append("email","bernicehall@hivedom.com").append("phone","+1 (937) 419-2861").append ("subjects", "Acceso datos, Base datos, Programacion multimedia").append("title","Ingeniero caminos")
                );
        collectionprofesores.insertMany(listaInsercionprofesores);
        System.out.println("Datos de profesores introducidos correctamente");


        //Create --> insertOne / InsertMany
        //Update --> update
        //Delete --> delete
        //Selet --> find
    }
}
