/**
 * 
 */
package fzb.proxy;

import java.lang.reflect.Proxy;

/**
 * @author fzb
 * @since  2017年3月18日 下午7:14:57
 */
public class PeosonMatch {
	
	public void go(){
		IPersion lily=new Persion("lily","25",90);
		
		IPersion ownerProxy=getOwnerProxy(lily);
		System.out.println("I am lili");
		System.out.println("name:"+ownerProxy.getName());
		System.out.println("set age 10" );
		ownerProxy.setAge("10");
		System.out.println("age:"+ownerProxy.getAge());
		
		
		System.out.println("I am tom");
		IPersion nonOwnerProxy=getNonOwerProxy(lily);
		System.out.println("set age 90");
		try {
			nonOwnerProxy.setAge("90");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("age:"+nonOwnerProxy.getAge());
		System.out.println("set score 0");
		nonOwnerProxy.setScore(0);
		System.out.println("score :" +nonOwnerProxy.getScore());
		
	}
	
	
	public IPersion getOwnerProxy(IPersion p){
		return (IPersion)Proxy.newProxyInstance(
				Persion.class.getClassLoader(), 
				Persion.class.getInterfaces(), 
				new OwnerInvocationHandler(p));
	}
	
	public IPersion getNonOwerProxy(IPersion p){
		return (IPersion)Proxy.newProxyInstance(
				p.getClass().getClassLoader(), 
				p.getClass().getInterfaces(), 
				new NonOwnerInvocationHandler(p));
				
	}
	public static void main(String[] args) {
		PeosonMatch pm=new PeosonMatch();
		pm.go();
	}
}
