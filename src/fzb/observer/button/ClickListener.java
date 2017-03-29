package fzb.observer.button;


import java.util.EventListener;

public interface ClickListener extends EventListener {
	void click(ClickEvent clickEvent);
}
