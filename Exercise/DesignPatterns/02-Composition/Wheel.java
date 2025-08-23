// Wheel class
public class Wheel {
    private int size;

    public Wheel(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void rotate() {
        System.out.println("Wheel of size " + size + " is rotating...");
    }
}
