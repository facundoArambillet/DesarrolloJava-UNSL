
package ejercicio_3;

import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la base del triangulo: ");
        float base = scan.nextFloat();
        System.out.println("Ingrese la altura del triangulo: ");
        float height = scan.nextFloat();
        float area = base * height /  2;
        System.out.println("El area es de: " + area);
    }
    
}
