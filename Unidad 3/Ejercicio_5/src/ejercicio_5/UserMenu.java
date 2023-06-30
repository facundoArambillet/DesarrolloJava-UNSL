package ejercicio_5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class UserMenu {
    
    public static void menu(String path) {
        try {
            Scanner scan = new Scanner(System.in);
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            System.out.println("Ingrese su nombre: ");
            String userName = scan.nextLine();
            
            System.out.println("Ingrese su edad: ");
            byte userAge = scan.nextByte();
            
            System.out.println("Ingrese la cantidad de productos que va a querer registrar: ");
            int arrayLength = scan.nextInt();
            
            Product[] products = new Product[arrayLength];
            for(int i = 0; i < arrayLength; i++) {
                System.out.println("Ingrese el nombre del producto " + (i+1) + ": ");
                String productName = scan.next();
                
                System.out.println("Ingrese el precio del producto: ");
                float productPrice = scan.nextFloat();
                
                System.out.println("Ingrese el stock de dicho producto: ");
                int productStock = scan.nextInt();
                
                Product product = new Product(productName,productPrice,productStock);
                products[i] = product;
            }   
            User user_1 = new User(userName,userAge, products);
            Product[] orderedProducts = user_1.getProductsOrderByStock();
            printWriter.println("Usuario: " + user_1.getName() + "\n");
            
            for(int j = orderedProducts.length - 1 ; j >= 0; j--) {
                printWriter.println(orderedProducts[j].getName() + " " + orderedProducts[j].getPrice() + " " + orderedProducts[j].getStock());
            }
            System.out.println("Productos registrados con exito");
            scan.close();
            fileWriter.close();
            printWriter.close();
        } 
        catch (IOException ex) {
            //Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la lectura o escritura del archivo");
        }
        
    }
}
