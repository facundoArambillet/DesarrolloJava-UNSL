package ejercicio_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileWriterInfo {
    
    public static void writer(String path) {
        try {
            //Al tener FALSE, se reescribe el archivo cada vez que se ejecuta el programa
            //Si se cambia a TRUE, persisten los datos y va creando lineas una debajo de otra
            
            FileWriter fileWriter = new FileWriter(path, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese cantidad de estudiantes a registrar: ");
            
            int numberStudents = scanner.nextInt();
            scanner.nextLine();
            for(int i = 0; i < numberStudents; i++) {
                String content = "";
                System.out.println("Ingrese nombre completo del alumno: ");
                String name = scanner.nextLine();
                
                System.out.println("Ingrese numero de registro del alumno: ");
                int registrationNumber = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Ingrese carrera del alumno: ");
                String career = scanner.nextLine();
                
                content = name + " " + registrationNumber + " " + career;
                printWriter.println(content);
                printWriter.println();
                
            }        
            printWriter.close();
            System.out.println("Los datos se han guardado en el archivo correctamente.");
        } catch (IOException ex) {
           // Logger.getLogger(FileWriterInfo.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error");
        }
    }
}
