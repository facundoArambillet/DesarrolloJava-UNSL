package ejercicio_5;

public class Auto extends Vehiculo{

    public Auto() {
        super();
    }
    
    @Override
    public void accelerate() {
        if(this.speed + 10 > 160) {
            this.speed = 160;
        }
        else {
            this.speed += 10;
        }
    }
    
}
