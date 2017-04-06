/**
 * 
 */
package fzb.Thread;

import java.util.concurrent.Callable;

/**
 * @author fzb
 * @since  2017年4月6日 下午4:19:38
 */
public class MyExecutorService {
	private class QuoteTask implements Callable<TravelQuote>{
		final private travelCompany tc;
		final private travelInfo ti;
		
		public QuoteTask(travelCompany tc, travelInfo ti) {
			super();
			this.tc = tc;
			this.ti = ti;
		}

		@Override
		public TravelQuote call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	class travelInfo{
		public travelInfo(String info) {
			super();
			this.info = info;
		}

		private String info;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			System.out.println(info);
			return super.toString();
		}
	}
	
	class travelCompany{
		public String publishTravelInfo(TravelQuote t){
			return t.toString();
		}
	}
	
	class TravelQuote {
	}
	
	
	
	
	
	
	
}
