package sshukla.java.solid.lsp.example1;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */
public class MotorCar implements Car {

    private Engine engine;

    public MotorCar() {
    }

    public MotorCar(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void turnOnEngine() {
        //turn on the engine!
        engine.on();
    }

    public void accelerate() {
        //move forward!
        engine.powerOn(1000);
    }
}
