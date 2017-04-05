/**
 * 
 */
package fzb.command;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**命令模式
 * @author fzb
 * @since  2017年4月3日 下午7:01:42
 */
public class Command {
	public static void main(String[] args) {
		Executor  threadPool =new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
		for(int i=0;i<10;i++){
			threadPool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() + " 执行  " );
				}
				
			}));
		}
		
		Thread t=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		t.run();
	}
	
}
