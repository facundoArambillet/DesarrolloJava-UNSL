package ejercicio_4;

public class Cuadrado extends Figura{
    private float side;
    
    public Cuadrado(float side) {
        this.side = side;
    }
    
    public float getSide() {
        return this.side;
    }
    
    public void setSide(float newSide) {
        this.side = newSide;
    }
    
    @Override
    public float calculateArea() {
        float area = this.side * this.side;
        return area;
    }
    //Lo defino pero no lo utilizo
    @Override
    public void draw() {
    }
    
}
