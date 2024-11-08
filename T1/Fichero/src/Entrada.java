import controller.GestorFicheros;

import java.io.FileNotFoundException;

public class Entrada {
    public static void main(String[]args) {

// al ponerle  public static void main(String[]args) throws FileNotFoundException,
// le paso toda la responsabilidad  al metodo main, ESTO TIENE QUE SER LA ULTIMA OPCION A REALIZAR
// EL PROGRAMA SE ME VA  APARAR SI HAY ALGUNA EXCEPCION QUE NO SE SOLUCIONE


        GestorFicheros gestorFicheros = new GestorFicheros();
        //gestorFicheros.lecturaDirectorios ("src/resources/directorio");
        //gestorFicheros.lecturaDirectorios ("src/resources/ficheros");
        //gestorFicheros.lecturaRecursiva("C:\\Users\\GAGO\\Documents\\GitHub");
        gestorFicheros.lecturaTextoPlano("src/resources/directorio/subcarpeta/ficheros/lectura.txt");

        //instancias de objetos y llamada sa metodos
        //OBJETO CLASE 1
        //OBJETO CLASE 2
        //FILE --> fichero logico --> fisico
        //fichero logico
        //File ficheroSinpUNTERO = new File ("C:\\Users\\GAGO\\Documents\\GitHub");
        //System.out.println(ficheroSinPuntero.getName());
        //System.out.println(ficheroSinPuntero.getParent());
        //System.out.println(ficheroSinPuntero.length());
        //System.out.println(ficheroSinPuntero.exists());
        //System.out.println(ficheroSinPuntero.isDirectory());

        //File[] -->todas las rutas de los FICHEROS que estan dentro del directorio ficheroSinPUnerto.list();

        //EJERCICIO 1: Obtener todos los nombres de los ficheros del directorio llamado directorio
        //EJERCICIO 2: Crear una subcarpeta en el directorio llamado directorio y crea ren ella un fichero.
                    //Obtener todos los nombres de los ficheros del directorio llamado directorio y el dubdirectorio creado.
        //EJERCICIO 3. Listar el nombre de todos los ficheros del SISTEMA (C://Users)

        //RECURSIVIDAD



    }
}
