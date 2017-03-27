/**
 * 
 */
package fzb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author fzb
 * @since  2017年3月18日 下午7:03:29
 */
public class NonOwnerInvocationHandler implements InvocationHandler {

	IPersion persion;
	
	public NonOwnerInvocationHandler(IPersion persion) {
		this.persion = persion;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		if(arg1.getName().startsWith("get"))
			return arg1.invoke(persion, arg2);
		if(arg1.getName().equals("setScore"))
			return arg1.invoke(persion, arg2);
		if(arg1.getName().startsWith("set"))
			throw new IllegalArgumentException();
		return null;
	}

}
