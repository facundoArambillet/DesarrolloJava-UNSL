package ejercicio_1;

import java.util.Scanner;

public class Ejercicio_1 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un numero entero para saber si es par o impar: ");
        int userNumber = scan.nextInt();
        scan.close();
        System.out.println(Maths.isEven(userNumber));
        
    }

    
}
