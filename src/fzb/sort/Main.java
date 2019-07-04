package fzb.sort;

public class Main {
	static int   []array={1,6,7,12,3,9,0,6,9,88};
	static int   []betterArray={1,2,3,4,5,6};
	public static void main(String[] args) {
		int result[]=QuickSort.sort(array);
		print(result);
	}
	private static void print(int[] result) {
		// TODO Auto-generated method stub
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}
}
