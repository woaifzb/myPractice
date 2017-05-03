package fzb.socket.socketClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * filename:SocketServer.java
 * author:martin
 * comment:socketserver
 */

/**
 * @author martin
Note:This project is shared for personal use, if you want to use it in commercial 
project , you should send an email to dingxiangyong@gmail.com at first.

How to use it :
1.Run SocketServer.java of 'SocketServer' package.
2.Run SocketClient.java of 'SocketClient' package.

See:
1.Request[0] is a short connection request, and you can see a 'Request[0] get a 
exception : java.net.SocketException: Software caused connection abort: recv 
failed' on the console. And you can see Request[1] end rightly, because request[1] 
is a long connection request.
 */
public class SocketClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// thread executor
		ExecutorService executor = Executors.newCachedThreadPool();

		// short connection
		executor.execute(new RequestThread(0, false));
		
		// long connection
		executor.execute(new RequestThread(1, true));
	}

}
