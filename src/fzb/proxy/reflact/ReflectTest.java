/**
 * 
 */
package fzb.proxy.reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import fzb.proxy.Persion;

/**
 * @author fzb
 * @since  2017年4月12日 上午11:25:05
 */
public class ReflectTest {
	static Object initByDefaultConst() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		ClassLoader loader =Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("fzb.proxy.Persion");
		Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
		
	//	Constructor consWithArgs = clazz.getDeclaredConstructor( new Class[]{String.class,String.class,int.class});
		
		Persion p= (Persion)cons.newInstance();
		Method setName =clazz.getMethod("setName", String.class);
		setName.invoke(p, "fzb");
		Method setAge =clazz.getMethod("setAge", String.class);
		setAge.invoke(p, "1");
		Method setHeight =clazz.getDeclaredMethod("setHeight", float.class);
		setHeight.setAccessible(true);
		setHeight.invoke(p, 178.9f);
	//	Persion p2= (Persion)consWithArgs.newInstance("tom","100",1,178.9);
		return p;
	}
	
	
	public static void main(String[] args) {
		try {
			Persion p=(Persion)initByDefaultConst();
			p.toString();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
