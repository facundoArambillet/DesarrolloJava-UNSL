package ejercicio_6;

import java.util.Scanner;

public class Programa {
    public static float addition() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        float number_1 = scan.nextFloat();
        System.out.println("Ingrese el segundo numero: ");
        float number_2 = scan.nextFloat();
        scan.close();
        return Calculadora.addition(number_1, number_2);
    }
    public static float subtraction() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        float number_1 = scan.nextFloat();
        System.out.println("Ingrese el segundo numero: ");
        float number_2 = scan.nextFloat();
        scan.close();
        return Calculadora.subtraction(number_1, number_2);
    }
    public static float multiplication() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        float number_1 = scan.nextFloat();
        System.out.println("Ingrese el segundo numero: ");
        float number_2 = scan.nextFloat();
        scan.close();
        return Calculadora.multiplication(number_1, number_2);
    }
    public static float division() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        float number_1 = scan.nextFloat();
        System.out.println("Ingrese el segundo numero: ");
        float number_2 = scan.nextFloat();
        scan.close();
        return Calculadora.division(number_1, number_2);  
    }
}
