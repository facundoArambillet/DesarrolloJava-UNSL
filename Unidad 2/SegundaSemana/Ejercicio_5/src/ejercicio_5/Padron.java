package ejercicio_5;

import java.util.HashMap;
import java.util.Map;

public abstract class Padron {
    //Defino un map en donde la key va a ser el "id" y el value el objeto ciudadano
    private static int idCitizen = 1;
    private static Map<Integer,Ciudadano> citizens = new HashMap<>();
    
    public static void getAll() {
        if(citizens.isEmpty()) {
            System.out.println("El padron no contiene ciudadanos registrados");
        }
        else {
            for(Map.Entry<Integer, Ciudadano> entry : citizens.entrySet()) {
                System.out.println(entry.getValue().toString());
            }
        }
    }
    
    public static void getByDNI(int dni) {
        if(citizens.isEmpty()) {
            System.out.println("El padron no contiene ciudadanos registrados");
        }
        for(Map.Entry<Integer, Ciudadano> entry : citizens.entrySet()) {
            if(entry.getValue().getDni() == dni) {
                System.out.println("El ciudadano es: " + entry.getValue().toString());
            }
            else {
                System.out.println("El dni no corresponde a ningun ciudadano registrado");
            }
        }
    }
    
    public static void create(Ciudadano citizen) {
        if(citizen.getAge() >= 16) {
            citizens.put(idCitizen, citizen);
            idCitizen++;
            System.out.println("El ciudadano fue registrado con exito");
        }
        else {
            System.out.println("La edad del ciudadano es invalida");
        }
    }
    
    public static void update(int dni , Ciudadano newCitizen) {
        if(citizens.isEmpty()) {
            System.out.println("El padron no contiene ciudadanos registrados");
        }
        else {
            for(Map.Entry<Integer, Ciudadano> entry : citizens.entrySet()) {
                if(entry.getValue().getDni() == dni) {
                    entry.getValue().setDni(newCitizen.getDni());
                    entry.getValue().setName(newCitizen.getName());
                    entry.getValue().setAge(newCitizen.getAge());
                    entry.getValue().setProvince(newCitizen.getProvince());
                    System.out.println("Ciudadano actualizado con exito");
                }
                else {
                    System.out.println("El dni ingresado no corresponde a ningun ciudadano del padron");
                }
            }  
        }

    }
    
    public static void delete(int dni) {
        if(citizens.isEmpty()) {
            System.out.println("El padron no contiene ciudadanos registrados");
        }
        else {
            for(Map.Entry<Integer, Ciudadano> entry : citizens.entrySet()) {
                if(entry.getValue().getDni() == dni) {
                    //Elimino del map el objeto por el id
                    citizens.remove(entry.getKey());
                    System.out.println("Ciudadano eliminado con exito");
                }
                else {
                    System.out.println("El dni ingresado no corresponde a ningun ciudadano del padron");
                }
            }
        }
    }
}
