package ejercicio_2;

public class Rectangulo extends Figura{
    private float base;
    private float height;
    
    public Rectangulo(float base, float height) {
        this.base = base;
        this.height = height;
    }
    
    public float getBase() {
        return this.base;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    public void setBase(float newBase) {
        this.base = newBase;
    }
    
    public void setHeight(float newHeight) {
        this.height = newHeight;
    }
    
    @Override
    public float calculateArea() {
        return this.base * this.height;
    }

    @Override
    public String imprimirInformacion() {
        return "Base: " + this.base + ", Altura: " + this.height + ", Area: " + this.calculateArea();
    }
    
}
