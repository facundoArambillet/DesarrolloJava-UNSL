package ejercicio_9;

public class Ejercicio_9 {
    public static void main(String[] args) {
        Automovil auto_1 = new Automovil("Toyota","Corolla", 2020,2.5f);
        Motocicleta moto_1 = new Motocicleta("Yamaha", "YZF-R6", 2021, 0.59f);
        
        System.out.println(auto_1.toString());
        System.out.println(moto_1.toString());
    }
    
}
