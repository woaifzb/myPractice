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
		JobDetail jd=new JobDetail("myjob","myJobGroup",SimpleJob.class);
		SimpleTrigger simpleTrigger=new SimpleTrigger("myTrigger","myTriggerDroup");
		simpleTrigger.setStartTime(new Date());
		simpleTrigger.setRepeatCount(5);
		simpleTrigger.setRepeatInterval(1000);
		
		CronTrigger cronTrigger=new CronTrigger("myCronTrigger","myTriggerDroup");
		try {
			CronExpression cronExpress=new CronExpression("0/3 * * * * ?");
			cronTrigger.setCronExpression(cronExpress);
		
			SchedulerFactory schedulerFactory=new StdSchedulerFactory();
			Scheduler scheduler=schedulerFactory.getScheduler();
		//	scheduler.scheduleJob(jd, simpleTrigger);
			scheduler.scheduleJob(jd, cronTrigger);
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


