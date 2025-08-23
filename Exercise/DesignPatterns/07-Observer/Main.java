package observer;

public class Main {

	public static void main(String[] args) {
		
		NumberStack stack=new NumberStack();
		
		stack.addObserver(new CountObserver());
		stack.addObserver(new SumObserver());
		stack.addObserver(new MultObserver());
		
		stack.addNumber(10);
		System.out.println();
		stack.addNumber(4);
		System.out.println();
		stack.addNumber(5);
		
		// EXTRA:
		stack.addObserver(new CountObserver());
		stack.addNumber(0)
	}

}
