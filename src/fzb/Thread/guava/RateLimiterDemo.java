/**
 * 
 */
package fzb.Thread.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author fzb
 * @since  2019年6月1日 下午9:24:30
 */
public class RateLimiterDemo {
	public static void main(String[] args) {
		RateLimiter rt=RateLimiter.create(10);
		ExecutorService threadPool=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			double waitSecond=rt.acquire(5);
			System.out.println("等待时间:"+waitSecond);
			threadPool.execute(new MyTask(i));
		}
		threadPool.shutdown();
	}
}
