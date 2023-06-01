package ejercicio_10;

public class Reptil extends Animal{
    private boolean isVenomous;
    
    public Reptil(String name, byte age, boolean isVenomous) {
        super(name, age);
        this.isVenomous = isVenomous;
    }
    
    public boolean isVenomous() {
        return this.isVenomous;
    }
    
    public void setIsVenomous() {
        this.isVenomous = !this.isVenomous;
    }
}
