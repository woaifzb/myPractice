/**
 * 
 */
package fzb.Thread;

/**
 * @author fzb
 * @since  2019年6月2日 下午10:37:57
 */
public class WaitTest {
	public synchronized void testWait(){
		          System.out.println(Thread.currentThread().getName() +" Start-----");
		          try {
		              wait(0);
		          } catch (InterruptedException e) {
		              e.printStackTrace();
		         }
		         System.out.println(Thread.currentThread().getName() +" End-------");
		     }
		 
		     public static void main(String[] args) throws InterruptedException {
		         final WaitTest test = new WaitTest();
		         for(int i=0;i<5;i++) {
		             new Thread(new Runnable() {
		                 @Override
		                 public void run() {
		                     test.testWait();
		                 }
		             }).start();
		         }
		 
		         synchronized (test) {
		             test.notify();
		         }
		         Thread.sleep(3000);
		         System.out.println("-----------分割线-------------");
		         
		         synchronized (test) {
		             test.notifyAll();
		         }
		     }
}
