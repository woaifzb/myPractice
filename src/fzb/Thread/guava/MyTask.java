/**
 * 
 */
package fzb.Thread.guava;

/**
 * @author fzb
 * @since  2019年6月1日 下午9:37:50
 */
public class MyTask implements Runnable {

	private int id;
	
	public MyTask(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"==>"+id);
	}

}
