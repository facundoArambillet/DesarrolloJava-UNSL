package ejercicio_3;

public class Ejercicio_3 {

    public static void main(String[] args) {
        Vendedor vendedor_1 = new Vendedor(25000f);
        //Creo el array de bonos
        float[] bonuses = new float[]{10f,20f,50f,105.5f};
        //Creo el array de ventas
        float[] sells = new float[]{1500f,2500f,3500f,50200.5f};
        System.out.println("El salario total es de: " + vendedor_1.calculateSalary(bonuses, sells));
    }
    
}
