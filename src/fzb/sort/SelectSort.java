/**
 * 
 */
package fzb.sort;

/**
 * @author fzb
 * @since  2019年3月26日 上午11:53:55
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 */
public class SelectSort {
	public static int[] sort(int[] array){
		for(int i=0;i<array.length;i++){
			int minIndex=i;
			for(int j=i+1;j<array.length;j++){
				if(array[minIndex] > array[j]){
					minIndex=j;
				}
			}
			int temp=array[minIndex];
			array[minIndex]=array[i];
			array[i]=temp;
		}
		return array;
	}
}
