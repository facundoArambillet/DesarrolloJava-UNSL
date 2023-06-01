package ejercicio_3;

public class Empleado {
    protected float basicSalary;
    
    public Empleado(float basicSalary) {
        this.basicSalary = basicSalary;
    }
    
    public float getBasicSalary() {
        return this.basicSalary;
    }
    
    public void setBasicSalary(float newSalary) {
        this.basicSalary = newSalary;
    }
    
    public float calculateSalary(float[] bonuses) {
        float totalBonuses = 0;
        for(float bonus : bonuses) {
            totalBonuses += bonus;
        }
        float totalSalary = this.basicSalary + totalBonuses;
        return totalSalary;
    }
}
