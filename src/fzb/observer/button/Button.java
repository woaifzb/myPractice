package fzb.observer.button;


public class Button {
	private ClickListener onClickListener; 
	private DoubleClickListener onDoubleClickListener;
	
	public void click(){
		onClickListener.click(new ClickEvent(this));
	}
	public void doubleClick(){
		onDoubleClickListener.doublcClickListener(new DoubleClickEvent(this));
	}
	public ClickListener getOnClickListener() {
		return onClickListener;
	}
	public void setOnClickListener(ClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}
	public DoubleClickListener getOnDoubleClickListener() {
		return onDoubleClickListener;
	}
	public void setOnDoubleClickListener(DoubleClickListener onDoubleClickListener) {
		this.onDoubleClickListener = onDoubleClickListener;
	}
	
	
}
