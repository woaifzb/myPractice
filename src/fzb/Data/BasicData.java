/**
 * 
 */
package fzb.Data;

/**
 * @author fzb
 * @since  2019年5月15日 下午3:06:16
 */
public class BasicData {
	
	public static void main(String[] args) {
		Long i=1L;
		Long j=1L;
//		System.out.println(i==j);
//		System.out.println(i==j.longValue());
		
		String a="a";
		String b=new String("a");
//		System.out.println(a==b);
		
		Integer aa=Integer.valueOf("1");
		Integer bb=Integer.valueOf("1");
		System.out.println(aa==bb);
//		System.out.println(aa.equals(bb));
		
		
	}
}
