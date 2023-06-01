package ejercicio_5;

public abstract class Vehiculo {
    protected float speed;
    
    public Vehiculo() {
        this.speed = 0;
    }
    
    public float getCurrentSpeed() {
        return this.speed;
    }; 
    
    public void setCurrentSpeed(float newSpeed){
        this.speed = newSpeed;
    }
    
    public abstract void accelerate();
    
    public void brake() {
        if(this.speed - 2 < 0) {
            this.speed = 0;
        }
        else {
            this.speed -= 2;
        }
    };
}
