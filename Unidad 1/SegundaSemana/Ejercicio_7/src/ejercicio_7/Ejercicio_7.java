package ejercicio_7;

public class Ejercicio_7 {

    public static void main(String[] args) {
        Circulo circulo_1 = new Circulo(3f);
        Rectangulo rectangulo_1 = new Rectangulo(10f,5f);
        
        System.out.println("El perimetro del Circulo es: " + circulo_1.calculatePerimeter());
        System.out.println("El area del Circulo es: " + circulo_1.calculateArea());
        
        System.out.println("El perimetro del Rectangulo es " + rectangulo_1.calculatePerimeter());
        System.out.println("El area del Rectangulo es " +rectangulo_1.calculateArea());
    }
    
}
