package fzb.classLoad;

public class  Snippet {
	public static void main(String[] args) {
		// 通过当前类的类加载器加载（会执行初始化）
		try {
			Class.forName("fzb.proxy.Persion.class");
			Class.forName("fzb.proxy.Persion", true, Snippet.class.getClass().getClassLoader());
			
			// 通过当前类的类加载器加载（不会执行初始化）
			Class.forName("fzb.proxy.Persion", false, Snippet.class.getClass().getClassLoader());
			Snippet.class.getClass().getClassLoader().loadClass("fzb.proxy.Persion");
			
			// 通过系统类加载器加载（不会执行初始化）
			ClassLoader.getSystemClassLoader().loadClass("fzb.proxy.Persion");
			
			// 通过线程上下文类加载器加载（不会执行初始化）
			Thread.currentThread().getContextClassLoader().loadClass("fzb.proxy.Persion");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

