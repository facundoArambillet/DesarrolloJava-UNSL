package ejercicio_5;

public class Ciudadano {
    private int dni;
    private String name;
    private byte age;
    private Provincia province;
    
    public Ciudadano(int dni, String name, byte age, Provincia province) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.province = province;
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
    public Provincia getProvince() {
        return this.province;
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
    public void setProvince(Provincia newProvince) {
        this.province = newProvince;
    }
    
    @Override
    public String toString () {
        return "Dni: " + this.dni + ", nombre: " + this.name + ", edad: " + this.age + ", provincia: " + this.province.getName();
    }
}
