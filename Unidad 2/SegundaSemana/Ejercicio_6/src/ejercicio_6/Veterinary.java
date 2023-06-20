package ejercicio_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Veterinary {
    private static List<Owner> owners = new ArrayList<>();
    
    public static void getAllOwners() {
        if(owners.isEmpty()) {
            System.out.println("No hay dueños registrados");
        }
        else {
            for(Owner owner : owners) {
                System.out.println(owner.toString());
            }
        }
    }
    
    public static void getByDni(int dni) {
        if(owners.isEmpty()) {
            System.out.println("No hay dueños registrados");
        }
        else {
            for(Owner owner : owners) {
                if(owner.getDni() == dni) {
                    System.out.println(owner.toString());
                }
                else {
                    System.out.println("no hay dueños registrados con ese dni");
                }
            }
        }
    }
    
    public static void create(Owner owner) {
        owners.add(owner);
        System.out.println("Dueño creado con exito");
    }
    
    public static void update(int dni, Owner newOwner) {
        if(owners.isEmpty()) {
            System.out.println("No hay dueños registrados");
        }
        else {
            for(Owner owner : owners) {
                if(owner.getDni() == dni) {
                    owner.setDni(newOwner.getDni());
                    owner.setName(newOwner.getName());
                    owner.setAge(newOwner.getAge());
                    owner.setMascots(newOwner.getMascots());
                    System.out.println("Dueño actualizado con exito");
                }
                else {
                    System.out.println("El dni ingresado no corresponde a ningun Dueño");
                }
            }  
        }
    }
    
    public static void delete(int dni) {
        for(Owner owner : owners) {
            if(owner.getDni() == dni) {
                owners.remove(owner);
                System.out.println("Dueño elimiando con exito");
            }
            else {
                System.out.println("El dni ingresado no corresponde a ningun Dueño");
            }
        }
    }
    
    public static void getMascotsWithSameName() {
        if (owners.size() <= 1) {
            System.out.println("Debe haber al menos 2 dueños registrados. Actualmente hay: " + owners.size());
        } 
        else {
            Map<String, Integer> mascotCountMap = new HashMap<>();
            List<Mascot> totalMascots = new ArrayList<>();
            List<Mascot> duplicatedMascots = new ArrayList<>();

            // Contar la cantidad de veces que aparece cada nombre de mascota
            for (Owner owner : owners) {
                for (Mascot mascot : owner.getMascots()) {
                    String mascotName = mascot.getName();
                    totalMascots.add(mascot);
                    mascotCountMap.put(mascotName, mascotCountMap.getOrDefault(mascotName, 0) + 1);
                }
                
            }
            
            // Filtrar los nombres, con el nombre busco las mascotas y luego las agrego al List
            for (Map.Entry<String, Integer> entry : mascotCountMap.entrySet()) {
                if (entry.getValue() > 1) {
                    for(Mascot mascot : getMascotsByName(totalMascots,entry.getKey())) {
                        duplicatedMascots.add(mascot);
                    }
                }
            }
            
            // Imprimir los nombres de mascotas repetidos
            if (duplicatedMascots.isEmpty()) {
                System.out.println("No se encontraron nombres de mascotas repetidos");
            } 
            else {
                System.out.println("Mascotas repetidas: ");
                for (Mascot mascot: duplicatedMascots) {
                    System.out.println(mascot.toString());
                }
            }
        }
    }
    
    public static List<Mascot> getMascotsByName(List<Mascot> mascots, String name) {
        List<Mascot> mascotsWithSameName = new ArrayList<>();
        for(Mascot mascot : mascots) {
            if(mascot.getName().equals(name)) {
                mascotsWithSameName.add(mascot);
            }
        }
        return mascotsWithSameName;
    }
}