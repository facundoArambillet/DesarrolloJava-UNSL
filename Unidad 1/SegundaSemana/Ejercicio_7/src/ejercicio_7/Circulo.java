package ejercicio_7;

public class Circulo extends FiguraGeometrica{
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
    //El perimetro de un circulo de calcula 2 * pi * radio
    //PI es un metodo del objeto Math(Objecto que ya nos ofrece el JDK por defecto)
    @Override
    public float calculatePerimeter() {
        return (float) (2 * Math.PI * this.radius);
    }
    //El area de un circulo se calcula pi * r^2
    //Al igual que PI pow es otro metodo del objecto Math que nos sirve para calcular
    //La potencia de un numero
    @Override
    public float calculateArea() {
        return (float) (Math.PI * Math.pow(this.radius, 2));
    }
    
}
