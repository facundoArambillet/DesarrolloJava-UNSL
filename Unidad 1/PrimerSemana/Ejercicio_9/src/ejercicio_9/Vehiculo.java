package ejercicio_9;

public class Vehiculo {
    protected String brand;
    protected String model;
    protected int year;
    
    public Vehiculo(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    public String getBrand() {
        return this.brand;
    }
    public String getModel() {
        return this.model;
    }
    public int getYear() {
        return this.year;
    }
    
    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }
    public void setModel(String newModel) {
        this.model = newModel;
    }
    public void setYear(int newYear) {
        this.year = newYear;
    }
}
