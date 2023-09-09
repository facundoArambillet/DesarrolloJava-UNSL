package models;

public class ProfesorTipo {
    private int idTipo;
    private String tipo;

    public ProfesorTipo() {
    }

    public ProfesorTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return this.idTipo;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setIdTipo(int id) {
        this.idTipo = id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
