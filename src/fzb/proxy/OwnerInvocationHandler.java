/**
 * 
 */
package fzb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhuobin
 *
 */
public class OwnerInvocationHandler implements InvocationHandler {
	IPersion persion;
	
	public OwnerInvocationHandler(IPersion persion) {
		this.persion = persion;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		if(arg1.getName().startsWith("get"))
			return arg1.invoke(persion, arg2);
		if(arg1.getName().equals("setScore"))
			throw new IllegalArgumentException();
		if(arg1.getName().startsWith("set"))
			return arg1.invoke(persion, arg2);
		return null;
	}

}
