package ejercicio_2;

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
        return (float) (Math.PI * Math.pow(radius,2));
    }
    
    @Override
    public String imprimirInformacion() {
        return "Radio: " + this.radius + ", Area: " + this.calculateArea();
    }
    
}
