package ejercicio_8;

public class Ejercicio_8 {

    public static void main(String[] args) {
        Perro perro_1 = new Perro();
        Gato gato_1 = new Gato();
        Pajaro pajaro_1 = new Pajaro();
        
        System.out.println("El perro: " + perro_1.makeSound());
        System.out.println("El perro: " + perro_1.move());
        System.out.println();
        
        System.out.println("El gato: " + gato_1.makeSound());
        System.out.println("El gato: " + gato_1.move());
        
        System.out.println();
        System.out.println("El pajaro: " + pajaro_1.makeSound());
        System.out.println("El pajaro: " + pajaro_1.move());
        
    }
    
}
