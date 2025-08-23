package observer;

public class MultObserver implements Observer {

	private long total=1;
	
	public void process(int data) {
		total*=data;
		System.out.println("Mult Observer Total At: "+total);
	}

}
