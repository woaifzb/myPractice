/**
 * 
 */
package fzb.exception;

/**
 * @author fzb
 * @since  2017年5月14日 上午11:28:31
 */
public class TestException {
	public static void main(String[] args) {
		System.out.println(run());
	}

	private static int run() {
		//	System.out.println(1/0);
			System.out.println(1);
			try {
				System.out.println(2);
				System.out.println(1/0);
				System.out.println(3);
				return 9;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(4);
				e.printStackTrace();
			}
			//System.out.println(5);
			finally{
				System.out.println(5);
			}
			return 0;
			
	}
}
