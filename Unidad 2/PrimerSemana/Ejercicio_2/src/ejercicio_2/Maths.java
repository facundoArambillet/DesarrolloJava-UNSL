package ejercicio_2;

public abstract class Maths {
    
    public static boolean isPalindrome(String word) {
        char[] letras = word.toCharArray();
        boolean isPalindromo = false;
        int longitud = letras.length;
        
        for (int i = 0; i < longitud / 2; i++) {
            if (letras[i] != letras[longitud - 1 - i]) {
                isPalindromo = false;
            }
            else {
                isPalindromo = true;
            }
        }
        
        return isPalindromo;

    }
}
