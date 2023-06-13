package ejercicio_3;

import java.util.Scanner;

public abstract class NumbersMenu {
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el largo de la lista: ");
        int listLength = scan.nextInt();
        
        double[] userList = new double[listLength];
        
        for( int i = 0; i < userList.length; i++) {
            System.out.println("Ingrese un numero: ");
            double userNumber = scan.nextDouble();
            userList[i] = userNumber;
        }
        
        System.out.println("Ingrese la posicion del numero que quiere revisar: ");
        int arrayPosition = scan.nextInt();
        
        System.out.println("El numero que eligio es el: " + userList[arrayPosition]);
        
        System.out.println("El array tiene los siguientes valores: ");
        for(double number : userList) {
            System.out.println(number);
        }
    }
}
