package observer;

public interface Observable {
	public void addObserver(Observer observer);
	public void update(int data);
} 


