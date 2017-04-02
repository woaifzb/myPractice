package fzb.concurrent.concurrentMap;

/**
 * @author fzb
 * @date   2017-3-25下午10:57:55
 */

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer<A,V> implements Computable<A, V>{
	private final ConcurrentMap<A,Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
	private final Computable<A, V> c;
	
	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}

	@Override
	public V compute(final A arg) throws InterruptedException {
		while(true){
			Future<V> f=cache.get(arg);
			if(f==null){
				Callable<V> eval=new  Callable<V>(){
					@Override
					public V call() throws InterruptedException {
						System.out.println("开始计算公因数");
						return c.compute(arg);
					}
				};
				FutureTask<V> ft=new FutureTask<V>(eval);
				System.out.println("从缓存获取"+arg+"的公因数");
				f=cache.putIfAbsent(arg, ft);
				if(f==null){
					System.out.println("缓存为空");
					f=ft;
					ft.run();
				}
				try {
					return f.get();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (CancellationException e){
					cache.remove(arg,f);
				}
			}
			else{
				System.out.println("从缓存取得"+arg+"的公因数");
				try {
					return f.get();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
