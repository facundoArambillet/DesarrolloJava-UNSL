package models;

public class Profesor {
    private int idProfesor;
    private String nombre;
    private String apellido;
    private long cuil;
    private long telefono;
    private String email;
    private ProfesorTipo tipoProfesor;
    private Usuario usuario;
    
    public Profesor() {
    }

    public Profesor(String nombre, String apellido, long cuil, long telefono, String email,
            ProfesorTipo tipoProfesor, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.telefono = telefono;
        this.email = email;
        this.tipoProfesor = tipoProfesor;
        this.usuario = usuario;
    }

    public int getId() {
        return this.idProfesor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public long getCuil() {
        return this.cuil;
    }

    public long getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public ProfesorTipo getTipoProfesor() {
        return this.tipoProfesor;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setId(int id) {
        this.idProfesor = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipoProfesor(ProfesorTipo profesorTipo) {
        this.tipoProfesor = profesorTipo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
