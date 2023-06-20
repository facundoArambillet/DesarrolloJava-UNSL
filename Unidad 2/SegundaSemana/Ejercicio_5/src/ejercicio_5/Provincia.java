package ejercicio_5;

public class Provincia {
    private String name;
    private float squareKilometers;
    
    public Provincia(String name, float squareKilometers) {
        this.name= name;
        this.squareKilometers = squareKilometers;
    }
    
    public String getName() {
        return this.name;
    }
    public float getSquareKilometers() {
        return this.squareKilometers;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setSquareKilometers(float newKilometers) {
        this.squareKilometers = newKilometers;
    }
}
