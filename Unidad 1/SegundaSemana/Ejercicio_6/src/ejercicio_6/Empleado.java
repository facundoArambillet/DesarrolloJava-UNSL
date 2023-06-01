package ejercicio_6;

public class Empleado {
    private String name;
    private byte age;
    private float salary;
    
    public Empleado(String name, byte age) {
        this.name = name;
        this.age = age;
        this.salary = -1;
    }
    
    public Empleado(String name, byte age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public String getName() {
        return this.name;
    }
    public byte getAge() {
        return this.age;
    }
    //Podria hacer que el metodo devuelva un string y escribir una condicion para que me devuelva una respuesta
    //Adecuada cuando el salario es -1, pero por fines practicos lo dejo como esta
    public float getSalary() {
        return this.salary;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(byte newAge) {
        this.age = newAge;
    }
    public void setSalary(float newSalary) {
        this.salary = newSalary;
    }
    
    public String printData() {
        //Si el salario es -1(defini este valor arriba del todo) significa que se creo con el primer constructor(Que no tiene salario)
        //Por lo que muestro unicamente nombre y edad
        if(this.salary == -1) {
            return "Nombre: " + this.name + ", Edad: " + this.age;
        }
        //Sino muestro todos los atributos
        else {
            return "Nombre: " + this.name + ", Edad: " + this.age + ", Salario: " + this.salary;
        }
    }
}
