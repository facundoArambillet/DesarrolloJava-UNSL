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
import practicointegrador.models.Estudiante;
import practicointegrador.models.ModalidadEstudiante;

public abstract class EstudianteService {
    
    private static List<Estudiante> estudiantes = new ArrayList<>();
    
    public static String mostrarTodos() {
        if (estudiantes.isEmpty()) {
            
            return "No hay estudiantes registrados.";
            
        } else {

            String result = "";
            for (Estudiante estudiante : estudiantes) {
                result += estudiante.mostrar() + "\n";
            }
            return result;
        }
    }
    
    public static String mostrarTodosTxt(String ruta) {
        try {
            File archivo = new File(ruta);
            Scanner scan = new Scanner(archivo);
            String contenido = "";
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.contains("ID estudiante: ")) {
                    //Salteo la parte ("ID estudiante: ") para que me quede solo el numero del id
                    contenido += linea.substring(14) + "\n";
                }
            }
            scan.close();
            if(contenido.equalsIgnoreCase("")) {
                return "No hay estudiantes registrados";
            }
            else {
             return contenido;    
            }

        } catch (IOException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al buscar estudiante: " + ex.getMessage();
        }
    }
    
    public static Estudiante mostrarPorId(long id, String ruta) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getIdEstudiante() == id) {
                    return estudiante;
                }
        }

        return null;
    }

    public static String crearEstudiante(Estudiante newEstudiante,String ruta) {
        File archivo = new File(ruta);
        FileWriter fileWriter;
        try {
            if(newEstudiante.getModalidad().getType().equals("Tecnología e Informatica")) {
                //El true hace que no se sobreescriba el archivo , sino que agregue una nueva linea
                fileWriter = new FileWriter(archivo,true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                String contenido = newEstudiante.mostrar();

                printWriter.println(contenido);
                printWriter.close();
                estudiantes.add(newEstudiante);
            }
            else {
                estudiantes.add(newEstudiante);
            }
            return "Estudiante creado exitosamente.";
        } catch (IOException ex) {
            //Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            //return "Error al crear el estudiante: " + ex.getMessage();
            return null;
        }
    }

    public static String actualizarEstudiante(Estudiante newEstudiante , long id,String ruta) {
        Estudiante infoEstudiante = mostrarPorId(id,ruta);
        File archivo = new File(ruta);
        try {
            Scanner scan = new Scanner(archivo);
            if(infoEstudiante != null) {
                infoEstudiante.setNombre(newEstudiante.getNombre());
                infoEstudiante.setEdad(newEstudiante.getEdad());
                infoEstudiante.setGenero(newEstudiante.getGenero());
                infoEstudiante.setModalidad(newEstudiante.getModalidad());
                String estudianteActualizado = "ID estudiante: " + id + ", " + infoEstudiante.getNombre() + ", " + infoEstudiante.getEdad() + ", " +
                        infoEstudiante.getGenero() + ", " + infoEstudiante.getModalidad().mostrar();
                
                while(scan.hasNextLine()) {
                    String linea = scan.nextLine();
                    if(linea.contains("ID estudiante: " + id)) {
                        FileWriter fileWriter;
                        try {
                            fileWriter = new FileWriter(archivo);
                            PrintWriter printWriter = new PrintWriter(fileWriter);
                            printWriter.println(estudianteActualizado);
                            while (scan.hasNextLine()) {
                                printWriter.println(scan.nextLine());
                            }
                            scan.close();
                            printWriter.close();
                            fileWriter.close();
                            
                            return "Estudiante actualizado exitosamente."; 
                            
                        } catch (IOException ex) {
                           // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
                           return "Error al actualizar el estudiante.";
                        }
                    }
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al encontrar el archivo.";
        }
        
        return "Estudiante no encontrado.";
    }
    
    public static String eliminarEstudiante(long id, String ruta) {
    Estudiante infoEstudiante = mostrarPorId(id, ruta);
    File archivo = new File(ruta);
    if (infoEstudiante != null) {
        try {
            List<String> lineas = new ArrayList<>();
            Scanner scan = new Scanner(archivo);
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (!linea.contains("ID estudiante: " + id)) {
                    lineas.add(linea);
                }
            }

            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(archivo);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (String linea : lineas) {
                    printWriter.println(linea);
                }
                Estudiante estudianteEliminar;
                for(Estudiante estudiante : estudiantes) {
                    if(estudiante.getIdEstudiante() == id) {
                      estudianteEliminar = estudiante;
                      estudiantes.remove(estudianteEliminar);
                      break;
                    }
                }
                printWriter.close();
                fileWriter.close();
                
                return "Estudiante eliminado exitosamente.";

            } catch (IOException ex) {
                // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
                return "Error al eliminar el estudiante.";
            }
            
            
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al encontrar el archivo.";
        }
    } else {
        return "Estudiante no encontrado.";
    }
    }
    
    public static void cargarEstudiantes(String ruta) {
        try {
            estudiantes = new ArrayList<>();
            File archivo = new File(ruta);
            Scanner scan = new Scanner(archivo);
            if(scan != null) {
            String contenido = "";
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.contains("ID estudiante: ")) {
                    //Salteo la parte ("ID estudiante: ") para que me quede solo el numero del id
                    contenido = linea.substring(14);
                    String contenidoSinEspacio = contenido.replaceAll("\\s", "");
                    String[] atributos = contenidoSinEspacio.split(",");
                    long idEstudiante = Long.parseLong(atributos[0]);
                    String nombreEstudiante = atributos[1];
                    int edadEstudiante = Integer.parseInt(atributos[2]);
                    char generoEstudiante = atributos[3].charAt(0);
                    
                    long idModalidadEstudiante = Long.parseLong(atributos[4]);
                    String tipoModalidadEstudiante = atributos[5];
                    
                    ModalidadEstudiante modalidad = new ModalidadEstudiante(tipoModalidadEstudiante);
                    Estudiante estudiante = new Estudiante(nombreEstudiante,edadEstudiante,
                    generoEstudiante,modalidad);
                    
                    estudiantes.add(estudiante);
                }
            }
            scan.close();  
            }

        } catch (IOException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
          // System.out.println("Archivo no encontrado");
        }
    }
}
