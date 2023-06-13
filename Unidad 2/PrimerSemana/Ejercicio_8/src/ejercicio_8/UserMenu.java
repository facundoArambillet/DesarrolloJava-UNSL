package ejercicio_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public abstract class UserMenu {
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de numeros que quiere ingresar, recuerde que debe ser de 1 a 10: ");
        byte lengthArray = scan.nextByte();
        while(lengthArray > 10 || lengthArray < 1) {
            System.out.println("Valor invalido vuelva a ingresar un numero: ");
            lengthArray = scan.nextByte();
        }
        //double[] userArray = new double[lengthArray];
        List<Double> userArray = new ArrayList<>();
        System.out.println("Debe ingresar numeros entero o decimales positivos: ");
        for(int i = 0; i < lengthArray; i++) {
            System.out.println("Numero " + (i+1) + ": ");
            double userNumber = scan.nextDouble();

            while(userNumber < 0) {
                System.out.println("Valor incorrecto ingrese otro numero: ");
                userNumber = scan.nextDouble();
            }
            
            userArray.add(userNumber);
        }
        System.out.println("El maximo es: " + findMaximum(userArray));
    }
    
    private static double findMaximum(List<Double> numbers) {
        Iterator<Double> iterator = numbers.iterator();
        double maximum = numbers.get(0);
        
        while(iterator.hasNext()) {
            double number = iterator.next();
            if(number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }
}
