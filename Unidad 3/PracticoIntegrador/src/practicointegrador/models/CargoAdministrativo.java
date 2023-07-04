package practicointegrador.models;

public class CargoAdministrativo implements Mostrable{
    private static long idCounter = 0;
    private long idAdministrativeCharge;
    private char type;
    
    public CargoAdministrativo(char type) {
        this.idAdministrativeCharge = ++idCounter;
        this.type = type;
    }
    
    public CargoAdministrativo(long idAdministrativeCharge,char type) {
        this.idAdministrativeCharge = idAdministrativeCharge;
        this.type = type;
    }
    
    public long getIdAdministrativeCharge() {
        return this.idAdministrativeCharge;
    }
    public char getType() {
        return this.type;
    }
    
    public void setType(char newType) {
        this.type = newType;
    }
    
    @Override
    public String mostrar() {
        return this.idAdministrativeCharge + ", " + String.valueOf(this.type);
    }
    
}
