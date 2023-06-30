package ejercicio_5;

public class User {
    private String name;
    private byte age;
    private Product[] products;
    
    public User(String name, byte age, Product[] products) {
        this.name = name;
        this.age = age;
        this.products = products;
    }
    
    public String getName() {
        return this.name;
    }
    public byte getAge() {
        return this.age;
    }
    public Product[] getProducts() {
        return this.products;
    }
    public Product[] getProductsOrderByStock() {
        Product[] productsArray = this.products;
        for(int i = 0; i < this.products.length; i++) {
            for(int j = 0; j < this.products.length - i - 1; j++) {
                if(this.products[j].getStock() > this.products[j + 1].getStock()) {
                    Product aux = productsArray[j];
                    productsArray[j] = productsArray[j + 1];
                    productsArray[j + 1] = aux;
                } 
            }
        }
        return productsArray;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(byte newAge) {
        this.age = newAge;
    }
    public void setProducts(Product[] newProducts) {
        this.products = newProducts;
    }
}
