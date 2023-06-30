package ejercicio_5;

public class Product {
    private String name;
    private float price;
    private int stock;
    
    public Product(String name,float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public String getName() {
        return this.name;
    }
    public float getPrice() {
        return this.price;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setPrice(float newPrice) {
        this.price = newPrice;
    }
    public void setStock(int newStock) {
        this.stock = newStock;
    }
}
