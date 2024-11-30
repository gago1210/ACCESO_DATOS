package DAO;

import java.util.ArrayList;

import com.mongodb.client.MongoCollection;
import database.DBConnection;
import modelo.Profesor;
import org.bson.conversions.Bson;

public class ProfesorDAO {
        MongoCollection<Profesor> collectionprofesores = DBConnection.getDBConnection().getCollectionProfesor();
        Bson filter;
        Document update;
    private final MongoCollection<Profesor> collectionprofesores;

    public ProfesorDao(MongoCollection<Profesor> collectionprofesores) {
        this.collectionprofesores = collectionprofesores;
    }

    // Inserta un nuevo profesor.
    public void insertarProfesor(Profesor profesor) {
        collectionprofesores.insertOne(profesor);
    }

    // Encuentra profesores dentro de un rango de edad.
    public List<Profesor> fbuscarProfesorPorEdad(int gt, int lt) {
        return collectionprofesores.find(Filter.gt("age", gt), Filters.lt("age", lt))
                .into(new ArrayList<>());
    }

    // Encuentra un profesor por su email.
    public Profesor buscarProfesorPorEmail(String email) {
        return collectionprofesores.find(Filter("email", email)).first();
    }

    // Obtiene todos los profesores.
    public List<Profesor> getProfesor() {
        return collectionprofesores.find().into(new ArrayList<>());
    }

    // Actualiza la calificación de un profesor por su email
    public void actualizarProfesorByMail(String email, double rating) {
        collectionprofesores.updateOne(Filter.eq("email", email),
                Updates.set("rating", rating));
    }



}
