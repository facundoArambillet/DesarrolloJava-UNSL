package practicointegrador.models;

public class Estudiante extends Persona implements Mostrable{
    private static long counter = 0;
    private long idEstudiante;
    private ModalidadEstudiante modalidad;
    
    public Estudiante(String nombre, int edad, char genero,ModalidadEstudiante modalidad) {
        super(nombre,edad,genero);
        this.idEstudiante = ++counter;
        this.modalidad = modalidad;
    }
    
    public long getIdEstudiante() {
        return this.idEstudiante;
    }
    public ModalidadEstudiante getModalidad() {
        return this.modalidad;
    }
    
    public void setModalidad(ModalidadEstudiante newModalidad) {
        this.modalidad = newModalidad;
    }

    @Override
    public String mostrar() {
        return "ID estudiante: "+ this.idEstudiante +", " + this.nombre + ", " + this.edad +", " + this.genero + ", " + this.modalidad.mostrar();
    }
}
