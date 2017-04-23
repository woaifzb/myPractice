package fzb.Thread;
public class JoinTest {  
      
    public static int a = 0;  
  
  
    public static void main(String[] args) throws Exception {  
        Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				a=a+3;
				System.out.println(Thread.currentThread().getName()+" a="+a);  
			}
        });  
        Thread t2= new Thread(new Runnable(){
			@Override
			public void run() {
				a=a*2;
				System.out.println(Thread.currentThread().getName()+" a="+a);  
			}
        }); 
        Thread t3= new Thread(new Runnable(){
			@Override
			public void run() {
				a=a/3;
				System.out.println(Thread.currentThread().getName()+" a="+a);  
			}
        }); 
        
        t1.start();   
        t1.join();
        t2.start();
        t2.join();
        t3.start(); 
        t3.join();
        System.out.println(Thread.currentThread().getName()+" a="+a);  
    }         
}  