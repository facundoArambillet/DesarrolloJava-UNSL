package Ejercicio_1;

import java.util.Comparator;

public class OrdenarPorEdad implements Comparator<Persona>{

    @Override
    public int compare(Persona p_1, Persona p_2) {
        return (p_1.getEdad() - p_2.getEdad());
    }
    
}
