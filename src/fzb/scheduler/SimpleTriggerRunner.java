/**
 * 
 */
package fzb.scheduler;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import fzb.spring.BeanFactoryTest;

/**
 * @author fzb
 * @since  2017年4月20日 上午10:58:22
 */
public class SimpleTriggerRunner {
	private static Logger logger = Logger.getLogger(SimpleTriggerRunner.class);
	public static void main(String[] args) {
		JobDetail jd1=new JobDetail("myjob1","myJobGroup",SimpleJob.class);
		JobDetail jd2=new JobDetail("myjob2","myJobGroup",AnotherSimpleJob.class);
		SimpleTrigger simpleTrigger=new SimpleTrigger("myTrigger","myTriggerDroup");
		simpleTrigger.setStartTime(new Date());
		simpleTrigger.setRepeatCount(5);
		simpleTrigger.setRepeatInterval(1000);
		
		CronTrigger cronTrigger1=new CronTrigger("myCronTrigger1","myTriggerDroup");
		CronTrigger cronTrigger2=new CronTrigger("myCronTrigger2","myTriggerDroup");
		try {
			cronTrigger1.setCronExpression(new CronExpression("0/5 * * * * ?"));
			
			cronTrigger2.setCronExpression(new CronExpression("0/1 * * * * ?"));
		
			SchedulerFactory schedulerFactory=new StdSchedulerFactory();
			Scheduler scheduler=schedulerFactory.getScheduler();
		//	scheduler.scheduleJob(jd, simpleTrigger);
			scheduler.scheduleJob(jd1, cronTrigger1);
		//	scheduler.scheduleJob(jd2, cronTrigger2);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}


