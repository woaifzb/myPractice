/**
 * @author fzb
 * @date   2017-4-15下午05:59:46
 */
package fzb.spring;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import fzb.proxy.*;

public class BeanFactoryTest {
	private static Logger logger = Logger.getLogger(BeanFactoryTest.class);
	public static void main(String[] args) {

		ClassPathResource resource = new ClassPathResource("/beans.xml");  
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();  
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);  
		reader.loadBeanDefinitions(resource);  
		
	//	print(resource);
			
		ApplicationContext atc=new ClassPathXmlApplicationContext("/beans.xml");
	//	Persion p=(Persion)atc.getBean("persion",Persion.class);
		Persion p=(Persion) factory.getBean("persion",Persion.class);
	//	System.out.println("Persion init");
		p=null;
		System.gc();
	//	p.toString();
	}
	
	
	private static void print(ClassPathResource resource) {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024]; 
		InputStream ip;
		try {
			ip = resource.getInputStream();
			int len=-1;
			while((len=ip.read(buffer))!=-1){
				outSteam.write(buffer,0,len);
			}
			outSteam.close();
			ip.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(outSteam.toString());
	}
}
