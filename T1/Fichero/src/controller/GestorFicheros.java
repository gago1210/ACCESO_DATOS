package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GestorFicheros {

    public void lecturaDirectorios (String path)   {
        //File (logico) --> File (fisico)
        File file = new File (path);
        String [] nombres = file.list ();
        File []ficheros = file.listFiles ();
        for (File item : ficheros ) {
            //if (!item.isHidden()){ -->solo mostrar los que no son ocultos
                System.out.println(item.getName ()); //hasta aqui la parte del ejercicio 1, comienzo del 2:
                if  (item.isDirectory()) {
                    File[] subdirectorio = item.listFiles();
                    for (File file1 : subdirectorio) {
                        System.out.println(file1.getName()); //hasta aqui el ejercicio 2,
                        // comienzo del 3, lo va a hacer de solo lo de la carpeta de GitHub
                    }
            }
        }
    }
    public void lecturaRecursiva(String path) {
        File file = new File(path); //paso a un fichero logico y fisico
        File[] ficheros = file.listFiles();
        for (File item : ficheros) {
            System.out.println(item.getName());
            //pregunto si es directorio
            //saco todos los ficheros del directorio y los muestro --> no se cuantas veces pregunto --> aplico la recursividad
            //Recursividad es una tecnica de ejecucion que se llama a ella misma, teniendo en cuidado en que tenga una salida:

        }
    }
    private void lecturaSubdirectorios(File fichero){
        for (File file : fichero.listFiles()) {
            System.out.println(file.getName());
            if (file.isDirectory()){
                lecturaSubdirectorios(file);
            }
        }
    }

   // CLASE 20/09 LECTURA DE FICHEROS
    public void lecturaTextoPlano (String path) {
        //creo el File -->FileReader --> finally, cuando se terminan SE CIERRAN con finally (ver abajo)
        File file = new File (path);
        fileReader fileReader = null;
        BufferedReader buffererReader = null;

        if (file.exists() && file.isFile()) {
            //existe y ademas es un fichero entonces:
            //esta excepcion la puedo tratar aqui porque asi no pasa mas adelante
            try {
                fileReader = new FileReader(file); //esto se traduce a no se ha encontrado el fichero por lo que pasa a catch
                //hacer una lectura recurrente (frase, no letra por letra)
                //mientras exista el numero hace la lectura e imprime
                while ((lectura = fileReader.read())!=-1) {
                    //imprime
                    System.out.print((char)lectura); //quito ln a println y me lee todo lo del fichero lectura
                    //este tipo de lectura nos interesa para leer todo
                }

                /*int lectura = fileReader.read(); //nos da un numero entero --> que se traduce a un caracter UNICODE correspondiente a una letra en el codigo  ASCI
                System.out.println((char) lectura);
                lectura = fileReader.read();
                System.out.println((char)lectura);
                lectura = fileReader.read();
                System.out.println((char)lectura);
                BufferedReader = new BufferedReader(fileReader);*/ //esto no nos sirve para hacer una lectura recurrente


            } catch (FileNotFoundException e) {
                System.out.println("Fallo en la lectura del fichero");
                System.out.println(e.getMessage());
            } catch (IOException e){
                System.out.println("Error en la escritura, fallo de permisos");
            } finally {
                //es un bloque que se ejecuta siempre, si o si, haya fallos o no
                fileReader.close (); //aqui hay qu eponer otra excepcion, si no nos va a dar error del tipo IOException, lo arreglamos
            } catch (IOException e) {
                System.out.println("Error en el cerrado del flujo");
            }
        }
    }



}
