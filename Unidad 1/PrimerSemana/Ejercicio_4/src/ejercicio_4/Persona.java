package ejercicio_4;

public class Persona {
    private String name;
    private int age;
    private float height;
       
    public Persona(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public float getHeight() {
        return this.height;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }
    public void setHeight(float newHeight) {
        this.height = newHeight;
    }
    
    public String printInfo() {
        return "Nombre: " + this.name + " Edad: " + this.age + " Altura: " + this.height;
    }
    
}
