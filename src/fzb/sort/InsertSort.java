/**
 * 
 */
package fzb.sort;

/**
 * @author fzb
 * @since  2019年3月26日 下午3:57:48
 * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 */
public class InsertSort {
	public static int[] sort(int[] array){
		int current;
		for(int i=0;i<array.length-1;i++){
			 current=array[i+1];
			 int j=i;
			 while(j>=0 && current<array[j]){
				 array[j+1]=array[j];
				 j--;
			 }
			 array[j+1]=current;
		}
		return array;
	}
}
