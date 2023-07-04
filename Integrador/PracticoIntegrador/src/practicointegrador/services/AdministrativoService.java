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
import practicointegrador.models.Administrativo;
import practicointegrador.models.CargoAdministrativo;

public abstract class AdministrativoService {
    
    private static List<Administrativo> administrativos = new ArrayList<>();
    
    public static String mostrarTodos() {
        if (administrativos.isEmpty()) {
            return "No hay administrativos registrados.";
            
        } else {
            String result = "";
            for (Administrativo administrativo : administrativos) {
                result += administrativo.mostrar() + "\n";
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
                if (linea.contains("ID administrativo: ")) {
                    //Salteo la parte ("ID estudiante: ") para que me quede solo el numero del id
                    contenido += linea.substring(19) + "\n";
                }
            }
            scan.close();
            if(contenido.equals("")) {
                return "No hay administrativos registrados";
            }
            else {
             return contenido;    
            }

        } catch (IOException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al buscar administrativo: " + ex.getMessage();
        }
    }
    
    public static Administrativo mostrarPorId(long id) {
        for (Administrativo admin : administrativos) {
            if (admin.getIdAdministrativo() == id) {
                return admin;
            }
        }

        return null;
    }
    
    public static List<Administrativo> mostrarPorCargo() {
        List<Administrativo> admins = new ArrayList<>();
        for(Administrativo admin : administrativos) {
            if(admin.getCargo().getType() == 'D') {
                admins.add(admin);
            }
        }
        return admins;
    }
    
    public static String crearAdministrativo(Administrativo newAdministrativo, String ruta) {
        File archivo = new File(ruta);
        FileWriter fileWriter;
        try {
            if (newAdministrativo.getCargo().getType() == 'A' || newAdministrativo.getCargo().getType() == 'D') {
                //El true hace que no se sobreescriba el archivo , sino que agregue una nueva linea
                fileWriter = new FileWriter(archivo, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                String content = newAdministrativo.mostrar();

                printWriter.println(content);
                printWriter.close();
                administrativos.add(newAdministrativo);
            } else {
                administrativos.add(newAdministrativo);
            }

            return "Administrativo creado exitosamente.";
        } catch (IOException ex) {
            //Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public static String actualizarAdministrativo(Administrativo newAdministrativo, long id, String ruta) {
        Administrativo infoAdministrativo = mostrarPorId(id);
        File archivo = new File(ruta);
        Scanner scan;
        FileWriter fileWriter;
        try {
            scan = new Scanner(archivo);
            List<String> lineas = new ArrayList<>();

            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (!linea.contains("ID administrativo: " + id)) {
                    lineas.add(linea);
                }
            }

            fileWriter = new FileWriter(archivo);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            if (infoAdministrativo != null) {
                infoAdministrativo.setNombre(newAdministrativo.getNombre());
                infoAdministrativo.setEdad(newAdministrativo.getEdad());
                infoAdministrativo.setGenero(newAdministrativo.getGenero());
                infoAdministrativo.setCargo(newAdministrativo.getCargo());
                String administrativoActualizado = "ID administrativo: " + id + ", " + infoAdministrativo.getNombre() + ", " + infoAdministrativo.getEdad() +
                        ", " + infoAdministrativo.getGenero() + ", " + infoAdministrativo.getCargo().mostrar();

                for (String lin : lineas) {
                    printWriter.println(lin);
                }
                
                printWriter.println(administrativoActualizado);
                
                scan.close();
                printWriter.close();
                fileWriter.close();

                return "Administrativo actualizado exitosamente.";
            }

        } catch (FileNotFoundException ex) {
            // Logger.getLogger(AdministrativoService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al leer el archivo";
        } catch (IOException ex) {
            // Logger.getLogger(AdministrativoService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al escribir el archivo";
        }

        return "Administrativo no encontrado";
    }


    
    public static String eliminarAdministrativo(long id, String ruta) {
    Administrativo infoAdministrativo = mostrarPorId(id);
    File archivo = new File(ruta);
    if (infoAdministrativo != null) {
        try {
            List<String> lineas = new ArrayList<>();
            Scanner scan = new Scanner(archivo);
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (!linea.contains("ID administrativo: " + id)) {
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
                printWriter.close();
                fileWriter.close();
                Administrativo adminEliminar;
                for(Administrativo admin : administrativos) {
                    if(admin.getIdAdministrativo() == id) {
                      adminEliminar = admin;
                      administrativos.remove(adminEliminar);
                      break;
                    }
                }
                return "Administrativo eliminado exitosamente.";

            } catch (IOException ex) {
                // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
               return "Error al eliminar el administrativo.";
            }

        } catch (FileNotFoundException ex) {
            // Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al encontrar el archivo.";
        }
        
    }
    else {
        return "Administrativo no encontrado.";
    }
    }
    
    public static String modificarDatos(String ruta) {
        File archivo = new File(ruta);
        FileWriter fileWriter;
        Scanner scan;
        PrintWriter printWriter;
        try {
            scan = new Scanner(archivo);

            List<Administrativo> adminsCargoD = mostrarPorCargo();
            
            if(!adminsCargoD.isEmpty()) {
                List<String> lineas = new ArrayList<>();
                while (scan.hasNextLine()) {
                    String linea = scan.nextLine();
                    String lineaSinEspacios = linea.replaceAll("\\s","");
                    String[] contenido = lineaSinEspacios.split(",");
                    
                    //Comparo el ultimo atributo con el tipo de cargo que debo eliminar
                    if(!contenido[contenido.length - 1].equals("D")) {
                        lineas.add(linea);
                    }
                }
                fileWriter = new FileWriter(archivo);
                printWriter = new PrintWriter(fileWriter);
                for (String linea : lineas) {
                    printWriter.println(linea);
                }
                
                administrativos.removeAll(adminsCargoD);
                
                printWriter.close();
                fileWriter.close();
                return "Administrativos con cargo 'D' eliminados con exito";
            }
            else {
                return "No hay Administrativos con cargo 'D' registrados";
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(AdministrativoService.class.getName()).log(Level.SEVERE, null, ex);
            return "Archivo no encontrado";
            
        } catch (IOException ex) {
            //Logger.getLogger(AdministrativoService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al escribir el archivo";
        }

    }
    
    public static void cargarAdministrativos(String ruta) {
        administrativos = new ArrayList<>();
        try {
            File archivo = new File(ruta);
            Scanner scan = new Scanner(archivo);
            if(scan != null) {
            String contenido = "";
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.contains("ID administrativo: ")) {
                    //Salteo la parte ("ID administrativo: ") para que me quede solo el numero del id
                    contenido = linea.substring(19);
                    String contenidoSinEspacio = contenido.replaceAll("\\s", "");
                    String[] atributos = contenidoSinEspacio.split(",");

                    //long idAdministrativo = Long.parseLong(atributos[0]);
                    String nombreAdministrativo = atributos[1];
                    int edadAdministrativo = Integer.parseInt(atributos[2]);
                    char generoAdministrativo = atributos[3].charAt(0);
                    
                    long idCargoAdministrativo = Long.parseLong(atributos[4]);
                    char tipoCargoAdministrativo = atributos[5].charAt(0);
                    
                    CargoAdministrativo cargo = new CargoAdministrativo(idCargoAdministrativo,tipoCargoAdministrativo);
                    Administrativo administrativo = new Administrativo(/*idAdministrativo,*/nombreAdministrativo,edadAdministrativo,
                    generoAdministrativo,cargo);
                    
                    administrativos.add(administrativo);
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
