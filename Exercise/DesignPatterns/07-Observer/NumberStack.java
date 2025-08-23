package observer;

import java.util.ArrayList;
// This is the Subject!
public class NumberStack implements Observable {

	ArrayList<Observer> observers=new ArrayList<Observer>();
	ArrayList<Integer> data =new ArrayList<Integer>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void update(int data) {
		for(Observer o : observers){
			o.process(data);
		}
		
	}
	
	public void addNumber(int num){
		data.add(num);
		update(num);
	}

}
