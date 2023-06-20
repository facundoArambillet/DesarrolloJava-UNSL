package ejercicio_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class UserMenu {
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int ownerDni;
        String ownerName;
        byte ownerAge;
        byte ownerQuantityMascots;
        List<Mascot> ownerMascots = new ArrayList<>();
        
        String mascotName;
        String mascotBreed;
        String mascotAddress;
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar dueños");
            System.out.println("2. Mostrar dueño por dni");
            System.out.println("3. Agregar dueño");
            System.out.println("4. Actualizar dueño por dni");
            System.out.println("5. Eliminar dueño");
            System.out.println("6. Mostrar mascotas con el mismo nombre");
            System.out.println("7. Salir");
            System.out.println("Ingrese la opción deseada: ");
            int option = scan.nextInt();
            
            switch(option) {
                case 1:
                    Veterinary.getAllOwners();
                    break;
                    
                case 2:
                    System.out.println("Ingrese el dni del dueño: ");
                    ownerDni = scan.nextInt();
                    scan.nextLine();
                    Veterinary.getByDni(ownerDni);
                    break;
                    
                case 3:
                    System.out.println("Ingrese dni del dueño: ");
                    ownerDni = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese nombre del dueño: ");
                    ownerName = scan.nextLine();
                    System.out.println("Ingrese edad del dueño: ");
                    ownerAge =  scan.nextByte();
                    scan.nextLine();
                    System.out.println("Ingrese cantidad de mascotas que posee el dueño: ");
                    ownerQuantityMascots = scan.nextByte();
                    scan.nextLine();
                    for(int i = 0; i < ownerQuantityMascots; i++) {
                        System.out.println("Ingrese nombre de la mascota " + (i+1) + ": ");
                        mascotName = scan.nextLine();
                        System.out.println("Ingrese raza de la mascota " + (i+1) + ": ");
                        mascotBreed = scan.nextLine();
                        System.out.println("Ingrese direccion de la mascota " + (i+1) + ": ");
                        mascotAddress = scan.nextLine();
                        //El idOwner es el dni del owner
                        Mascot mascot = new Mascot(mascotName,mascotBreed,mascotAddress,ownerDni);
                        ownerMascots.add(mascot);
                    }
                    Owner owner = new Owner(ownerDni,ownerName,ownerAge,ownerMascots);
                    Veterinary.create(owner);
                    //Limpio el array de mascotas para que cuando vaya a registrar otro duenio no se mezclen
                    ownerMascots.clear();
                    break;
                    
                case 4:
                    System.out.println("Ingrese dni del dueño a actualizar: ");
                    int ownerDniOld = scan.nextInt();
                    System.out.println("Ingrese dni actualizado del dueño: ");
                    ownerDni = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese nombre actualizado del dueño: ");
                    ownerName = scan.nextLine();
                    System.out.println("Ingrese edad  del dueño: ");
                    ownerAge =  scan.nextByte();
                    scan.nextLine();
                    System.out.println("Ingrese cantidad de mascotas que posee el dueño: ");
                    ownerQuantityMascots = scan.nextByte();
                    scan.nextLine();
                    for(int i = 0; i < ownerQuantityMascots; i++) {
                        System.out.println("Ingrese nombre de la mascota " + (i+1) + ": ");
                        mascotName = scan.nextLine();
                        System.out.println("Ingrese raza de la mascota " + (i+1) + ": ");
                        mascotBreed = scan.nextLine();
                        System.out.println("Ingrese direccion de la mascota " + (i+1) + ": ");
                        mascotAddress = scan.nextLine();
                        //El idOwner es el dni del owner
                        Mascot mascot = new Mascot(mascotName,mascotBreed,mascotAddress,ownerDni);
                        ownerMascots.add(mascot);
                    }
                    Owner ownerUpdated = new Owner(ownerDni,ownerName,ownerAge,ownerMascots);
                    //Limpio el array de mascotas para que cuando vaya a registrar otro duenio no se mezclen
                    Veterinary.update(ownerDniOld, ownerUpdated);
                    ownerMascots.clear();
                    break;
                    
                case 5:
                    System.out.println("Ingrese dni del dueño a eliminar: ");
                    ownerDni = scan.nextInt();
                    Veterinary.delete(ownerDni);
                    break;
                    
                case 6:
                    Veterinary.getMascotsWithSameName();
                    
                    break;
                    
                case 7:
                    exit = true;
                    break;
                    
                default:
                    System.out.println("El valor ingresado es invalido, vuelva a intentarlo");
                    break;
            }
        }
    }
}
