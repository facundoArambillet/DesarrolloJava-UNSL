package models;

public class UsuarioTipo {
    private int idTipo;
    private String tipo;

    public UsuarioTipo() {
    }
    
    public UsuarioTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
