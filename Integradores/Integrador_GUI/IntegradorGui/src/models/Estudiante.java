package models;
import java.sql.Blob;

public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private long dni;
    private long telefono;
    private String email;
    private byte[] foto;
    private Usuario usuario;
    private TutorEstudiante tutor;
    private Curso curso;
    
    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, long dni, long telefono, String email,
            byte[] foto, Usuario usuario, TutorEstudiante tutor, Curso curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
        this.usuario = usuario;
        this.tutor = tutor;
        this.curso = curso;
    }
    public Estudiante(String nombre, String apellido, long dni, long telefono, String email,
            Usuario usuario, TutorEstudiante tutor, Curso curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.foto = null;
        this.usuario = usuario;
        this.tutor = tutor;
        this.curso = curso;
    }
   
    
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TutorEstudiante getTutor() {
        return tutor;
    }

    public void setTutor(TutorEstudiante tutor) {
        this.tutor = tutor;
    }
    
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
