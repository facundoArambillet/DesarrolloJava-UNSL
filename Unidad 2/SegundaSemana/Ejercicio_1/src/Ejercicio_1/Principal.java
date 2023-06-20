package Ejercicio_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        
        List <Persona> personas = new ArrayList<Persona>();
        Persona per;
        Scanner input = new Scanner(System.in);
        int np,edad;
        String nombre="";
        /*
        UNSL DESARROLLADOR JAVA NORMA PEREZ
        [2]
        */
        System.out.println("Ingrese la cantidad de Personas:");
        np=input.nextInt();

        for (int i=0; i<np;i++){
            System.out.println("Ingrese el nombre:");
            nombre= input.next();
            
            System.out.println("Ingrese la edad: ");
            edad=input.nextInt();
            
            per= new Persona(nombre,edad);
            personas.add(per);
        }

        Collections.sort(personas, new OrdenarPorEdad());
        for(Persona p: personas)
            System.out.println(p.toString());
            per=personas.get(0);
        
        for(Persona p: personas)
            if (p.compareTo(per)<0)
            per=p;
            
        System.out.println("El primero en orden alfabético es: "+ per.getNombre());
    }
}
