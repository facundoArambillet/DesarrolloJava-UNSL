package ejercicio_3;

public class Vendedor extends Empleado{
    
    public Vendedor(float basicSalary) {
        super(basicSalary);
    }
    //El metodo recibe como parametro un array con los bonos , y otro array con las ventas
    public float calculateSalary(float bonuses[],float sells[]) {
        float totalBonuses = 0;
        float totalSells = 0;
        //Recorro todos los bonos con un for-each y los voy sumando
        for(float bonus : bonuses) {
            totalBonuses += bonus;
        }
        //Recorro todas las ventas con un for-each y los voy sumando
        for(float sell : sells) {
            totalSells += sell;
        }
        //Sumo el total de ventas y el total de bonos para calcular el salario total
        float totalSalary = (float) (this.basicSalary + totalBonuses + (totalSells * 0.1));
        return totalSalary;
    }
}
