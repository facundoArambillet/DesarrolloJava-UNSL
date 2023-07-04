package practicointegrador.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import practicointegrador.models.ModalidadEstudiante;

public abstract class ModalidadEstudianteService {
   private static List<ModalidadEstudiante> modalidades = new ArrayList<>();
    
    public static void crearModalidad(ModalidadEstudiante newModalidad) {
        for(ModalidadEstudiante modalidad : modalidades) {
            if(modalidad.getType().equals(newModalidad.getType())) {
                modalidades.add(newModalidad);
            }
        }
    }
    public static List<ModalidadEstudiante> mostrarModalidades() {
        return modalidades;
    }
    public static void cargarModalidades(String ruta) {
        File archivo = new File(ruta);
        Scanner scan;

        try {
            scan = new Scanner(archivo);
            if(scan != null) { 
                while(scan.hasNextLine()) {
                    String linea = scan.nextLine();
                    if(linea.contains("ID estudiante: ")) {
                        String lineaSinEspacios = linea.replaceAll("\\s", "");
                        String[] contenido = lineaSinEspacios.split(",");
                        String tipoModalidad = contenido[5];
                        if(modalidades.size() != 0) {
                            for(ModalidadEstudiante modalidadEstudiante : modalidades) {
                                if(!modalidadEstudiante.getType().equals(tipoModalidad)) {
                                    ModalidadEstudiante cargo = new ModalidadEstudiante(tipoModalidad);
                                    modalidades.add(cargo);  
                                }
                            }  
                        }
                        else {
                            ModalidadEstudiante cargo = new ModalidadEstudiante(tipoModalidad);
                            modalidades.add(cargo);  
                        }
                        ModalidadEstudiante modalidad = new ModalidadEstudiante(tipoModalidad);
                        modalidades.add(modalidad);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(EspecialidadProfesorService.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Archivo no encontrado");
        }         
    }
}
