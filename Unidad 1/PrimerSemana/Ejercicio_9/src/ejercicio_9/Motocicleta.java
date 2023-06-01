package ejercicio_9;

public class Motocicleta extends Vehiculo{
    float engineDisplacement;
    
    public Motocicleta(String brand, String model, int year, float engineDisplacement) {
        super(brand, model, year);
        this.engineDisplacement = engineDisplacement;
    }
    
    @Override
    public String toString() {
        return "Marca: " + this.brand +
                ", Modelo: " + this.model + 
                ", Año: " + this.brand+ 
                ", Cilindrada: " + this.engineDisplacement + "Lts";
    }
}
