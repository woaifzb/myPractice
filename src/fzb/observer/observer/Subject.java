package fzb.observer.observer;


public interface Subject {
	public boolean registObserver(Observer o);
	public boolean removeObserver(Observer o);
	public void notifyObesever();
}
