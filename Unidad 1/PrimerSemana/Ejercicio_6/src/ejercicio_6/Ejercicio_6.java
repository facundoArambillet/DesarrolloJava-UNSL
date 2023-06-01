package ejercicio_6;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.println("Menu: Elija una opcion");
       System.out.println("1: Sumar");
       System.out.println("2: Restar");
       System.out.println("3: Multiplicar");
       System.out.println("4: Dividir");
       byte userOption = scan.nextByte();
       
       switch(userOption) {
           case 1:
               System.out.println(Programa.addition());
               break;
           case 2:
               System.out.println(Programa.subtraction());
               break;
           case 3:
               System.out.println(Programa.multiplication());
               break;
           case 4:
               System.out.println(Programa.division());
               break;
           default:
               System.out.println("Opcion no valida , vuelva a ejecutar el programa");
               break;
       }
    }
    
}
