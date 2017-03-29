package fzb.SocketChat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;


public class ChatSocket implements Runnable {
	private Socket socket;
	private final String charSet="GBK";
	public ChatSocket(Socket socket) {
		this.socket = socket;
	}
	public void output(String out){
		try {
			socket.getOutputStream().write(out.getBytes(charSet));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),charSet));
			String line=null;
			while((line=br.readLine())!=null){
				ChatManager.getChatManager().publich(this, line);
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
