package practicointegrador.models;

public class EspecialidadProfesor implements Mostrable{
    private static long idCounter = 0;
    private long idSpecialty;
    private String type;
    
    public EspecialidadProfesor(String type) {
        this.idSpecialty = ++idCounter;
        this.type = type;
    }
    public EspecialidadProfesor(long idSpecialty,String type) {
        this.idSpecialty = idSpecialty;
        this.type = type;
    }
    public long getIdSpecialty() {
        return this.idSpecialty;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String newType) {
        this.type = newType;
    }

    @Override
    public String mostrar() {
        return this.idSpecialty + ", " + this.type;
    }
}
