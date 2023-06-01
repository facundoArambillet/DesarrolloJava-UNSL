package ejercicio_7;

public class Rectangulo extends FiguraGeometrica{
    private float lenght;
    private float width;
    
    public Rectangulo(float lenght, float width) {
        this.lenght = lenght;
        this.width = width;
    }
    
    public float getLength() {
        return this.lenght;
    }
    
    public float getWidth() {
        return this.width;
    }
    
    public void setLenght(float newLenght) {
        this.lenght = newLenght;
    }
    
    public void setWidth(float newWidth) {
        this.width = newWidth;
    }
    
    //El perimetro de un Rectangulo se calcula 2 * (Longitud + Ancho)
    @Override
    public float calculatePerimeter() {
        return 2 * (this.lenght + this.width);
    }
    //El area de un Rectangulo se calcula longitud por ancho
    @Override
    public float calculateArea() {
        return (this.lenght * this.width);
    }


    
}
