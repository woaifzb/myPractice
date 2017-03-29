package fzb.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/**
 * 通过多线程并行求数组的和
 */
public class ConcurrentSum {  
    private int coreCpuNum;  
    private ExecutorService  executor;  
    private List<FutureTask<Long>> tasks = new ArrayList<FutureTask<Long>>();  
    public ConcurrentSum(){  
        coreCpuNum = Runtime.getRuntime().availableProcessors();  
        executor = Executors.newFixedThreadPool(coreCpuNum);  
    }  
    class SumCalculator implements Callable<Long>{  
        int nums[];  
        int start;  
        int end;  
        int no;
        public SumCalculator(final int nums[],int start,int end,final int no){  
            this.nums = nums;  
            this.start = start;  
            this.end = end;  
            this.no=no;
        }  
        @Override  
        public Long call() throws Exception {  
        	System.out.println("no"+no+"线程开始计算");
            long sum =0;  
            for(int i=start;i<end;i++){  
                sum += nums[i];  
            }
            System.out.println("no"+no+"线程得出结果："+sum);
            return sum;  
        }  
    }  
    public long sum(int[] nums){  
    	 // 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor   
        int start,end,increment;  
        increment = nums.length / coreCpuNum+1; //每个任务计算的数组长度
        for(int i=0;i<coreCpuNum;i++){  
            start = i*increment;  
            end = start+increment;  
            if(end > nums.length){  
                end = nums.length;   
            }  
            SumCalculator calculator = new SumCalculator(nums, start, end,i+1);  
            FutureTask<Long> task = new FutureTask<Long>(calculator);  
            tasks.add(task);  
            if(!executor.isShutdown()){  
                executor.submit(task);  
            }  
        }  
        return getPartSum();  
    }  
    public long getPartSum(){  
        long sum = 0;  
        for(int i=0;i<tasks.size();i++){  
            try {  
                sum += tasks.get(i).get();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (ExecutionException e) {  
                e.printStackTrace();  
            }  
        }  
        return sum;  
    }  
    public void close(){  
        executor.shutdown();  
    }  
      
    public static void main(String[] args) {  
        int arr[] = new int[]{1, 22, 33, 4, 52, 61, 7, 48, 10, 11 };  
        long sum = new ConcurrentSum().sum(arr);  
        System.out.println("sum: " + sum);  
    }  
}  