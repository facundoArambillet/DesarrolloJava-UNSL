package ejercicio_10;

public class Ave extends Animal{
    private boolean canFly;
    
    public Ave(String name, byte age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }
    
    public boolean canFly() {
        return this.canFly;
    }
    
    public void setCanFly() {
        this.canFly = !this.canFly;
    }
    
}
