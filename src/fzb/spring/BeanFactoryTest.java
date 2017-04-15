/**
 * @author fzb
 * @date   2017-4-15下午05:59:46
 */
package fzb.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import fzb.proxy.*;

public class BeanFactoryTest {
	private static Logger logger = Logger.getLogger(BeanFactoryTest.class);
	public static void main(String[] args) {
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource res=resolver.getResource("classpath:/beans.xml");
		BeanFactory bean=new XmlBeanFactory(res);

		System.out.println("Persion init");
		Persion p=bean.getBean("persion",Persion.class);
		
		p.toString();
	}
}
