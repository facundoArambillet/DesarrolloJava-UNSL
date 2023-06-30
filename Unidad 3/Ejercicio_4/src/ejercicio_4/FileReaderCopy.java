package ejercicio_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileReaderCopy {
    
    public static void copy(String path_1 , String path_2) {
        try {
            //FileReader fileReader = new FileReader(path_1);
            File file = new File(path_1);
            Scanner scan = new Scanner(file);
            String content = "";
            
            FileWriter fileWriter = new FileWriter(path_2,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            while(scan.hasNext()) {
                content = scan.nextLine();
                printWriter.println(content);
                printWriter.println();
            }
            scan.close();
            fileWriter.close();
            printWriter.close();
            System.out.println("Datos copiados con exito");
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FileReaderCopy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Archivo no encontrado" );
        } catch (IOException ex) {
            //Logger.getLogger(FileReaderCopy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de escritura");
        }
    }
}
