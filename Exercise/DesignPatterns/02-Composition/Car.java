// Car class using composition
public class Car {
    private Engine engine;
    private Wheel[] wheels;

    public Car(Engine engine, Wheel[] wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void startCar() {
        engine.start();
        for (Wheel wheel : wheels) {
            wheel.rotate();
        }
        System.out.println("Car is moving...");
    }

    public static void main(String[] args) {
        Engine engine = new Engine("V8");
        Wheel[] wheels = {
            new Wheel(18),
            new Wheel(18),
            new Wheel(18),
            new Wheel(18)
        };

        Car car = new Car(engine, wheels);
        car.startCar();
    }
}