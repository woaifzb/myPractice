package fzb.observer.button;


public class Jsp {
	Button button=new Button();
	public Jsp(){
		button.setOnClickListener(new ClickListener() {
			
			@Override
			public void click(ClickEvent clickEvent) {
				System.out.println("您点击了按钮");
			}
		});
		
		button.setOnDoubleClickListener(new DoubleClickListener() {
			
			@Override
			public void doublcClickListener(DoubleClickEvent doubleClickEvent) {
				System.out.println("您双击了按钮");
			}
		});
		
		
	}
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
}
