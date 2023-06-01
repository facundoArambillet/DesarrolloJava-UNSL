package ejercicio_4;

public class Circulo extends Figura{
    private float radius;
    
    public Circulo(float radius) {
        this.radius = radius;
    }
    
    public float getRadius() {
        return this.radius;
    }
    
    public void setRadius(float newRadius) {
        this.radius = newRadius;
    }
    
    @Override
    public float calculateArea() {
        float area = (float) (Math.PI * Math.pow(radius,2));
        return area;
    }
    //Lo defino pero no lo utilizo
    @Override
    public void draw() {
    }
    
}
