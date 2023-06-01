package ejercicio_8;

public class Pajaro implements Animal{

    @Override
    public String makeSound() {
        //Sonido que hace un pajaro segun google
        return "Trinea";
    }

    @Override
    public String move() {
        return "Vuela libremente";
    }
    
}
