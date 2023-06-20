package ejercicio_5;

import java.util.Scanner;

public abstract class UserMenu {
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int citizenDni;
        Ciudadano citizen;
        Provincia province;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar Ciudadanos");
            System.out.println("2. Mostrar Ciudadano por dni");
            System.out.println("3. Agregar Ciudadano");
            System.out.println("4. Actualizar ciudadano por dni");
            System.out.println("5. Eliminar ciudadano");
            System.out.println("6. Salir");
            System.out.println("Ingrese la opción deseada: ");
            int option = scan.nextInt();
            
            switch(option) {
                case 1:
                    scan.nextLine();
                    Padron.getAll();
                    break;
                    
                case 2:
                    scan.nextLine();
                    System.out.println("Ingrese el dni del ciudadano: ");
                    int dniUser = scan.nextInt();
                    Padron.getByDNI(dniUser);
                    break;
                    
                case 3:
                    scan.nextLine();
                    System.out.println("Ingrese el dni del ciudadano: ");
                    citizenDni = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese el nombre del ciudadano: ");
                    String citizenName = scan.nextLine();
                    System.out.println("Ingrese la edad del ciudadano: ");
                    byte citizenAge = scan.nextByte();
                    scan.nextLine();
                    //Creacion de la provincia
                    System.out.println("Ingrese el nombre de la provincia del ciudadano: ");
                    String provinceName = scan.nextLine();
                    System.out.println(provinceName);
                    System.out.println("Ingrese los kilometros cuadrados de dicha provincia: ");
                    float provinceArea = scan.nextFloat();
                    
                    province = new Provincia(provinceName,provinceArea);
                    citizen = new Ciudadano(citizenDni,citizenName,citizenAge,province);
                    
                    Padron.create(citizen);
                    break;
                    
                case 4:
                    scan.nextLine();
                    System.out.println("Ingrese el dni del ciudadano a actualizar: ");
                    int citizenDniOld = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese el dni actualizado del ciudadano: ");
                    citizenDni = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese el nombre actualizado del ciudadano: ");
                    String citizenNameNew = scan.nextLine();
                    System.out.println("Ingrese la edad actualizada del ciudadano: ");
                    byte citizenAgeNew = scan.nextByte();
                    scan.nextLine();
                    //Creacion de la provincia
                    System.out.println("Ingrese el nombre de la provincia actualizada del ciudadano: ");
                    String provinceNameNew = scan.nextLine();
                    System.out.println("Ingrese los kilometros cuadrados actualizados de dicha provincia: ");
                    float provinceAreaNew = scan.nextFloat();
                    
                    province = new Provincia(provinceNameNew,provinceAreaNew);
                    citizen = new Ciudadano(citizenDni,citizenNameNew,citizenAgeNew,province);
                    
                    Padron.update(citizenDniOld, citizen);
                    break;
                    
                case 5:
                    scan.nextLine();
                    System.out.println("Ingrese el dni del ciudadano a eliminar: ");
                    citizenDni = scan.nextInt();
                    
                    Padron.delete(citizenDni);
                    break;
                case 6:
                    exit = true;
                    break;
                    
                default:
                    scan.nextLine();
                    System.out.println("Opcion no valida vuelva a elegir: ");
            }
        }
        scan.close();
    }
}
