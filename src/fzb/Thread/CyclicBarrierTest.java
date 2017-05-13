/**
 * @author fzb
 * @date   2017-5-6下午01:32:05
 */
package fzb.Thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		 CyclicBarrier barrier = new CyclicBarrier(3);  
		 ExecutorService exec=Executors.newFixedThreadPool(3);
		 exec.execute(new Thread(new Runner("1号选手",barrier)));
		 exec.execute(new Thread(new Runner("2号选手",barrier)));
		 exec.execute(new Thread(new Runner("3号选手",barrier)));
		 exec.shutdown();
	}
	
	
}
class Runner implements Runnable{
	String name;
	CyclicBarrier  barrier;
	
	public Runner(String name, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000*(new Random().nextInt(5)));
			System.out.println(name+"准备好了...");
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(name + " 起跑！");  
	}
	
	
	
	
	
	
}



