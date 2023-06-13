package ejercicio_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class UserMenu {
    
    public static void menu() {
        System.out.println("Ingrese una palabra o frase: ");
        Scanner scan = new Scanner(System.in);
        String userWord = scan.nextLine();
        
        //Le saco los espacios y vuelvo la frase toda en minuscula
        String userWordWithoutSpace = userWord.replaceAll("\\s+", "").toLowerCase();
        
        char[] userWordArray = userWordWithoutSpace.toCharArray();
        //Creo un map que de Keys tiene caracteres y de Values tiene enteros
        Map<Character,Integer> counter = new HashMap<>();
        
        //Recorro el array de caracteres
        for(char character : userWordArray) {
            //Si existe el caracter en mi map lo actualizo sumandole 1 al entero(que es mi fecuencia de apariciones)
            if(counter.containsKey(character)) {
                counter.put(character, counter.get(character) + 1);
            }
            //Si no existe en mi map, lo agrego y le seteo 1 al entero(que es mi fecuencia de apariciones)
            else {
                 counter.put(character, 1);
            }
        }
        //Recorro el map con un for each mostrando las keys y values
        for (Map.Entry<Character, Integer> entry : counter.entrySet() ) {
            System.out.println ("La letra: " + entry.getKey() + ", tiene: " + entry.getValue() + ", coincidencias");
        }
        scan.close();
    }
}
