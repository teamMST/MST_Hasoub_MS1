public class ConcretePrototype2 implements Prototype {
    private int number;

    public ConcretePrototype2(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(this.number);
    }

    @Override
    public String toString() {
        return "ConcretePrototype2{" +
                "number=" + number +
                '}';
    }
}