public class Bird {
    public void layEgg() {
        System.out.println("Laying an egg...");
    }
}

interface Flyable {
    void fly();
}

class FlyingBird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin {
    private Bird bird;

    public Penguin() {
        this.bird = new Bird();
    }

    public void layEgg() {
        bird.layEgg();
    }
}

class Sparrow {
    private Bird bird;
    private Flyable flyable;

    public Sparrow() {
        this.bird = new Bird();
        this.flyable = new FlyingBird();
    }

    public void layEgg() {
        bird.layEgg();
    }

    public void fly() {
        flyable.fly();
    }
}
