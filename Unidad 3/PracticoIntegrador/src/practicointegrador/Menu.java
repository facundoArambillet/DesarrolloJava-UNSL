package practicointegrador;

import java.util.List;
import java.util.Scanner;
import practicointegrador.models.Administrativo;
import practicointegrador.models.CargoAdministrativo;
import practicointegrador.models.EspecialidadProfesor;
import practicointegrador.models.Estudiante;
import practicointegrador.models.ModalidadEstudiante;
import practicointegrador.models.Profesor;
import practicointegrador.services.AdministrativoService;
import practicointegrador.services.CargoAdministrativoService;
import practicointegrador.services.EspecialidadProfesorService;
import practicointegrador.services.EstudianteService;
import practicointegrador.services.ModalidadEstudianteService;
import practicointegrador.services.ProfesorService;

public abstract class Menu {
    
    private static Scanner  scan = new Scanner(System.in);
    private static String PATH = "C:\\Users\\Facundo\\Desktop\\DesarrolloJava\\Unidad 3\\Resources\\BackupInstitucion.txt";
    
    public static void menu() {
        AdministrativoService.cargarAdministrativos(PATH);
        ProfesorService.cargarProfesores(PATH);
        EstudianteService.cargarEstudiantes(PATH);
        CargoAdministrativoService.cargarCargos(PATH);
        EspecialidadProfesorService.cargarEspecialidades(PATH);
        ModalidadEstudianteService.cargarModalidades(PATH);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú Usuario ---");
            System.out.println("1. Mostrar Personas");
            System.out.println("2. Menu Administrativos");
            System.out.println("3. Menu Profesores");
            System.out.println("4. Menu Estudiantes");
            System.out.println("5. Salir");
            System.out.println("Ingrese la opción deseada: ");
            int option = scan.nextInt();
            scan.nextLine();
            switch(option) {
                case 1: 
                    System.out.println(mostrarTodasPersonas());
                    break;
                    
                case 2:
                    boolean exitAdministrative = false;
                    while (!exitAdministrative) {
                    System.out.println("\n--- Menú Administrativos ---");
                    System.out.println("1. Mostrar Administrativos");
                    System.out.println("2. Mostrar Administrativo");
                    System.out.println("3. Crear Administrativo");
                    System.out.println("4. Actualizar Administrativo");
                    System.out.println("5. Eliminar Administrativo");
                    System.out.println("6. Eliminar Categoria D");
                    System.out.println("7. Salir");
                    System.out.println("Ingrese la opción deseada: ");
                    int optionAdministrative = scan.nextInt();
                    scan.nextLine();
                    switch(optionAdministrative) {
                        case 1:
                            System.out.println(AdministrativoService.mostrarTodos());
                            break;
                        case 2:
                            System.out.println("Ingrese el id del administrativo: ");
                            long idAdmin = scan.nextLong();
                            scan.nextLine();
                            if(AdministrativoService.mostrarPorId(idAdmin) != null) {
                               System.out.println(AdministrativoService.mostrarPorId(idAdmin)); 
                            }
                            else {
                                System.out.println("No hay Administrativos registrados con ese ID.");
                            }
                            
                            break;
                        case 3:
                            System.out.println("Ingrese nombre: ");
                            String nombreAdministrativo = scan.nextLine();
                            System.out.println("Ingrese edad: ");
                            int edadAdministrativo = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Ingrese genero(M/F): ");
                            char generoAdministrativo = scan.nextLine().charAt(0);
                            System.out.println("Ingrese cargo: ");
                            char tipoCargo = scan.nextLine().charAt(0);
                            
                            CargoAdministrativo cargoAdministrativo = null;
                            List<CargoAdministrativo> cargos = CargoAdministrativoService.mostrarCargos();
                            for (CargoAdministrativo cargo : cargos) {
                                if (cargo.getType() == tipoCargo) {
                                   cargoAdministrativo = cargo;
                                   break;
                                }
                            }

                            if (cargoAdministrativo == null) {
                                cargoAdministrativo = new CargoAdministrativo(tipoCargo);
                                CargoAdministrativoService.crearCargo(cargoAdministrativo);
                            }

                            Administrativo administrativo = new Administrativo(nombreAdministrativo, edadAdministrativo, generoAdministrativo, cargoAdministrativo);
                            System.out.println(AdministrativoService.crearAdministrativo(administrativo, PATH));
                            break;
                        case 4:
                            System.out.println("Ingrese el id del administrativo a actualizar: ");
                            long idAdministrativo = scan.nextLong();
                            scan.nextLine();
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nuevoNombreAdmin = scan.nextLine();
                            System.out.println("Ingrese la nueva edad: ");
                            int nuevaEdadAdmin = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Ingrese el nuevo genero(M/F): ");
                            char nuevoGeneroAdmin = scan.nextLine().charAt(0);
                            System.out.println("Ingrese el nuevo cargo");
                            char nuevoCargoAdmin = scan.nextLine().charAt(0);
                            
                            CargoAdministrativo cargoAdministrativoActualizado = null;
                            List<CargoAdministrativo> cargosActualizados = CargoAdministrativoService.mostrarCargos();
                            for (CargoAdministrativo cargo : cargosActualizados) {
                                if (cargo.getType() == nuevoCargoAdmin) {
                                   cargoAdministrativoActualizado = cargo;
                                   break;
                                }
                            }

                            if (cargoAdministrativoActualizado == null) {
                                cargoAdministrativoActualizado = new CargoAdministrativo(nuevoCargoAdmin);
                                CargoAdministrativoService.crearCargo(cargoAdministrativoActualizado);
                            }
                            
                            //CargoAdministrativo nuevoCargo = new CargoAdministrativo(nuevoCargoAdmin);
                            Administrativo adminActualizado = new Administrativo(nuevoNombreAdmin,nuevaEdadAdmin,nuevoGeneroAdmin,
                            cargoAdministrativoActualizado);
                            
                            System.out.println(AdministrativoService.actualizarAdministrativo(adminActualizado, idAdministrativo, PATH));
                             break;
                        case 5:
                            System.out.println("Ingrese id del administrativo a eliminar: ");
                            long idAdminEliminar = scan.nextLong();
                            System.out.println(AdministrativoService.eliminarAdministrativo(idAdminEliminar, PATH));
                             break;
                        case 6: 
                            System.out.println(AdministrativoService.modificarDatos(PATH));
                            break;
                        case 7: 
                            exitAdministrative = true;
                            break;
                        default: 
                            System.out.println("Opcion del menu de administrativos no valida");
                    }
                    }
                    break;
                    
                case 3:
                    boolean exitTeacher = false;
                    while (!exitTeacher) {
                    System.out.println("\n--- Menú Profesores ---");
                    System.out.println("1. Mostrar Profesores");
                    System.out.println("2. Mostrar Profesor");
                    System.out.println("3. Crear Profesor");
                    System.out.println("4. Actualizar Profesor");
                    System.out.println("5. Eliminar Profesor");
                    System.out.println("6. Modificar Sueldo Profesor");
                    System.out.println("7. Salir");
                    System.out.println("Ingrese la opción deseada: ");
                    int optionTeacher = scan.nextInt();
                    scan.nextLine();
                    switch(optionTeacher) {
                        case 1:
                            System.out.println(ProfesorService.mostrarTodos());
                            break;
                        case 2:
                            System.out.println("Ingrese el id del profesor: ");
                            long idProf = scan.nextLong();
                            if(ProfesorService.mostrarPorId(idProf) != null) {
                                System.out.println(ProfesorService.mostrarPorId(idProf)); 
                            }
                            else {
                                System.out.println("No hay Profesores registrados con ese ID.");
                            }

                            break;
                        case 3:
                            System.out.println("Ingrese nombre: ");
                            String nombreProfesor = scan.nextLine();
                            System.out.println("Ingrese edad: ");
                            int edadProfesor = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Ingrese genero(M/F): ");
                            char generoProfesor = scan.nextLine().charAt(0);
                            System.out.println("Ingrese salario: ");
                            double salarioProfesor = scan.nextDouble();
                            scan.nextLine();
                            System.out.println("Ingrese antiguedad: ");
                            short antiguedadProfesor = scan.nextShort();
                            scan.nextLine();
                            System.out.println("Ingrese especialidad: ");
                            String tipoEspecialidad = scan.nextLine();
                            EspecialidadProfesor especialidadProfesor = null;
                            
                            List<EspecialidadProfesor> especialidades = EspecialidadProfesorService.mostrarEspecialidades();
                            for (EspecialidadProfesor especialidadProf : especialidades) {
                                if (especialidadProf.getType().equals(tipoEspecialidad)) {
                                   especialidadProfesor = especialidadProf;
                                   break;
                                }
                            }

                            if (especialidadProfesor == null) {
                                especialidadProfesor = new EspecialidadProfesor(tipoEspecialidad);
                                EspecialidadProfesorService.crearEspecialidad(especialidadProfesor);
                            }

                            Profesor profesor = new Profesor(nombreProfesor,edadProfesor, generoProfesor, salarioProfesor,
                                   antiguedadProfesor, especialidadProfesor);
                            System.out.println(ProfesorService.crearProfesor(profesor, PATH));
                             break;
                        case 4:
                            System.out.println("Ingrese el id del profesor a actualizar: ");
                            long idProfesor = scan.nextLong();
                            scan.nextLine();
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nuevoNombreProfesor = scan.nextLine();
                            System.out.println("Ingrese la nueva edad: ");
                            int nuevaEdadProfesor = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Ingrese el nuevo genero(M/F): ");
                            char nuevoGeneroProfesor = scan.nextLine().charAt(0);
                            System.out.println("Ingrese el nuevo salario: ");
                            double nuevoSalario = scan.nextDouble();
                            scan.nextLine();
                            System.out.println("Ingrese la nueva antiguedad: ");
                            short nuevaAntiguedad = scan.nextShort();
                            scan.nextLine();
                            System.out.println("Ingrese la nueva especialidad: ");
                            String nuevaEspecialidadProfesor = scan.nextLine();
                            
                            EspecialidadProfesor especialidadActualizadaProfesor = null;
                            
                            List<EspecialidadProfesor> especialidadesActualizadas = EspecialidadProfesorService.mostrarEspecialidades();
                            for (EspecialidadProfesor especialidadProf : especialidadesActualizadas) {
                                if (especialidadProf.getType().equals(nuevaEspecialidadProfesor)) {
                                   especialidadActualizadaProfesor = especialidadProf;
                                   break;
                                }
                            }

                            if (especialidadActualizadaProfesor == null) {
                                especialidadActualizadaProfesor = new EspecialidadProfesor(nuevaEspecialidadProfesor);
                                EspecialidadProfesorService.crearEspecialidad(especialidadActualizadaProfesor);
                            }
                            
                            Profesor profeActualizado = new Profesor(nuevoNombreProfesor,nuevaEdadProfesor,nuevoGeneroProfesor,
                            nuevoSalario,nuevaAntiguedad,especialidadActualizadaProfesor);
                            
                            System.out.println(ProfesorService.actualizarProfesor(profeActualizado, idProfesor, PATH));
                             break;
                        case 5:
                            System.out.println("Ingrese id del profesor a eliminar: ");
                            long idProfesorEliminar = scan.nextLong();
                            System.out.println(ProfesorService.eliminarProfesor(idProfesorEliminar, PATH));
                             break;
                        case 6: 
                            System.out.println(ProfesorService.modificarSueldo());
                            //Hacer funcion modificarSueldoProfesor();
                            break;
                        case 7: 
                            exitTeacher = true;
                            break;
                        default: 
                            System.out.println("Opcion del menu de profesores no valida");
                    }
                    }
                    break;
                    
                case 4:
                    boolean exitStudent = false;
                    while (!exitStudent) {
                    System.out.println("\n--- Menú Estudiantes ---");
                    System.out.println("1. Mostrar Estudiantes");
                    System.out.println("2. Mostrar Estudiante");
                    System.out.println("3. Crear Estudiante");
                    System.out.println("4. Actualizar Estudiante");
                    System.out.println("5. Eliminar Estudiante");
                    System.out.println("6. Salir");
                    System.out.println("Ingrese la opción deseada: ");
                    int optionStudent = scan.nextInt();
                    scan.nextLine();
                    switch(optionStudent) {
                        case 1:
                            System.out.println(EstudianteService.mostrarTodos());
                            break;
                        case 2:
                            System.out.println("Ingrese id del estudiante: ");
                            long idEstudiante = scan.nextLong();
                            if(EstudianteService.mostrarPorId(idEstudiante, PATH) != null) {
                             System.out.println(EstudianteService.mostrarPorId(idEstudiante, PATH));   
                            }
                            else {
                                System.out.println("No hay Estudiantes registrados con ese ID.");
                            }
                            
                            break;
                        case 3:
                            System.out.println("Ingrese nombre: ");
                            String nombreEstudiante = scan.nextLine();
                            System.out.println("Ingrese edad: ");
                            int edadEstudiante = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Ingrese genero(M/F): ");
                            char generoEstudiante = scan.nextLine().charAt(0);
                            System.out.println("Ingrese modalidad: ");
                            String tipoModalidad = scan.nextLine();
                            ModalidadEstudiante modalidadEstudiante = null;
                            
                            List<ModalidadEstudiante> modalidades = ModalidadEstudianteService.mostrarModalidades();
                            for (ModalidadEstudiante modalidad : modalidades) {
                                if (modalidad.getType().equals(tipoModalidad)) {
                                   modalidadEstudiante = modalidad;
                                   break;
                                }
                            }

                            if (modalidadEstudiante == null) {
                                modalidadEstudiante = new ModalidadEstudiante(tipoModalidad);
                                ModalidadEstudianteService.crearModalidad(modalidadEstudiante);
                            }

                            Estudiante estudiante = new Estudiante(nombreEstudiante,edadEstudiante, generoEstudiante, 
                                    modalidadEstudiante);
                            System.out.println(EstudianteService.crearEstudiante(estudiante, PATH));
                             break;
                        case 4:
                            System.out.println("Ingrese el id del estudiante a actualizar: ");
                            long idEstudianteActualizar = scan.nextLong();
                            scan.nextLine();
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nuevoNombreEstudiante = scan.nextLine();
                            System.out.println("Ingrese la nueva edad: ");
                            int nuevaEdadEstudiante = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Ingrese el nuevo genero(M/F): ");
                            char nuevoGeneroEstudiante = scan.nextLine().charAt(0);
                            System.out.println("Ingrese la nueva modalidad: ");
                            String nuevaModalidadEstudiante = scan.nextLine();
                            
                            ModalidadEstudiante modalidadActualizadaEstudiante = null;
                            
                            List<ModalidadEstudiante> modalidadesActualizadas = ModalidadEstudianteService.mostrarModalidades();
                            for (ModalidadEstudiante modalidadEst : modalidadesActualizadas) {
                                if (modalidadEst.getType().equals(nuevaModalidadEstudiante)) {
                                   modalidadActualizadaEstudiante = modalidadEst;
                                   break;
                                }
                            }

                            if (modalidadActualizadaEstudiante == null) {
                                modalidadActualizadaEstudiante = new ModalidadEstudiante(nuevaModalidadEstudiante);
                                ModalidadEstudianteService.crearModalidad(modalidadActualizadaEstudiante);
                            }
                            
                            Estudiante estudianteActualizado = new Estudiante(nuevoNombreEstudiante,nuevaEdadEstudiante,nuevoGeneroEstudiante,
                            modalidadActualizadaEstudiante);
                            
                            System.out.println(EstudianteService.actualizarEstudiante(estudianteActualizado, idEstudianteActualizar, PATH));
                             break;
                        case 5:
                            System.out.println("Ingrese id del estudiante a eliminar: ");
                            long idEstudianteEliminar = scan.nextLong();
                            System.out.println(EstudianteService.eliminarEstudiante(idEstudianteEliminar, PATH));
                             break;
                        case 6: 
                            exitStudent = true;
                            break;
                        default: 
                            System.out.println("Opcion del menu de estudiantes no valida");
                    }
                    }
                    break;
                    
                case 5:
                   exit = true;
                    break;
                    
                default: 
                    System.out.println("Valor ingresado invalido");
            }
        }
    }
    
    private static String mostrarTodasPersonas() {
        String contenido = "";
        if(!AdministrativoService.mostrarTodos().startsWith("No") && !ProfesorService.mostrarTodos().startsWith("No") && 
                !EstudianteService.mostrarTodos().startsWith("No")) {
            contenido = AdministrativoService.mostrarTodos() + "\n" + ProfesorService.mostrarTodos() +"\n" + EstudianteService.mostrarTodos();
        }
        else if(!AdministrativoService.mostrarTodos().startsWith("No") && !ProfesorService.mostrarTodos().startsWith("No")) {
            contenido = AdministrativoService.mostrarTodos() + "\n" + ProfesorService.mostrarTodos();
        }
        else if(!AdministrativoService.mostrarTodos().startsWith("No") && !EstudianteService.mostrarTodos().startsWith("No")) {
            contenido = AdministrativoService.mostrarTodos() + "\n" + EstudianteService.mostrarTodos();
        }
        else if(!ProfesorService.mostrarTodos().startsWith("No") && !EstudianteService.mostrarTodos().startsWith("No")) {
            contenido = ProfesorService.mostrarTodos() + "\n" + EstudianteService.mostrarTodos();
        }
        else if(!AdministrativoService.mostrarTodos().startsWith("No")) {
            contenido = AdministrativoService.mostrarTodos();
        }
        else if(!ProfesorService.mostrarTodos().startsWith("No")) {
            contenido = ProfesorService.mostrarTodos();
        }
        else if(!EstudianteService.mostrarTodos().startsWith("No")) {
            contenido = EstudianteService.mostrarTodos();
        }
        else {
            contenido = "No hay personas registradas";
        }
        
        return contenido;
    }
}
