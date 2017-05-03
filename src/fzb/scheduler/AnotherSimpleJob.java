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
 * @since  2017年4月24日 下午5:25:10
 */
public class AnotherSimpleJob implements Job {

	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("I am "+arg0.getTrigger().getName()+" trigger time is:"+(new Date()));
	}

}
