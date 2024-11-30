package DAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import database.DBConnection;
import modelo.Alumno;
import org.bson.conversions.Bson;

public class AlumnoDAO {

    MongoCollection<Alumno> Collectionalumno = DBConnection.getDBConnection().getCollectionAlumno();
    Bson filter;
    Document update;

    public class AlumnoDao {
        private final MongoCollection<Alumno> alumnosCollection;

        public AlumnoDao(MongoCollection<Alumno> alumnosCollection) {
            this.alumnosCollection = alumnosCollection;
        }

        public void insertarAlumno(Alumno alumno) {
            alumnosCollection.insertOne(alumno);
        }

        public List<Alumno> getAlumnos() {
            return alumnosCollection.find(Alumno.class).into(new ArrayList<>());
        }

        public Alumno buscarAlumnoPorEmail(String mail) {
            return alumnosCollection.find(Filters.eq("email", mail)).first();
        }

        public List<Alumno> buscarAlumnoPorCalification(double calificationThreshold) {
            return alumnosCollection.find(Filters.gt("rating", calificationThreshold), Alumno.class)
                    .into(new ArrayList<>());
        }

        public void eliminarAlumnosCalification(String criterio, double valor) {
            alumnosCollection.deleteMany();
        }
    }
}
