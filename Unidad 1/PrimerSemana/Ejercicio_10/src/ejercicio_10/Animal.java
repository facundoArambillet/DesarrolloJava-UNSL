package ejercicio_10;

public abstract class Animal {
    protected String name;
    protected byte age;
    
    public Animal(String name, byte age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    public byte getAge() {
        return this.age;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    public void setAge(byte newAge){
        this.age = newAge;
    }
}
