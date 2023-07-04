package practicointegrador.models;

public class ModalidadEstudiante  implements Mostrable{
    private static long idCounter = 0;
    private long idModality;
    private String type;
    
    public ModalidadEstudiante(String type) {
        this.idModality = ++idCounter;
        this.type = type;
    }
    public ModalidadEstudiante(long idModality,String type) {
        this.idModality = idModality;
        this.type = type;
    }
    public long getIdModality() {
        return this.idModality;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType() {
        
    }

    @Override
    public String mostrar() {
        return this.idModality + ", " + this.type;
    }
}
