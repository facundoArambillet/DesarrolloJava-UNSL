package ejercicio_8;

import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CuentaBancaria cuenta_1 = new CuentaBancaria("Facundo",5000,1);
       
        System.out.println("Menu: elija una de las opciones");
        System.out.println("1: Hacer deposito");
        System.out.println("2: Realizar Extraccion");
        byte userOption = scan.nextByte();
        
        switch(userOption) {
            case 1:
                System.out.println("Ingrese la cantidad a depositar: ");
                float amountDeposit = scan.nextFloat();
                System.out.println(cuenta_1.makeDeposit(amountDeposit));
                break;
            case 2:
                System.out.println("Ingrese la cantidad a extraer: ");
                float amountExtract = scan.nextFloat();
                System.out.println(cuenta_1.makeWithdrawal(amountExtract));
                break;
            default:
                System.out.println("Opcion no valida, porfavor vuelva a iniciar el programa");
                break;
        }
    }
    
}
