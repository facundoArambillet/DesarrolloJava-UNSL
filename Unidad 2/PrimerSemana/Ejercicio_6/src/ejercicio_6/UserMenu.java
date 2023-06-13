package ejercicio_6;

import java.util.Arrays;
import java.util.Scanner;

public abstract class UserMenu {
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        
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
        
        System.out.println("Datos del usuario: " + user_1.toString());
        
        //Una forma de poder imprimir los productos
       // System.out.println(Arrays.toString(orderedProducts));
        
        for( int i = 0; i < orderedProducts.length; i++) {
            System.out.println("Producto "+ (i+1)+": " + orderedProducts[i].toString());
        }
    }
}
