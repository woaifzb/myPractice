package fzb.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadpoolExcutor {
public static void main(String[] args) {
	Executor threadpoolExcutor=new ThreadPoolExecutor(3,6,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable> (100));
	
	AtomicInteger ai=new AtomicInteger(0);
	for(int i;(i=ai.getAndIncrement())<5;){
		threadpoolExcutor.execute(new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " 执行  " );  
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}));
	}
}
}
