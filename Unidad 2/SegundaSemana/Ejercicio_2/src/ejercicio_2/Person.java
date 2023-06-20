package ejercicio_2;

public class Person {
    private String name;
    private byte age;
    
    public Person(String name, byte age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    public byte getAge() {
        return this.age;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(byte newAge) {
        this.age = newAge;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.name + ", edad: " + this.age;
    }
}
