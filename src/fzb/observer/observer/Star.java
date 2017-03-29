package fzb.observer.observer;


import java.util.ArrayList;
import java.util.List;

public class Star implements Subject {
	private List observers;
	private String myStatue;
	
	public Star() {
		observers=new ArrayList();
	}

	@Override
	public void notifyObesever() {
		for( Object o : observers ){
			Observer observer=(Observer)o;
			observer.update(myStatue);
		}
	}

	@Override
	public boolean registObserver(Observer o) {
		return observers.add(o);
	}

	@Override
	public boolean removeObserver(Observer o) {
		return observers.remove(o);
	}

	public String getMyStatue() {
		return myStatue;
	}

	public void setMyStatue(String myStatue) {
		this.myStatue = myStatue;
		notifyObesever();
	}

}
