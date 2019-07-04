/**
 * @author fzb
 * @date   2017-6-1下午11:28:10
 */
package fzb.proxy.CGLib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class TestEnhance {
	public static void main(String[] args) {
		
	
	Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(TestEnhance.class);
    enhancer.setCallback(new MethodInterceptorImpl());
     
    TestEnhance demo = (TestEnhance) enhancer.create();
     
    demo.test();
     
    System.out.println(demo);
	}
	public void test() {
        System.out.println("TestEnhance test()");
    }
	     
    private static class MethodInterceptorImpl implements MethodInterceptor {
 

		@Override
		public Object intercept(Object arg0, Method arg1, Object[] arg2,
				MethodProxy arg3) throws Throwable {
			System.err.println("Before invoke " + arg1);
            Object result = arg3.invokeSuper(arg0, arg2);
            System.err.println("After invoke" + arg1);
            return result;
		}
         
    }
}
