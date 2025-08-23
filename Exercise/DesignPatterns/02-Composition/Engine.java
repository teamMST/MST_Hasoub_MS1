// Engine class
public class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void start() {
        System.out.println("Engine of type " + type + " is starting...");
    }
}
