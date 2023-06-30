package ejercicio_1;

import java.io.File;
import java.io.IOException;

public class Ejercicio_1 {
    
    public static void main(String args[]) throws IOException {
    File archi = new File("C:\\Users\\Facundo\\Desktop\\DesarrolloJava\\Unidad 3\\Resources\\Data.txt");
    if (archi.exists()) {
    System.out.println("Nombre del archivo: "+ archi.getName());
    System.out.println("Ruta: "+ archi.getPath());
    System.out.println("Ruta absoluta: "+ archi.getAbsolutePath());
    System.out.println("Se puede escribir: "+archi.canRead());
    System.out.println("Se puede leer: "+archi.canWrite());
    System.out.println("Tamaño: "+archi.length());
    }
    // Mostrar contenido del Archivo datos.txt por consola
    }
    
}
