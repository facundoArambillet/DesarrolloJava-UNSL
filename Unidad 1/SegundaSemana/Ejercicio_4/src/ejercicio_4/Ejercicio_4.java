package ejercicio_4;

public class Ejercicio_4 {

    public static void main(String[] args) {
        Circulo circulo_1 = new Circulo(5f);
        Cuadrado cuadrado_1 = new Cuadrado(10);
        Rectangulo rectangulo_1 = new Rectangulo(5,7);
        
        System.out.println("El Area del Circulo es: " + circulo_1.calculateArea());
        System.out.println("El Area del Cuadrado es: " + cuadrado_1.calculateArea());
        System.out.println("El Area del Rectangulo es: " +rectangulo_1.calculateArea());
    }
    
}
