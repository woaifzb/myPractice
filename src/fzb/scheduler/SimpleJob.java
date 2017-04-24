/**
 * 
 */
package fzb.scheduler;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author fzb
 * @since  2017年4月20日 上午11:32:45
 */
public class SimpleJob implements Job{
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(arg0.getTrigger().getName()+" trigger time is:"+(new Date()));
	}
}
