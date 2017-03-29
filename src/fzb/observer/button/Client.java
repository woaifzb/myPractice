package fzb.observer.button;



public class Client {
	public static void main(String[] args) {
		Jsp jsp=new Jsp();
		jsp.getButton().click();
		jsp.getButton().doubleClick();
	}
}
