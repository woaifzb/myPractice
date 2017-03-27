package fzb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
	final ExecutorService convertservice = Executors.newFixedThreadPool(2);
	final int threadCount=2;
	public void onConsumer() {
		final QueueTemplate queue = QueueTemplate.getInstance();
		
		for(int i=0;i<threadCount ;i++){
			Runnable dealThread =new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						while(true){
							if(queue.getSize()>0){
								String str=(String)queue.poll();
								System.out.println(str);
							}
							else{
								Thread.sleep(1000);
							}
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			convertservice.submit(dealThread) ;
		}
		convertservice.shutdown();
	}
	
	public static void main(String[] args) {
		ExecutorsTest ete=new ExecutorsTest();
		for(int i=0;i<10;i++){
			System.out.println(QueueTemplate.getInstance().offer(new String("这是"+i)));
		}
		System.out.println("队列size："+QueueTemplate.getInstance().getSize());
		ete.onConsumer();
	}
}












