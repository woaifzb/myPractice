package fzb.SocketChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class SocketListener extends Thread {

	@Override
	public void run() {
		ServerSocket socketServer=null;
		Thread myThread;
		try {
			socketServer=new ServerSocket(12345);
			while(true){
					Socket s=socketServer.accept(); //阻塞，直到有连接进来
					JOptionPane.showMessageDialog(null, "客户端连接到服务器");
					ChatSocket chatSocket=new ChatSocket(s);
					myThread=new Thread(chatSocket);
					ChatManager.getChatManager().add(chatSocket);
					myThread.start();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
