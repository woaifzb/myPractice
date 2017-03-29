package fzb.observer.observer;


public class LiveShow {
	
	public static void main(String[] args) {
		Star star=new Star();
		Man man1=new Man(star);
		Man man2=new Man(star);
		man1.setName("lion");
		man2.setName("jack");
		star.setMyStatue("dance");
		star.setMyStatue("sing");
	}
}
