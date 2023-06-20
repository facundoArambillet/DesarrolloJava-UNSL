package ejercicio_6;

public class Mascot {
    private String name;
    private String breed;
    private String address;
    private int idOwner;
    
    public Mascot(String name, String breed, String address, int idOwner) {
        this.name = name;
        this.breed = breed;
        this.address = address;
        this.idOwner = idOwner;
    }
    
    public String getName() {
        return this.name;
    }
    public String getBreed() {
        return this.breed;
    }
    public String getAddress() {
        return this.address;
    }
    public int getIdOwner() {
        return this.idOwner;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    public void setBreed(String newBreed) {
        this.breed = newBreed;
    }
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
    public void setOwner(int newIdOwner) {
        this.idOwner = newIdOwner;
    }
    
    @Override
    public String toString() {
        return "Nombre : " + this.name + ", raza: " + this.breed + ", direccion: " + this.address + ", dni dueño: " + this.idOwner;
    }
    
}
