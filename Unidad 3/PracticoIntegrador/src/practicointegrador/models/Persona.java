package practicointegrador.models;

public abstract class Persona{
    protected String nombre;
    protected int edad;
    protected char genero;
    
    public Persona(String nombre, int edad, char genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    public char getGenero() {
        return this.genero;
    }
    
    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }
    public void setEdad(int newEdad) {
        this.edad = newEdad;
    }
    public void setGenero(char newGenero) {
        this.genero = newGenero;
    }
    
}
