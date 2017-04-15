package fzb.classLoad;

public class  Snippet {
	public static void main(String[] args) {
		// 通过当前类的类加载器加载（会执行初始化）
		try {
			Class.forName("二进制名称");
			Class.forName("二进制名称", true, Snippet.class.getClass().getClassLoader());
			
			// 通过当前类的类加载器加载（不会执行初始化）
			Class.forName("二进制名称", false, Snippet.class.getClass().getClassLoader());
			Snippet.class.getClass().getClassLoader().loadClass("二进制名称");
			
			// 通过系统类加载器加载（不会执行初始化）
			ClassLoader.getSystemClassLoader().loadClass("二进制名称");
			
			// 通过线程上下文类加载器加载（不会执行初始化）
			Thread.currentThread().getContextClassLoader().loadClass("二进制名称");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

