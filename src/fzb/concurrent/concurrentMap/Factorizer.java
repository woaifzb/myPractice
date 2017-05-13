/**
 * @author fzb
 * @date   2017-3-25下午11:26:41
 */
package fzb.concurrent.concurrentMap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * java并发编程实战 P86 -89
 */
public class Factorizer {
	private final Computable<BigInteger,BigInteger[]>c =new Computable<BigInteger,BigInteger[]>(){

		@Override
		public BigInteger[] compute(BigInteger arg) throws InterruptedException {
			return factor(arg);
		}
		
	};

	private final Computable<BigInteger,BigInteger[]> cache=new Memoizer<BigInteger, BigInteger[]>(c);
	
	
	protected BigInteger[] factor(BigInteger arg) {
		List<BigInteger> factors=new ArrayList<BigInteger>();
		BigInteger  divisor=new BigInteger("2");
		while( divisor.compareTo(arg.divide(BigInteger.valueOf(2)))<0){
			if(arg.remainder(divisor).compareTo(BigInteger.valueOf(0))==0)
				factors.add(divisor);
			divisor=divisor.add(BigInteger.ONE);
		}
		return (BigInteger[])factors.toArray(new BigInteger[factors.size()]);
	}


public static void main(String[] args) {
	Factorizer f=new Factorizer();
	Random r=new Random();
	try {
		for(int i=0;i<2;i++){
		//	int temp=r.nextInt(10);
			int temp=15;
			print(f.cache.compute(BigInteger.valueOf(temp)),BigInteger.valueOf(temp));
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


private static void print(BigInteger[] compute,BigInteger arg) {
	System.out.println(arg+"的公因数是：");
	for(int i=0;i<compute.length;i++){
		System.out.print(compute[i]+" ");
	}
	System.out.println();
}





}
