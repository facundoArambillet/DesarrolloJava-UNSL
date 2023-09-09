package models;


public class Materia {
    private int idMateria;
    private String nombre;
    private Curso curso;

    public Materia() {
    }

    public Materia(String nombre,Curso curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}


