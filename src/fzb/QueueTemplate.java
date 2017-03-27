package fzb;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTemplate {
	private static QueueTemplate instance = new QueueTemplate();
	
	public static QueueTemplate getInstance(){
		return instance;
	}
	
	
	private BlockingQueue<Object> queue;
	
	private QueueTemplate() {
		queue = new ArrayBlockingQueue<Object>(5);
	}
	
	public boolean offer(Object o) {
		return queue.offer(o);
	}
	
	public Object take(){
		Object o=null;
		try {
			o= queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public Object poll(){
		return queue.poll();
	}
	
	public int getSize(){
		return queue.size();
	}
}
