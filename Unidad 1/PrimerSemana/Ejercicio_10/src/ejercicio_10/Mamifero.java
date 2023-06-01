package ejercicio_10;

public class Mamifero extends Animal {
    private boolean isCarnivorous;
    
    public Mamifero(String name, byte age, boolean isCarnivorous) {
        super(name, age);
        this.isCarnivorous = isCarnivorous;
    }
    
    public boolean isCarnivorous() {
        return this.isCarnivorous;
    }
    
    public void setIsCarnivorous() {
        this.isCarnivorous = !this.isCarnivorous;
    }
    
}
