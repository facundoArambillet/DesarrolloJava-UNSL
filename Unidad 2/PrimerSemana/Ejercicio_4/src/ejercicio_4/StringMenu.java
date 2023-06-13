package ejercicio_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public abstract class StringMenu {
    
        public static void menu() {
        System.out.println("Ingrese la cantidad de palabras que quiere guardar: ");
        Scanner scan = new Scanner(System.in);
        int arrayLength = scan.nextInt();

        ArrayList<String> userArray = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Ingrese una palabra: ");
            String userWord = scan.next();
            userArray.add(userWord);
        }
        System.out.println("Ingrese una vocal para borrar las palabras que la incluyan: ");
        String userVowels = scan.next();
        
        System.out.println("Las palabras eran: " + userArray);
        Iterator<String> iterator = userArray.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            char[] letters = word.toCharArray();
            for (int j = 0; j < letters.length; j++) {
                if (userVowels.charAt(0) == letters[j]) {
                    iterator.remove();
                    break; 
                }
            }
        }

        System.out.println("La vocal elegida es: " + userVowels);
        System.out.println("Las palabras actuales son: " + userArray);

        scan.close();
    }

}
