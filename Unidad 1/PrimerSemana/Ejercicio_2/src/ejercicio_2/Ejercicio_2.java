package ejercicio_2;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String userName = scan.nextLine();
        //La funcion substring cuando se le pasan 2 parametros "corta" 
        //el string (En este caso le digo que recorra desde la posicion 0 hasta la 1 es decir la primer letra)
        //y lo devuelve
        //En este caso estoy agarrando el nombre que me ingresa el usuario
        //Agarro la primer letra con: userName.substring(0,1), 
        //Despues la transformo en mayuscula con: toUpperCase().
        //Y despues vuelvo a usar substring, que cuando se le pasa 1 solo parametro, agarra el string desde la posicion
        //Que se le indica , en este caso el nombre del usuario menos la primera letra
        String greeting = "Hola " + userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase() + ", como andas?";
        scan.close();
        System.out.println(greeting);
    }
    
}
