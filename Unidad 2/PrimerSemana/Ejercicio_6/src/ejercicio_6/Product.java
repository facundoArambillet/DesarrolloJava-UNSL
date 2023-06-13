package ejercicio_6;

public class Product {
    private String name;
    private float unitPrice;
    private int stock;
    
    public Product(String name, float unitPrice, int stock) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }
    
    public String getName() {
        return this.name;
    }
    public float getUnitPrice() {
        return this.unitPrice;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setUnitPrice(float newPrice) {
        this.unitPrice = newPrice;
    }
    public void setStock(int newStock) {
        if(newStock < 0) {
            this.stock = 0;
        }
        else {
            this.stock = newStock;
        }
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.name + ", Precio: " + this.unitPrice + ", Stock: " + this.stock;
    }

}
