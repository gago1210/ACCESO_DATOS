package controller;

public class GestorFicheros {

    public void lecturaDirectorios (String path)   {
        //File (logico) --> File (fisico)
        File file = new File (path);
        String [] nombres = file.list ();
        File []ficheros = file.listFiles ();
        for (File item : ficheros ) {
            //if (!item.isHidden()){ -->solo mostrar los que no son ocultos
                System.out.println(item.getName ()); //hasta aqui la parte del ejercicio 1, comienzo del 2:
                if  (item.isDirectory()){
                    File[] subdirectorio = item.listFiles();
                    for (File file1 : subdirectorio) {
                        System.out.println(file1.getName()); //hasta aqui el ejercicio 2,
                        // comienzo del 3, lo va a hacer de sollo lo de la carpeta de GitHub
                    }
            }
        }
    }
    public void lecturaRecursiva(String path) {
        File file = new File(path); //paso a un fichero logico y fisico
        File[] ficheros = file.listFiles();
        for (File item : ficheros) {
            System.out.println((item.getName());
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
}
