import controller.GestorFicheros;

import java.io.File;
import java.io.IOException;

public class Entrada {
    public static void main(String[]args){

        GestorFicheros gestorFicheros = new GestorFicheros();
        //gestorFicheros.lecturaDirectorios ("src/resources/directorio");
        //gestorFicheros.lecturaDirectorios ("src/resources/ficheros");

        gestorFicheros.lecturaRecursiva("C:\\Users\\GAGO\\Documents\\GitHub");


    }
}
