package ejercicio_6;

public class Ejercicio_6 {

    public static void main(String[] args) {
        //(byte) es una manera de castear un valor es decir agarrar un tipo de dato(El 24 es un entero)
        // Y transformalo en otro tipo en este caso de tipo byte(Ver tabla de tipos de datos en:
        //https://www.manualweb.net/java/tipos-datos-primitivos-java/ )
         
        Empleado empleado_1 = new Empleado("Facundo",(byte) 24);
        System.out.println(empleado_1.printData());
        
        Empleado empleado_2 = new Empleado("Clemente",(byte) 25, 95000f);
        System.out.println(empleado_2.printData());
    }
    
}
