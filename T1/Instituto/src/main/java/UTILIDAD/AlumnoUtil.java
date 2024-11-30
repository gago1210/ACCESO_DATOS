package UTILIDAD;

import DAO.AlumnoDao;
import modelo.Alumno;
import utilidad.menuUtil;

import java.util.Scanner;

public class AlumnoUtil {
    private final AlumnoDao alumnoDao = new AlumnoDao();
    private final Scanner scanner = new Scanner(System.in);
    private final Utilidad utils = new Utilidad();

        public void insertarAlumno() {
            Alumno alumno = new Alumno();
            alumno.setName(pedirEntrada("Name: "));
            alumno.setAge((int) utils.validarNumero(pedirEntrada("Edad (número): ")));
            alumno.setGender(pedirEntrada("Género: "));
            alumno.setEmail(pedirEntrada("Email: "));
            alumno.setPhone(pedirEntrada("Teléfono: "));
            alumno.setHigherGrade(pedirEntrada("Curso: "));
            alumno.setCalification(utils.validarNumero(pedirEntrada("Calificación (número): ")));
            alumno.setRating(utils.validarNumero(pedirEntrada("Rating (número): ")));

            alumnoDao.insertarAlumno(alumno);
        }

        public void listarAlumnos() {
            System.out.println("ALUMNOS");
            alumnoDao.getAlumno().forEach(System.out::println);
            if (alumnoDao.getAlumno().isEmpty()) {
                System.out.println("No hay alumnos registrados.");
            }
            System.out.println("0");
        }

        public void buscarPorEmail() {
            String email = pedirEntrada("Email necesario: ");
            Alumno alumno = alumnoDao.findAlumnoByMail(email);
            System.out.println(alumno != null ? alumno : "No hay alumno al cual corresponda el email " + email);
        }

        public void bajaPorNota() {
            double nota = utils.validarNumero(pedirEntrada("Mayor nota de (número): "));
            if (alumnoDao.findAlumnoByCalification(nota).isEmpty()) {
                System.out.println("No hay alumnos con una calificación mayor  a " + nota);
            } else {
                alumnoDao.deleteAlumnosCalification("rating", nota);
            }
        }


    }
