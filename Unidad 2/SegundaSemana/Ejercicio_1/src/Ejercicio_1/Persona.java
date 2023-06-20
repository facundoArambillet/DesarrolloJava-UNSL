package Ejercicio_1;

public class Persona implements Comparable<Persona>{
    private String nombre;
    private int edad;
    
    public Persona (String nombre, int edad){
    this.nombre=nombre;
    this.edad=edad;
    }
    
    public String getNombre() { return nombre;}
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    public int getEdad() { return edad;}
    public void setEdad(int edad) { this.edad = edad;}
        
    //Asi se me habia ocurrido sin implementar Comparable
    /*
    public int compareTo(Persona person) {
        if(this.edad > person.getEdad()) {
            return 1;
        }
        else if( this.edad == person.getEdad()) {
            return 0;
        }
        else {
            return -1;
        }
    }
    */
    //Sobreescribo el metodo compareTo con esto determino si una persona es menor que otra(Si da positivo es mayor si no es menor)
    @Override // metodo compareTo con primitivos
    public int compareTo (Persona person) {
        return this.edad - person.getEdad();
    }
   
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", edad: " + this.edad;
    }
    
}