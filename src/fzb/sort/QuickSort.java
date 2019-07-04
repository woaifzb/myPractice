package fzb.sort;
/**
 * 
 * @author fzb
 * @since  2019年3月27日 下午6:05:19
 * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
 */
public class QuickSort {
	public static int[] sort(int[] array){
		doSort(array,0,array.length-1);
		return array;
	}
	
	private static void doSort(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		 int i,j,temp,t;
	        if(low>high){
	            return;
	        }
	        i=low;
	        j=high;
	        //temp就是基准位
	        temp = array[low];
	 
	        while (i<j) {
	            //先看右边，依次往左递减
	            while (temp<=array[j]&&i<j) {
	                j--;
	            }
	            //再看左边，依次往右递增
	            while (temp>=array[i]&&i<j) {
	                i++;
	            }
	            //如果满足条件则交换
	            if (i<j) {
	                t = array[j];
	                array[j] = array[i];
	                array[i] = t;
	            }
	 
	        }
	        //最后将基准为与i和j相等位置的数字交换
	        array[low] = array[i];
	        array[i] = temp;
	        //递归调用左半数组
	        doSort(array, low, j-1);
	        //递归调用右半数组
	        doSort(array, j+1, high);
	}
}
