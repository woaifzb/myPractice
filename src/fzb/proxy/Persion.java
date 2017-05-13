/**
 * 
 */
package fzb.proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author fzb
 * @since  2017��3��18�� ����6:53:04
 */
public class Persion implements IPersion,InitializingBean
,DisposableBean{
	String name;
	String age;
	int score;
	float height;
	
	
	public void initMethod(){
		System.out.println("initMethod");
		this.name="default";
		this.age="0";
		this.score=0;
		this.height=0f;
	}
	
	public Persion() {
		super();
	}
	
	public Persion(String name, String age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public Persion (String name,String age,int score,float height){
		this.name=name;
		this.age=age;
		this.score=score;
		this.height=height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	private float getHeight() {
		return height;
	}
	private void setHeight(float height) {
		this.height = height;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("name: "+name+" age:"+age+" score:"+score+" height:"+height);
		return super.toString();
	}




	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}
	public void destroyMethod() throws Exception {
		System.out.println("destroyMethod");
	}
}
