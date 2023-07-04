package practicointegrador.models;

public class Administrativo extends Persona implements Mostrable{
    private static long idCounter = 0;
    private long idAdministrativo;
    private CargoAdministrativo cargo;
    
    public Administrativo(String nombre, int edad, char genero, CargoAdministrativo cargo) {
        super(nombre,edad,genero);
        this.idAdministrativo = ++idCounter;
        this.cargo = cargo;
    }
    
    
    public long getIdAdministrativo() {
        return this.idAdministrativo;
    }
    public CargoAdministrativo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(CargoAdministrativo newCargo) {
        this.cargo = newCargo;
    }

    @Override
    public String mostrar() {
        return "ID administrativo: " + this.idAdministrativo + ", " + this.nombre + ", " + this.edad + ", " + 
                this.genero + ", " + this.cargo.mostrar();
    }
    
}
