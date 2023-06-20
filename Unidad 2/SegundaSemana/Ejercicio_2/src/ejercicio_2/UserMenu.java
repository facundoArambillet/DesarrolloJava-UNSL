package ejercicio_2;

import java.util.Scanner;

public abstract class UserMenu {
    
    private static Person[] persons;
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n--- Carga de datos iniciales ---"); 
        System.out.println("Ingrese cuantas personas quiere registrar: ");
        byte lengthArray = scan.nextByte();
        persons = new Person[lengthArray];
        
        for(int i = 0; i < lengthArray; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i+1) + ": ");
            String name = scan.next();
            
            System.out.println("Ingrese la edad de la persona " + (i+1) + ": ");
            byte age = scan.nextByte();
            
            Person person = new Person(name,age);
            persons[i] = person;
        } 
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Buscar persona");
            System.out.println("4. Actualizar persona");
            System.out.println("5. Eliminar persona");
            System.out.println("6. Salir");
            System.out.println("Ingrese la opción deseada: ");
            int option = scan.nextInt();
            
            switch (option) {
                case 1:
                    scan.nextLine();
                    System.out.println("Ingrese el nombre de la persona: ");
                    String name = scan.nextLine();
                    System.out.println("Ingrese la edad de la persona: ");
                    byte age = scan.nextByte();
                    
                    Person person = new Person(name, age);
                    createPerson(person);
                    break;
                case 2:
                    getPersons();
                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Ingrese el nombre de la persona a buscar: ");
                    String searchName = scan.nextLine();
                    getPerson(searchName);
                    break;
                case 4:
                    scan.nextLine();
                    System.out.println("Ingrese el nombre de la persona a actualizar: ");
                    String updateName = scan.nextLine();
                    updatePerson(updateName);
                    break;
                case 5:
                    scan.nextLine();
                    System.out.println("Ingrese el nombre de la persona a eliminar: ");
                    String deleteName = scan.nextLine();
                    deletePerson(deleteName);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese una opción válida.");
                    break;
            }
        }
    }
    
    private static void createPerson(Person person) {
        Person[] personsCreate = new Person[persons.length + 1];
        for(int i = 0; i < persons.length; i++) {
            personsCreate[i] = persons[i];
        }
        personsCreate[persons.length] = person;
        persons = personsCreate;
          
    }
    
    private static void getPersons() {
        if(persons.length != 0) {
            for (int i = 0; i < persons.length; i++) {
                if (persons.length != 0) {
                    System.out.println("Persona encontrada: ");
                    System.out.println(persons[i].toString());
                }
            }
        }
        else{
            System.out.println("No hay personas en el arreglo.");
        }
    }
    
    private static void getPerson(String name) {
        if(persons.length != 0) {
            for (int i = 0; i < persons.length; i++) {
                if (persons[i].getName().equalsIgnoreCase(name) && persons[i] != null) {
                    System.out.println("Persona encontrada: ");
                    System.out.println(persons[i].toString());
                    //found = true;
                    break;
                }
                else {
                    System.out.println("La persona no se encuentra en el arreglo.");
                }
            }   
       }
       else {
           System.out.println("No hay personas en el arreglo.");
       }   
    }
    
    private static void updatePerson(String name) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getName().equalsIgnoreCase(name) && persons[i] != null) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Ingrese el nuevo nombre de la persona: ");
                String newName = scan.nextLine();
                System.out.println("Ingrese la nueva edad de la persona: ");
                byte newAge = scan.nextByte();
                
                persons[i].setName(newName);
                persons[i].setAge(newAge);
                
                System.out.println("Datos de la persona actualizados.");
                System.out.println(persons[i].toString());
                
                break;
            }
            else {
            System.out.println("La persona no se encuentra en el arreglo.");
  
            }
        }
    }
    
    private static void deletePerson(String name) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getName().equalsIgnoreCase(name)) {
                persons[i] = null;
                Person[] newPersons = new Person[persons.length - 1];
                int newIndex = 0;
                for (int j = 0; j < persons.length; j++) {
                    if (persons[j] != null) {
                        newPersons[newIndex] = persons[j];
                        newIndex++;
                    }
                }
                persons = newPersons;
                System.out.println("Persona eliminada correctamente.");
                break;
            }
            else {
                System.out.println("La persona no se encuentra en el arreglo.");
            }
        }
}

    
}
