package ejercicio_7;

public class Player {
    private String name;
    private byte age;
    private short shirtNumber;
    
    public Player(String name, byte age, short shirtNumber) {
        this.name = name;
        this.age = age;
        this.shirtNumber = shirtNumber;
    }
    
    public String getName() {
        return this.name;
    }
    public byte getAge() {
        return this.age;
    }
    public short getShirtNumber() {
        return this.shirtNumber;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(byte newAge) {
        this.age = newAge;
    }
    public void setShirtNumer(short newShirtNumber) {
        this.shirtNumber = newShirtNumber;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.name + ", edad: " + this.age + ", numero de remera: " + this.shirtNumber;
    }
    
}
