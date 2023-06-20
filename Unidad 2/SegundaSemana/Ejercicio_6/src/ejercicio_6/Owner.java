package ejercicio_6;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private int dni;
    private String name;
    private byte age;
    private List<Mascot> mascots;
    
    public Owner(int dni, String name, byte age, List<Mascot> mascots) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.mascots = new ArrayList<>(mascots);
    }
    
    public int getDni() {
        return this.dni;
    }
    public String getName() {
        return this.name;
    }
    public byte getAge() {
        return this.age;
    }
    public List<Mascot> getMascots() {
        return this.mascots;
    }
    
    public void setDni(int newDni) {
        this.dni = newDni;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(byte newAge) {
        this.age = newAge;
    }
    public void setMascots(List<Mascot> newMascots) {
        this.mascots = newMascots;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.name + ", dni: " + this.dni + ", edad: " + this.age;
    }
}
