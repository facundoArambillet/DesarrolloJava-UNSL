package practicointegrador.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import practicointegrador.models.EspecialidadProfesor;

public abstract class EspecialidadProfesorService {
   private static List<EspecialidadProfesor> especialidades = new ArrayList<>();
    
    public static void crearEspecialidad(EspecialidadProfesor newEspecialidad) {
        for(EspecialidadProfesor especialidad : especialidades) {
            if(especialidad.getType().equals(newEspecialidad.getType())) {
                especialidades.add(newEspecialidad);
            }
        }

    }
    public static List<EspecialidadProfesor> mostrarEspecialidades() {
        return especialidades;
    }
    public static void cargarEspecialidades(String ruta) {
        File archivo = new File(ruta);
        Scanner scan;

        try {
            scan = new Scanner(archivo);
            if(scan != null) { 
                while(scan.hasNextLine()) {
                    String linea = scan.nextLine();
                    if(linea.contains("ID profesor: ")) {
                        String lineaSinEspacios = linea.replaceAll("\\s", "");
                        String[] contenido = lineaSinEspacios.split(",");
                        String tipoEspecialidad = contenido[7];
                        if(especialidades.size() != 0) {
                            for(EspecialidadProfesor especialidadProfe : especialidades) {
                                if(!especialidadProfe.getType().equals(tipoEspecialidad)) {
                                    EspecialidadProfesor especialidad = new EspecialidadProfesor(tipoEspecialidad);
                                    especialidades.add(especialidad);  
                                }
                            }  
                        }
                        else {
                            EspecialidadProfesor cargo = new EspecialidadProfesor(tipoEspecialidad);
                            especialidades.add(cargo);  
                        }
                        EspecialidadProfesor especialidad = new EspecialidadProfesor(tipoEspecialidad);
                        especialidades.add(especialidad);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(EspecialidadProfesorService.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("archivo no encontrado");
        }         
    }
    
}
