package ejercicio_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public abstract class UserMenu {
    
    private static Map<Integer,Set<String>> fruitMap = new HashMap<>();
    
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Frutas");
            System.out.println("2. Mostrar Union de conjuntos");
            System.out.println("3. Mostrar Diferencia Simetrica");
            System.out.println("4. Mostrar Interseccion de conjuntos");
            System.out.println("5. Verificar contension entre conjuntos");
            System.out.println("6. Salir");
            System.out.println("Ingrese la opción deseada: ");
            int option = scan.nextInt();
            
            switch(option) {
                case 1: 
                    System.out.println("Ingrese la cantidad de conjuntos: ");
                    short quantity = scan.nextShort();

                    System.out.println("Ingrese la cantidad de frutas por conjunto, deben ser mayor o igual a 5: ");
                    short quantityFruit = scan.nextShort();
                    while(quantityFruit < 5) {
                        System.out.println("Valor invalido, porfavor ingrese un numero mayor o igual a 5: "); 
                        quantityFruit = scan.nextShort();
                    }

                    for(int i = 0; i < quantity; i++) {
                        Set<String> fruit = new HashSet<>();
                        System.out.println("Conjunto de frutas numero " + (i+1) + ": ");
                        for(int j = 0; j < quantityFruit; j++) {
                            System.out.println("Ingrese el nombre de la fruta numero " + (j+1) + ": ");
                            String fruitName = scan.next();
                            fruit.add(fruitName);
                        }
                        fruitMap.put(i, fruit);
                    }
                    
                    break;
                    
                case 2:
                    if(fruitMap.isEmpty()) {
                        System.out.println("No hay conjuntos de frutas registrados.");
                        break;
                    }
                    else {
                        showSet(union());
                        break;
                        
                    }
                    
                case 3:
                    if(fruitMap.isEmpty()) {
                        System.out.println("No hay conjuntos de frutas registrados.");
                        break;
                    }
                    else {
                        System.out.println("Ingrese el valor posicional del primer conjunto: ");
                        int positionalSet_1 = scan.nextInt();
                        System.out.println("Ingrese el valor posicional del segundo conjunto: ");
                        int positionalSet_2 = scan.nextInt();
                        
                        showSet(symmetricDiff(fruitMap.get(positionalSet_1),fruitMap.get(positionalSet_2)));
                        break;
                    }
                    
                case 6:
                    exit = true;
                    break;
            }
        }
        
        scan.close();
    }
    
    private static void showSet(Set<String> set_1) {
        for(String fruit : set_1) {
            System.out.println(fruit);
        }
    }
    
    private static Set<String> union() {
        Set<String> union = new HashSet<>();
        for (Map.Entry<Integer, Set<String>> entry : fruitMap.entrySet()) {
            
            Set<String> set = entry.getValue();
            for (String element : set) {
                union.add(element);
            }
        }
        return union;
    }
    
    private static Set<String> symmetricDiff(Set<String> set_1, Set<String> set_2) {
        Set<String> symmetricDifference = new HashSet<>(set_1);
        symmetricDifference.addAll(set_2);
        
        Set<String> aux = new HashSet<>(set_1);
        aux.retainAll(set_2);
        
        symmetricDifference.removeAll(aux);
        
        return symmetricDifference;
    }
}
