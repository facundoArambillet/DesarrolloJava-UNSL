package ejercicio_5;

public class Ejercicio_5 {

    public static void main(String[] args) {
        Auto auto_1 = new Auto();
        Moto moto_1 = new Moto();
        
        auto_1.accelerate();
        moto_1.accelerate();
        System.out.println(auto_1.getCurrentSpeed());
        System.out.println(moto_1.getCurrentSpeed());
    }
    
}
