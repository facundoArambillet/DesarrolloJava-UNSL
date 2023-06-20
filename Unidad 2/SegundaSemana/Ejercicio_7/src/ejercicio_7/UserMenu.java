package ejercicio_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class UserMenu {
    private static Map<String,List<Player>> teams = new HashMap<>();
    private static Scanner  scan = new Scanner(System.in);
    
    public static void menu() {

       
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú Equipos---");
            System.out.println("1. Mostrar Equipos");
            System.out.println("2. Mostrar Equipo");
            System.out.println("3. Crear equipo");
            System.out.println("4. Eliminar equipo");
            System.out.println("5. Eliminar Jugadores repetidos de un equipo");
            System.out.println("6. Salir");
            System.out.println("Ingrese la opción deseada: ");
            int option = scan.nextInt();
            scan.nextLine();
            switch(option) {
                case 1: 
                    getAll();
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nombre del equipo que desea ver: ");
                    String teamName = scan.nextLine();
                    getByName(teamName);
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nombre del equipo: ");
                    String newTeamName = scan.nextLine();
                    System.out.println("Ingrese cuantos jugadores contiene el equipo: ");
                    int listLength = scan.nextInt();
                    scan.nextLine();
                    List<Player> newTeam = new ArrayList<>();
                    for(int i = 0; i < listLength; i++) {
                        System.out.println("Ingrese el nombre del nuevo jugador " + (i+1) + ": ");
                        String newPlayerName = scan.nextLine();
                        System.out.println("Ingrese la edad del nuevo jugador: " + (i+1) + ": ");
                        byte newPlayerAge = scan.nextByte();
                        scan.nextLine();
                        System.out.println("Ingrese el numero de la remera del nuevo jugador: " + (i+1) + ": ");
                        short newShirtNumber = scan.nextShort();
                        scan.nextLine();
                                    
                        Player newPlayer = new Player(newPlayerName,newPlayerAge,newShirtNumber);
                        createPlayerLIFO(newTeam,newPlayer);
                    }
                    
                    teams.put(newTeamName, newTeam);
                    System.out.println(" ");
                    System.out.println("Equipo registrado con exito");
                    break;
                    
                case 4:
                    System.out.println("Ingrese el nombre del equipo a eliminar: ");
                    String deleteNameTeam = scan.nextLine();
                    deleteTeam(deleteNameTeam);
                    break;
                    
                case 5:
                    if(teams.size() < 2) {
                        System.out.println("Debe haber registrado minimo 2 equipos para esta opcion");
                        break;
                    }
                    else {
                        System.out.println("Ingrese el nombre del primer equipo: ");
                        String nameFirstTeam = scan.nextLine();
                        System.out.println("Ingrese el nombre del segundo equipo: ");
                        String nameSecondTeam = scan.nextLine();
                        
                        if(getByNames(nameFirstTeam,nameSecondTeam)) {
                            List<Player> team_1 = new ArrayList<>();
                            List<Player> team_2 = new ArrayList<>();
                            
                            for(Map.Entry<String,List<Player>> entry : teams.entrySet()) {
                                if(entry.getKey().equals(nameFirstTeam) ) {
                                    team_1 = entry.getValue();
                                }
                                if(entry.getKey().equals(nameSecondTeam)) {
                                    team_2 = entry.getValue();
                                }
                            }
                            deleteDuplicatePlayers(nameFirstTeam,nameSecondTeam,team_1,team_2);
                            break;
                        }
                        else {
                            System.out.println("Algun/os de los nombres de los equipos no se encuentra/n registrado/s");
                            break;
                        }
                    }
                case 6:
                    exit = true;
                    break;
                    
                default: 
                    System.out.println("Valor ingresado invalido");
            }
        }
    }
    
    private static void getAll() {
        if(teams.isEmpty()) {
            System.out.println("No hay equipos registrados");
        }
        else {
           for(Map.Entry<String, List<Player>> entry : teams.entrySet()) {
               String namesPlayers = "";
               for(Player player : entry.getValue()) {
                   namesPlayers += player.getName() + ", ";
               }
               System.out.println("Nombre de equipo: " + entry.getKey() + ", jugadores: " + namesPlayers);
            } 
        }
    }
    
    private static void getByName(String name) {
        if(teams.isEmpty()) {
            System.out.println("No hay equipos registrados");
        }
        else {
            if(teams.containsKey(name)) {
                for(Map.Entry<String,List<Player>> entry : teams.entrySet()) {
                    if(entry.getKey().equals(name)) {
                        String players = "";
                        for(Player player : entry.getValue()) {
                            players += player.getName() + ", ";
                        }
                        System.out.print("El equipo: " + name + ", tiene los siguientes jugadores: " + players);
                        
                        boolean exitPlayer = false;
                        while (!exitPlayer) {
                            System.out.println("\n--- Menú Jugadores---");
                            System.out.println("1. Mostrar Jugador");
                            System.out.println("2. Crear Jugador");
                            System.out.println("3. Eliminar Jugador");
                            System.out.println("4. Salir");
                            System.out.println("Ingrese la opción deseada: ");
                            int optionPlayer = scan.nextInt();
                            scan.nextLine();
                            switch(optionPlayer) {
                                case 1:
                                    System.out.println("Ingrese el nombre del jugador: ");
                                    String playerName = scan.nextLine();
                                    getPlayerByName(entry.getValue(),playerName);
                                    break;
                                    
                                case 2:
                                    System.out.println("Ingrese el nombre del nuevo jugador: ");
                                    String newPlayerName = scan.nextLine();
                                    System.out.println("Ingrese la edad del nuevo jugador: ");
                                    byte newPlayerAge = scan.nextByte();
                                    scan.nextLine();
                                    System.out.println("Ingrese el numero de la remera del nuevo jugador: ");
                                    short newShirtNumber = scan.nextShort();
                                    scan.nextLine();
                                    
                                    Player newPlayer = new Player(newPlayerName,newPlayerAge,newShirtNumber);
                                    createPlayerLIFO(entry.getValue(),newPlayer);
                                    break;
                                    
                                case 3:
                                    System.out.println("Ingrese el nombre del jugador a eliminar: ");
                                    String deletePlayerName = scan.nextLine();
                                    deletePlayer(entry.getValue(),deletePlayerName);
                                    break;
                                    
                                case 4:
                                    exitPlayer = true;
                                    break;
                                    
                                default:
                                    System.out.println("Valor ingresado no valido");
                                    break;
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("El nombre del equipo no se encuentra registrado");
            }

        }
    }
    
    private static boolean getByNames(String teamName_1 , String teamName_2) {
        if(teams.isEmpty()) {
            System.out.println("No hay equipos registrados");
            return false;
        }
        else {
            if(teams.containsKey(teamName_1) && teams.containsKey(teamName_2)) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    private static void createTeam(String teamName, List<Player> team) {
        teams.put(teamName, team);
        System.out.println("Equipo creado con exito");
    }
    
    private static void deleteTeam(String teamName) {
        if(teams.isEmpty()) {
            System.out.println("No se encuentra registrados equipos");
        }
        else {
            for(Map.Entry<String,List<Player>> entry : teams.entrySet()) {
                if(entry.getKey().equals(teamName)) {
                    teams.remove(entry.getKey());
                    System.out.println("Equipo eliminado con exito");
                }
                else {
                    System.out.println("Nombre de equipo no encontrado");
                }
            }
        }
    }
    
    private static void getPlayerByName(List<Player> team, String playerName) {

        for(Player player : team) {
            if(player.getName().equals(playerName)) {
                System.out.println("El jugador: " + playerName + " tiene " + player.getAge() + " años " + ", y juega en este equipo con la camiseta numero " + player.getShirtNumber());
            }
            else {
                System.out.println("El jugador no juega en este equipo");
            }
        }

    }
    
    private static void createPlayerLIFO(List<Player> team, Player player) {
        team.add(0,player);
        System.out.print("Jugador agregado con exito");
    }
    
    private static void deletePlayer(List<Player> team , String namePlayer) {
        for(Player player : team) {
            if(player.getName().equals(namePlayer)) {
                team.remove(player);
            }
        }
    }
    
    private static void deleteDuplicatePlayers(String nameFirstTeam, String nameSecondTeam, List<Player> team_1 , List<Player> team_2) {
        boolean playerDuplicated = false;
        for(Player player_1 : team_1) {
            for(Player player_2 : team_2) {
                if(player_1.getName().equals(player_2.getName())) {
                    team_1.remove(player_1);
                    playerDuplicated = true;
                }
            }
        }
        //Actualizo el map de equipos con el nuevo valor del team_1
        teams.put(nameFirstTeam, team_1);
        if(playerDuplicated) {
            System.out.println("Jugadores del equipo " + nameFirstTeam + ", repetidos en el equipo " + nameSecondTeam + ", eliminados con exito");
        }
        else {
            System.out.println("No hay jugadores repetidos entre el equipo " + nameFirstTeam + ", y el equipo " + nameSecondTeam);
        }

    }
    
    /*
    private static void deletePlayerLIFO(List<Player> team) {
        Player lastPlayer = team.get(team.size() - 1);
        team.remove(lastPlayer);
        System.out.println("Ultimo jugador eliminado con exito");
    }
    */
}
