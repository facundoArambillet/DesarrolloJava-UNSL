package ejercicio_3;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;
import java.util.Scanner;

public abstract class UserMenu {
    private static Map<String,Byte> students = new HashMap<>();
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Mostrar Estudiantes Totales");
            System.out.println("3. Mostrar Estudiantes Aptos para cursar");
            System.out.println("4. Salir");
            System.out.println("Ingrese la opción deseada: ");
            int option = scan.nextInt();
            
            switch(option) {
                case 1 :
                    scan.nextLine();
                    System.out.println("Ingrese el nombre del estudiante: ");
                    String name = scan.nextLine();
                    System.out.println("Ingrese la edad del estudiante: ");
                    byte age = scan.nextByte();
                    
                    Student student = new Student(name,age);
                    createStudent(student);
                    break;
                case 2: 
                    scan.nextLine();
                    getAllStudents();
                    break;
                    
                case 3:
                    scan.nextLine();
                    getStudentsOver16();
                    break;
                    
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese una opción válida.");
                    break;
            }
        }
    }
    
    private static void createStudent(Student student) {
        students.put(student.getName(),student.getAge());
    }
    private static void getAllStudents() {
        if(!students.isEmpty()) {
            System.out.println("Estos son todos los estudiantes registrados: ");
            for (Map.Entry<String, Byte> entry : students.entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + ", edad: " + entry.getValue() + ((entry.getValue() > 16) ? "" : " Aviso: estudiante No puede cursar."));
            }
        }
        else {
            System.out.println("No existen estudiantes registrados.");
        }

    }

    private static void getStudentsOver16() {
        if(!students.isEmpty()) {
            System.out.println("Estos son los estudiantes aptos para cursar: ");
            for (Map.Entry<String, Byte> entry : students.entrySet() ) {
                if(entry.getValue() > 16) {
                    System.out.println ("Nombre: " + entry.getKey() + ", edad: " + entry.getValue());

                }
            }
        }
        else {
            System.out.println("No existen estudiantes registrados.");
        }

    }
 
}
