public class PrototypeDemo {
    public static void main(String[] args) {
        // Create original objects
        Prototype p1 = new ConcretePrototype1("Karam");
        Prototype p2 = new ConcretePrototype2(24);

        // Clone objects
        Prototype c1 = (ConcretePrototype1) p1.clone();
        Prototype c2 = (ConcretePrototype2) p2.clone();

        // Display original and cloned objects
        System.out.println("Original: " + p1);
        System.out.println("Clone: " + c1);

        System.out.println("Original: " + p2);
        System.out.println("Clone: " + c2);
		
		
		// Let's make it interesting:
		Prototype p3 = new ConcretePrototype1("Israa");
		// PROBLEM
		ConcretePrototype1 c3 = p3.clone(); 
		// FIX:
		ConcretePrototype1 c3 = (ConcretePrototype1) p3.clone();
		
		if (p1 == c1) {
			System.out.println("SAME?!");
		}
		
		// if I need to do this without this design pattern I would do something like this:
		Prototype p;
		if (p1 instanceof ConcretePrototype1) {
			p = new ConcretePrototype1(((ConcretePrototype1)p1).getData());
		} else if (p1 instanceof ConcretePrototype2) {
			//
		} else if ( ..) {
			//
		}
    }
}
