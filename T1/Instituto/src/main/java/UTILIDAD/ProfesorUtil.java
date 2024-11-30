package UTILIDAD;
import DAO.ProfesorDAO;
import modelo.Profesor;
import utilidad.MenuUtil;

import java.util.ArrayList;
import java.util.Scanner;
public class ProfesorUtil {
    private final ProfesorDao profesorDao = new ProfesorDao();
    private final Scanner scanner = new Scanner(System.in);
    private final Utils utils = new Utils();

    public void insertarProfesor() {
        Profesor profesor = new Profesor();
        profesor.setName(pedirEntrada("Nombre: "));
        profesor.setAge((int) utils.validarNumero(pedirEntrada("Edad (número): ")));
        profesor.setGender(pedirEntrada("Género: "));
        profesor.setEmail(pedirEntrada("Email: "));
        profesor.setPhone(pedirEntrada("Teléfono: "));
        profesor.setTitle(pedirEntrada("Título: "));
        profesor.setSubjects(pedirListaAsignaturas());
        profesor.setRating(utils.validarNumero(pedirEntrada("Puntuación (número): ")));

        profesorDao.insertProfesor(profesor);
    }

    public void listarProfesores() {
        System.out.println("PROFESORES");
        profesorDao.getProfesores().forEach(System.out::println);
        if (profesorDao.getProfesores().isEmpty()) {
            System.out.println("No hay profesores registrados.");
        }
        System.out.println("0");
    }

    public void buscarEdad() {
        int edadMinima = (int) utils.validarNumero(pedirEntrada("Mayor que (edad): "));
        int edadMaxima = (int) utils.validarNumero(pedirEntrada("Menor que (edad): "));
        var profesores = profesorDao.findProfesorByAge(edadMinima, edadMaxima);

        if (profesores.isEmpty()) {
            System.out.println("No hay profesores entre " + edadMinima + " y " + edadMaxima + " años.");
        } else {
            profesores.forEach(System.out::println);
        }
    }

    public void editarCalificacion() {
        String email = pedirEntrada("Email a buscar: ");
        Profesor profesor = profesorDao.findProfesorByEmail(email);

        if (profesor != null) {
            double nuevaCalificacion = utils.validarNumero(pedirEntrada("Nueva calificación (número): "));
            profesorDao.updateProfesorByMail(email, nuevaCalificacion);
            System.out.println("Calificación actualizada: " + profesorDao.findProfesorByEmail(email));
        } else {
            System.out.println("No se ha encontrado ningún profesor con el correo " + email);
        }
    }

    private String pedirEntrada(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private List<String> pedirListaAsignaturas() {
        System.out.println("Asignaturas (deja vacío para finalizar): ");
        List<String> asignaturas = new ArrayList<>();
        while (true) {
            String asignatura = scanner.nextLine();
            if (asignatura.isEmpty()) {
                break;
            }
            asignaturas.add(asignatura);
        }
        return asignaturas;
    }

}
