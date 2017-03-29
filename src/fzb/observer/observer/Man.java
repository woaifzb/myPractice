package fzb.observer.observer;


import java.util.ArrayList;
import java.util.List;

public class Man implements Observer {
	String name;
	private Subject star;

	public  Man(Subject star){
		this.star=star;
		star.registObserver(this);
	}
	
	@Override
	public void update(String status) {
		System.out.println("I am "+name+" I notice that the star "+status);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
