package fzb.Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * @author fzb
 * @since  2017年4月7日 下午12:04:28
 */
public  class QuoteTask implements Callable<TravelQuote>{
    private final TravelCompany company;
    private final TravelInfo travelInfo;
    final ExecutorService exec=Executors.newFixedThreadPool(1);
 //   CompletionService<TravelQuote>  exec;
    
    
    
    
    
    public QuoteTask(TravelCompany company, TravelInfo travelInfo) {
		super();
		this.company = company;
		this.travelInfo = travelInfo;
	//	exec=new ExecutorCompletionService<TravelQuote>(executorService);
	}



	static class TravelCompany{
    	public TravelQuote solicitQuote(TravelInfo travelInfo){
    		return new TravelQuote();
    	}
    }
    static class TravelInfo{
    	
    }
    
    public TravelQuote call() throws Exception {
        return company.solicitQuote(travelInfo);
    }



 public List<TravelQuote> getRankedTravelQuotes(
 TravelInfo travelInfo, Set<TravelCompany> companies,Comparator<TravelQuote> ranking, long time, TimeUnit unit
 ) throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<QuoteTask>();
        for (TravelCompany company : companies)
            tasks.add(new QuoteTask(company, travelInfo));
        List<Future<TravelQuote>> futures = exec.invokeAll(tasks, time, unit);

        List<TravelQuote> quotes = new ArrayList<TravelQuote>(tasks.size());
        Iterator<QuoteTask> taskIter = tasks.iterator();
        for (Future<TravelQuote> f : futures) {
            QuoteTask task = taskIter.next();
            try {
                quotes.add(f.get());
            } catch (ExecutionException e) {
                quotes.add(task.getFailureQuote(e.getCause()));
            } catch (CancellationException e) {
                quotes.add(task.getTimeoutQuote(e));
            }
        }

        Collections.sort(quotes, ranking);
        return quotes;
    }



private TravelQuote getTimeoutQuote(CancellationException e) {
	// TODO Auto-generated method stub
	return null;
}



private TravelQuote getFailureQuote(Throwable cause) {
	// TODO Auto-generated method stub
	return null;
}

	public static void main(String[] args) {
		TravelCompany tc=new TravelCompany();
		TravelInfo ti=new TravelInfo();
		QuoteTask qt=new QuoteTask(tc,ti);
		//qt.getRankedTravelQuotes(ti, companies, ranking, 0, Time.);
	}
}