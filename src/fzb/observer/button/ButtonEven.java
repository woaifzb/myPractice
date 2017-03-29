package fzb.observer.button;


import java.util.EventObject;

public abstract class ButtonEven extends EventObject {

	public ButtonEven(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	
}

class ClickEvent extends ButtonEven{

	public ClickEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
}

class DoubleClickEvent extends ButtonEven{

	public DoubleClickEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
}






