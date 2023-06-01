package ejercicio_8;

public class Perro implements Animal{
    
    @Override
    public String makeSound() {
        return "Ladra";
    }

    @Override
    public String move() {
        return "Corre por todos lados descontrolado";
    }
    
}
