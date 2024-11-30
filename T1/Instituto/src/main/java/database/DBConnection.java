package database;

import modelo.Alumno;
import modelo.Profesor;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class DBConnection {
    private static DBConnection connection;
    private final MongoDatabase database;

    private DBConnection() {
        CodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClients.create().getCodecRegistry(),
                CodecRegistries.fromProviders(codecProvider)
        );
        String connectionString = "mongodb+srv://$s:%s@cluster0.ox4hk.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoClient mongoClient = MongoClients.create(String.format(connectionString, DBScheme.DB_USERNAME, DBScheme.DB_PASS));
        database = mongoClient.getDatabase("instituto").withCodecRegistry(codecRegistry);
    }

    public MongoCollection<Alumno> getCollectionAlumnos() {
        return database.getCollection("Alumnos", Alumno.class);
    }

    public MongoCollection<Profesor> getCollectionProfesores() {
        return database.getCollection("Profesores", Profesor.class);
    }





}
