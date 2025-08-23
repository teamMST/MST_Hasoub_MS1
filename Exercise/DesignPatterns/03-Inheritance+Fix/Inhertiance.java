class Bird {
    public void fly() {
        System.out.println("Flying...");
    }

    public void layEgg() {
        System.out.println("Laying an egg...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        // Penguins can't fly, but we are forced to provide this method
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}