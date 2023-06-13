package ejercicio_7;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio_7 {

    public static void main(String[] args) {
       
        Set<String> soccerPlayersA = new HashSet<>();
        soccerPlayersA.add("Messi");
        soccerPlayersA.add("De paul");
        soccerPlayersA.add("Martinez");
        soccerPlayersA.add("Dybala");
        
        for(String player: soccerPlayersA) {
            System.out.println(player);
        }
        
       boolean isNeymarPresent = soccerPlayersA.contains("Neymar");
       //Opcion 1 mostrando booleano
       //System.out.println("Esta neymar presente? : " + isNeymarPresent);
       
       //Opcion 2 con operador ternario
       System.out.println("Esta neymar presente? : " + (isNeymarPresent ? "Si" : "No"));
       
       Set<String> soccerPlayersB = new HashSet<>();
       soccerPlayersB.add("Dibu");
       soccerPlayersB.add("Lautaro");
       soccerPlayersB.add("Angel");
       
       boolean isSoccerPlayersBPresentSoccerPlayersA = soccerPlayersA.containsAll(soccerPlayersB);
       //Opcion 1 mostrando booleano
       //System.out.println("Los jugadores del equipo B estan en el equipo A? : " + isSoccerPlayersBPresentSoccerPlayersA);
       
       //Opcion 2 con operador ternario
       System.out.println("Los jugadores del equipo B estan en el equipo A? : " + (isSoccerPlayersBPresentSoccerPlayersA ? "Si" : "No"));
       
       Set<String> soccerPlayers = new HashSet<>(soccerPlayersA);
       soccerPlayers.addAll(soccerPlayersB);
       
       soccerPlayersB.clear();
       System.out.println(soccerPlayersB.size());
    }
    
}
