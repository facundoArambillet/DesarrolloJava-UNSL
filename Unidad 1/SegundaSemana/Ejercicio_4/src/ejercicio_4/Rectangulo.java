package ejercicio_4;

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
        float area = this.base * this.height;
        return area;
    }
    //Lo defino pero no lo utilizo
    @Override
    public void draw() {
    }
    
}
