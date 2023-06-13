package ejercicio_1;

public abstract class Maths {
    
    public static String isEven(int number) {
       if(number % 2 == 0){
           return "El numero: " + number + ", es par";
       }
       else {
           return "El numero: " + number + ", es impar";
       }
    }
}
