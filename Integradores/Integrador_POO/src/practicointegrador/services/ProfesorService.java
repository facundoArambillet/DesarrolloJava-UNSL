package practicointegrador.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import practicointegrador.models.EspecialidadProfesor;
import practicointegrador.models.Profesor;

public abstract class ProfesorService {
    
    private static List<Profesor> profesores = new ArrayList<>();
    
    public static String mostrarTodos() {
        if (profesores.isEmpty()) {
            
            return "No hay profesores registrados.";
            
        } else {

            String result = "";
            for (Profesor profesor : profesores) {
                result += profesor.mostrar() + "\n";
            }
            return result;
        }
    }
    
    public static String mostrarTodosTxt(String ruta) {
        try {
            File file = new File(ruta);
            Scanner scan = new Scanner(file);
            String contenido = "";
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.contains("ID profesor: ")) {
                    //Salteo la parte ("ID profesor: ") para que me quede solo el numero del id
                    contenido += linea.substring(13) + "\n";
                }
            }
            //System.out.println(content);
            scan.close();
            if(contenido.equals("")) {
                return "No hay profesores registrados";
            }
            else {
             return contenido;    
            }

        } catch (IOException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al buscar profesor: " + ex.getMessage();
        }
    }
    
    public static Profesor mostrarPorId(long id) {
        for (Profesor profesor : profesores) {
            if (profesor.getIdProfesor() == id) {
                return profesor;
            }
        }
        return null;
    }

    public static String crearProfesor(Profesor newProfesor,String ruta) {
        File archivo = new File(ruta);
        FileWriter fileWriter;
        try {
            if(newProfesor.getEspecialidad().getType().equals("Programador")) {
                //El true hace que no se sobreescriba el archivo , sino que agregue una nueva linea
                fileWriter = new FileWriter(archivo,true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                String contenido = newProfesor.mostrar();

                printWriter.println(contenido);
                printWriter.close();
                profesores.add(newProfesor);
            }
            else {
                profesores.add(newProfesor);
            }
           
            return "Profesor creado exitosamente.";
        } catch (IOException ex) {
            //Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String actualizarProfesor(Profesor newProfesor , long id,String ruta) {
        Profesor infoProfesor = mostrarPorId(id);
        File archivo = new File(ruta);
        Scanner scan;
        FileWriter fileWriter;
        try {
            scan = new Scanner(archivo);
            List<String> lineas = new ArrayList<>();

            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (!linea.contains("ID profesor: " + id)) {
                    lineas.add(linea);
                }
            }

            fileWriter = new FileWriter(archivo);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            if (infoProfesor != null) {
                infoProfesor.setNombre(newProfesor.getNombre());
                infoProfesor.setEdad(newProfesor.getEdad());
                infoProfesor.setGenero(newProfesor.getGenero());
                infoProfesor.setEspecialidad(newProfesor.getEspecialidad());
                String profesorActualizado = "ID profesor: " + id + ", " + infoProfesor.getNombre() + ", " + infoProfesor.getEdad() +
                        ", " + infoProfesor.getGenero() + ", " + infoProfesor.getEspecialidad().mostrar();

                for (String lin : lineas) {
                    printWriter.println(lin);
                }
                
                printWriter.println(profesorActualizado);
                
                scan.close();
                printWriter.close();
                fileWriter.close();

                return "Profesor actualizado exitosamente.";
            }

        } catch (FileNotFoundException ex) {
            // Logger.getLogger(AdministrativoService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al leer el archivo";
        } catch (IOException ex) {
            // Logger.getLogger(AdministrativoService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al escribir el archivo";
        }

        return "Profesor no encontrado";
    }
    
    public static String eliminarProfesor(long id, String ruta) {
    Profesor infoProfesor = mostrarPorId(id);
    File file = new File(ruta);
    if (infoProfesor != null) {
        try {
            List<String> lineas = new ArrayList<>();
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (!linea.contains("ID profesor: " + id)) {
                    lineas.add(linea);
                }
            }

            FileWriter fileWriter;
            PrintWriter printWriter;
            try {
                fileWriter = new FileWriter(file);
                printWriter = new PrintWriter(fileWriter);
                for (String linea : lineas) {
                    printWriter.println(linea);
                }
                Profesor profesorEliminar;
                for(Profesor profesor : profesores) {
                    if(profesor.getIdProfesor() == id) {
                      profesorEliminar = profesor;
                      profesores.remove(profesorEliminar);
                      break;
                    }
                }
                printWriter.close();
                fileWriter.close();
                
                return "Profesor eliminado exitosamente.";

            } catch (IOException ex) {
                // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
                return "Error al eliminar el profesor.";
            }

        } catch (FileNotFoundException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al encontrar el archivo.";
        }     
        
    } else {
        return "Profesor no encontrado.";
        }
    }
    
    public static String modificarSueldo() {
        int contadorProfesores = 0;
        for(Profesor profesor : profesores) {
            if(profesor.getAntiguedad() >= 12) {
                profesor.modificarSueldoProfesor();
                contadorProfesores++;
            }
        }
        return "El sueldo de: " + contadorProfesores +", a sido aumentado un 31.5%";
    }
    
    public static void cargarProfesores(String ruta) {
        profesores = new ArrayList<>();
        try {
            File archivo = new File(ruta);
            Scanner scan = new Scanner(archivo);
            if(scan != null) {
                String contenido = "";
                while (scan.hasNextLine()) {
                    String linea = scan.nextLine();
                    if (linea.contains("ID profesor: ")) {
                        //Salteo la parte ("ID estudiante: ") para que me quede solo el numero del id
                        contenido = linea.substring(13);
                        String contenidoSinEspacio = contenido.replaceAll("\\s", "");
                        String[] atributos = contenidoSinEspacio.split(",");

                        long idProfesor = Long.parseLong(atributos[0]);
                        String nombreProfesor = atributos[1];
                        int edadProfesor = Integer.parseInt(atributos[2]);
                        char generoProfesor = atributos[3].charAt(0);
                        double salarioProfesor = Double.parseDouble(atributos[4]);
                        short antiguedadProfesor = Short.parseShort(atributos[5]);
                        long idEspecialidadProfesor = Long.parseLong(atributos[6]);
                        String tipoEspecialidadProfesor = atributos[7];

                        EspecialidadProfesor especialidad = new EspecialidadProfesor(tipoEspecialidadProfesor);
                        Profesor profesor = new Profesor(nombreProfesor,edadProfesor,
                        generoProfesor,salarioProfesor,antiguedadProfesor,especialidad);

                        profesores.add(profesor);
                    }
                }
                scan.close();  
            }

        } catch (IOException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
           //System.out.println("Archivo no encontrado");
        }
    }
}
