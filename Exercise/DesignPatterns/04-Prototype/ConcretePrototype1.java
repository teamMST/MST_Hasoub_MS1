public class ConcretePrototype1 implements Prototype {
    private String data;

    public ConcretePrototype1(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this.data);
    }

    @Override
    public String toString() {
        return "ConcretePrototype1{" +
                "data='" + data + '\'' +
                '}';
    }
}