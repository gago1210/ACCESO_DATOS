package UTILIDAD;
import java.util.Scanner;

public class MenuUtil {
    AlumnoUtil alumnoUtil = new AlumnoUtil();
    ProfesorUtil profesorUtil = new ProfesorUtil();

    public boolean ejecutarmenuUtil() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Elige una opción:");
            System.out.println("1. Insertar Profesor");
            System.out.println("2. Insertar Alumno");
            System.out.println("3. Listar Profesores y Alumnos");
            System.out.println("4. Listar Profesores");
            System.out.println("5. Listar Alumnos");
            System.out.println("6. Buscar Alumno por Email");
            System.out.println("7. Buscar Profesor por Edad");
            System.out.println("8. Editar Calificación del Profesor");
            System.out.println("9. Dar de Baja Alumno por Nota");
            System.out.println("10. Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            if (opcion == 10) {
                salir = true;
            } else if (opcion == 1) {
                profesorUtil.insertarProfesor();
            } else if (opcion == 2) {
                alumnoUtil.insertarAlumno();
            } else if (opcion == 3) {
                profesorUtil.listarProfesores();
                alumnoUtil.listarAlumnos();
            } else if (opcion == 4) {
                profesorUtil.listarProfesores();
            } else if (opcion == 5) {
                alumnoUtil.listarAlumnos();
            } else if (opcion == 6) {
                alumnoUtil.buscarPorEmail();
            } else if (opcion == 7) {
                profesorUtil.buscarEdad();
            } else if (opcion == 8) {
                profesorUtil.editarCalificacion();
            } else if (opcion == 9) {
                alumnoUtil.bajaPorNota();
            } else {
                System.out.println("Opción no válida.");
            }
        }

        return salir;
    }

}

