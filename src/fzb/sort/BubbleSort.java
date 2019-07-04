/**
 * 
 */
package fzb.sort;

import org.springframework.util.SystemPropertyUtils;

/**
 * @author fzb
 * @since  2019年3月26日 上午11:11:58
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 * 最佳情况:当所有顺序都已经排好时，一次比较都没有，可以提前退出
 */
public class BubbleSort {
	public static int[] sort(int[] array){
		for(int i=0;i<array.length;i++){
			boolean compare=false;
			int count=0;
			for(int j=0;j<array.length-1-i;j++){
				if(array[j] >array[j+1]){
					int temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
					compare=true;
					System.out.println("比较："+ ++count +"次");
				}
			}
			if(!compare)
				break;
		}
		return array;
	}
}
