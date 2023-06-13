package ejercicio_2;

import java.util.Scanner;

public class Ejercicio_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese una palabra para determinar si es palindroma: ");
        String userWord = scan.nextLine();
        scan.close();
        
        if(Maths.isPalindrome(userWord)) {
            System.out.println("La palabra: " + userWord + ", es palindroma");
        }
        else {
            System.out.println("La palabra: " + userWord + ", no es palindroma");
        }
        
    }
    

    
}
