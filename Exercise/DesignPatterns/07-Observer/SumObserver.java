package observer;

public class SumObserver implements Observer{

	private long total;
	
	public void process(int data) {
		total+=data;
		System.out.println("Sum Observer Total At: "+total);
	}
}
