package ejercicio_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileReaderData {
    
    public static void reader(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                String nombre = parts[0];
                int edad = Integer.parseInt(parts[1]);

                if (edad <= 32) {
                    System.out.println("Nombre: " + nombre + ", Edad: " + edad);
                }
            }

            scanner.close();
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FileReaderData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Archivo no encontrado");
        }
    }
}
