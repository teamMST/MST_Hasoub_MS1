package observer;

public class CountObserver implements Observer {

	private int counter;
		
	public void process(int data) {
		counter++;
		System.out.println("Count Observer Total At: "+counter);
	}
}
