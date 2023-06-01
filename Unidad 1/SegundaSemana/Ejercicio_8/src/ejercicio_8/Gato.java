package ejercicio_8;

public class Gato implements Animal{

    @Override
    public String makeSound() {
        return "Maulla";
    }

    @Override
    public String move() {
        return "Camina sigilosamente para atacarte mientras dormis";
    }
    
}
