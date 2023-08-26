package practicointegrador.models;

public class Profesor extends Persona implements Mostrable{
    private static long idCounter = 0;
    private long idProfesor;
    private double salario;
    private short antiguedad;
    private EspecialidadProfesor especialidad;
    
    public Profesor(String nombre, int edad, char genero, double salario, short antiguedad, EspecialidadProfesor especialidad) {
        super(nombre,edad,genero);
        this.idProfesor = ++idCounter;
        this.especialidad = especialidad;
        this.salario = salario;
        this.antiguedad = antiguedad;
    }
    
    public long getIdProfesor() {
        return this.idProfesor;
    }
    public EspecialidadProfesor getEspecialidad() {
        return this.especialidad;
    }
    public double getSalario() {
        return this.salario;
    }
    public short getAntiguedad() {
        return this.antiguedad;
    }
    
    public void setEspecialidad(EspecialidadProfesor newEspecialidad) {
        this.especialidad = newEspecialidad;
    }
    public void setSalario(double newSalario) {
        this.salario = newSalario;
    }
    public void setAntiguedad(short newAntiguedad) {
        this.antiguedad = newAntiguedad;
    }
    public void modificarSueldoProfesor() {
        this.salario *= 1.315;
    }

    @Override
    public String mostrar() {
        return "ID profesor: "+ this.idProfesor + ", " + this.nombre + ", " + this.edad +", " + this.genero + 
                 ", " + this.salario + ", " + this.antiguedad + ", " + this.especialidad.mostrar();
    }
}
