package practicointegrador.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import practicointegrador.models.CargoAdministrativo;

public abstract class CargoAdministrativoService {
   private static List<CargoAdministrativo> cargos = new ArrayList<>();
    
    public static void crearCargo(CargoAdministrativo newCargo) {
        for(CargoAdministrativo cargo : cargos) {
            if(cargo.getType() != newCargo.getType()) {
                cargos.add(newCargo);  
                break;
            }
        }
    }

    public static List<CargoAdministrativo> mostrarCargos() {
        return cargos;
    }
    public static void cargarCargos(String ruta) {
        File archivo = new File(ruta);
        Scanner scan;

        try {
            scan = new Scanner(archivo);
            if(scan != null) { 
                while(scan.hasNextLine()) {
                    String linea = scan.nextLine();
                    if(linea.contains("ID administrativo: ")) {
                        String lineaSinEspacios = linea.replaceAll("\\s", "");
                        String[] contenido = lineaSinEspacios.split(",");
                        char tipoCargo = contenido[5].charAt(0);
                        if(cargos.size() != 0) {
                            for(CargoAdministrativo carg : cargos) {
                                if(carg.getType() != tipoCargo) {
                                    CargoAdministrativo cargo = new CargoAdministrativo(tipoCargo);
                                    cargos.add(cargo);  
                                }
                            }  
                        }
                        else {
                            CargoAdministrativo cargo = new CargoAdministrativo(tipoCargo);
                            cargos.add(cargo);  
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(EspecialidadProfesorService.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Archivo no encontrado");
        }         
    }
}
