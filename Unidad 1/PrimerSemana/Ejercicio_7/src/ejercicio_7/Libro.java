package ejercicio_7;

public class Libro {
    private String title;
    private String author;
    private float price;
    
    public Libro(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public float getPrice() {
        return this.price;
    }
    
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }
    public void setPrice(float newPrice) {
        this.price = newPrice;
    }
    
    public float discount(float percentage) {
        return this.price * (1- percentage);
    }
    
    @Override
    public String toString() {
        return "Titulo: " + this.title + ", Autor: " + this.author + ", Precio: " + this.price;
    }
    
}
