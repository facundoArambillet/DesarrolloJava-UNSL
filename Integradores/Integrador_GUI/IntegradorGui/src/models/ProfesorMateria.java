package models;

public class ProfesorMateria {
    private int idProfesor;
    private int idMateria;
    
    public ProfesorMateria() {
        
    }
    
    public ProfesorMateria(int idProfesor, int idMateria) {
        this.idProfesor = idProfesor;
        this.idMateria = idMateria;
    }
    public int getIdProfesor() {
        return this.idProfesor;
    }
    public int getIdMateria() {
        return this.idMateria;
    }
    
    public void setIdProfesor(int id) {
        this.idProfesor = id;
    }
    public void setIdMateria(int id) {
        this.idMateria = id;
    }
}
