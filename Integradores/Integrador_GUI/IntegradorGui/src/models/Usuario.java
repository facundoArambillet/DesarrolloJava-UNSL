package models;

public class Usuario {
    private String idUsuario;
    private String contrasenia;
    private UsuarioTipo tipoUsuario;

    public Usuario() {
    }
    
    
    public Usuario(String idUsuario, String contrasenia, UsuarioTipo tipoUsuario) {
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public UsuarioTipo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioTipo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

