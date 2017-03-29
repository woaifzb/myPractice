package fzb.proxy.another;


/**
 * 排序法	平均时间		最差情形		稳定度	   额外空间			备注
	冒泡		O(n2)	    O(n2)		稳定			O(1)		n小时较好
	交换	    O(n2)	    O(n2)		不稳定		O(1)		n小时较好
	选择		O(n2)		O(n2)		不稳定		O(1)		n小时较好
	插入		O(n2)		O(n2)		稳定			O(1)		大部分已排序时较好
	基数		O(logRB)	O(logRB)	稳定			O(n)		B是真数(0-9)，R是基数(个十百)
	Shell	O(nlogn)	O(ns) 1<s<2	不稳定		O(1)		s是所选分组
	快速		O(nlogn)	O(n2)		不稳定		O(nlogn)	n大时较好
	归并		O(nlogn)	O(nlogn)	稳定			O(1)		n大时较好
	堆		O(nlogn)	O(nlogn)	不稳定		O(1)		n大时较好
 */

public class Snippet {
	/*
	 * 冒泡法排序<br/>  
	 *O(n²) 适用于排序小列表。 
	 * @param numbers  
	 *            需要排序的整型数组  
	 */  
	public static void bubbleSort(int[] numbers) {   
	    int temp; // 记录临时中间值   
	    int size = numbers.length; // 数组大小   
	    for (int i = 0; i <size-1; i++) {   
	        for (int j = i+1 ; j <size; j++) {   
	            if (numbers[j] < numbers[i]) { // 交换两数的位置   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }   
	}
	
	/*-----------------------快速排序法（一）--------------------------------------------- 
    将最左边的数设定为轴，并记录其值为s 
    廻圈处理： 
    令索引i 从数列左方往右方找，直到找到大于s 的数 
    令索引j 从数列左右方往左方找，直到找到小于s 的数 
    如果i >= j，则离开回圈 
    如果i < j，则交换索引i与j两处的值 
    将左侧的轴与j 进行交换 
    对轴左边进行递回 
    对轴右边进行递回   
    平均效率O（nlogn），适用于排序大列表。 
此算法的总时间取决于枢纽值的位置；选择第一个元素作为枢纽，可能导致O（n²）的最糟用例效率。若数基本有序，效率反而最差。选项中间值作为枢纽，效率是O（nlogn）。 
基于分治法。 
    --------------------------------------------------------------------------------*/  
   public static void doQuicksort(int number[],int left,int right) {  
       int i, j, s, temp;  
       if(left < right) {  
           s = number[left];  
           i = left;  
           j = right + 1;  
           while(true) {  
               // 向右找  
               while(i + 1 < number.length && number[++i] < s) ;  
               // 向左找  
               while(j -1 > -1 && number[--j] > s) ;  
               if(i >= j)  
                   break;  
               temp=number[i];  
               number[i]=number[j];  
               number[j]=temp;  
           }  
       number[left] = number[j];  
       number[j] = s;  
       doQuicksort(number, left, j-1); // 对左边进行递回  
       doQuicksort(number, j+1, right); // 对右边进行递回  
       }  
   }  
	
   /**
    * 插入排序
    * 最佳效率O（n）；最糟效率O（n²）与冒泡、选择相同，适用于排序小列表 
	     若列表基本有序，则插入排序比冒泡、选择更有效率。 
    * @param number
    */
   public static void insertSort(int number[]){
	   int n=number.length;
	   for(int i=1;i<n;i++)//循环从第二个数组元素开始，因为arr[0]作为最初已排序部分 
	   { 
	       int temp=number[i];//temp标记为未排序第一个元素 
	       int j=i-1; 
		   while (j>=0 && number[j]>temp)/*将temp与已排序元素从小到大比较，寻找temp应插入的位置*/ 
		   { 
			   number[j+1]=number[j]; 
		       j--; 
		   } 
		   number[j+1]=temp; 
	   }
   }
   
   /**
    * 归并排序
    *
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序 
     *  
     * @param data 
     *            数组对象 
     * @param left 
     *            左数组的第一个元素的索引 
     * @param center 
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引 
     * @param right 
     *            右数组最后一个元素的索引 
     */  
   public void mergesort(int number1[],int number2[],int number3[]){  
       long start,end;  
       final int MAX=20;   
       start=System.nanoTime();  
       doQuicksort(number1,0,MAX-1);  
       doQuicksort(number2,0,MAX-1);  
       mergesort_merge(number1,MAX,number2,MAX,number3);  
       end=System.nanoTime();  
         
       System.out.println("-----------------合并排序法------------------");  
       System.out.print("排序后是:");  
       for(int i=0;i<=MAX+MAX-1;i++){  
            System.out.print(number3[i]+" ");  
       }  
       System.out.println();  
       System.out.println("排序使用时间："+(end-start)+" ns");     
   }  
     
     
   public void mergesort_merge(int number1[], int M, int number2[], int N, int number3[]) {  
       int i = 0, j = 0, k = 0;  
       while(i < M && j < N) {  
           if(number1[i] <= number2[j]){  
               number3[k++] = number1[i++];  
           }else{  
               number3[k++] = number2[j++];  
           }     
       }  
       while(i < M){  
           number3[k++] = number1[i++];  
       }    
       while(j < N){  
           number3[k++] = number2[j++];  
       }  
   }  
   
   
	public static void main(String[] args) {
		int array[]=new int[] {20,8,4,12,9,2,15,3,7,199,95,315,1,99};
	//	bubbleSort(array);
		long start,end;  
	    int MAX=array.length;
        start=System.nanoTime();  
  //      doQuicksort(array,0,MAX-1);
  //      bubbleSort(array);
  //      insertSort(array);
     //   MergeSort(0,array.length);
        end=System.nanoTime();  
         
        System.out.print("排序后是:");  
        for(int i=0;i<=MAX-1;i++){  
            System.out.print(array[i]+" ");  
        }  
        System.out.println();  
        System.out.println("排序使用时间："+(end-start)+" ns");  
	}
	
	
	
	
	
}