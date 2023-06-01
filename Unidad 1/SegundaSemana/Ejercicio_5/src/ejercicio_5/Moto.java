package ejercicio_5;

public class Moto extends Vehiculo{

    public Moto() {
        super();
    }

    @Override
    public void accelerate() {
        if(this.speed + 5 > 120) {
            this.speed = 120;
        }
        else {
            this.speed += 5;
        }
    }
    
}
