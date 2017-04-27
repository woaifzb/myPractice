package fzb.nio.selector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Set;


public class NBTest {
	static Selector selector;
	public NBTest(){
	}

	public Selector  getSelector() throws Exception{
	

	//使用Selector
	Selector selector = Selector.open();

	//建立Channel 并绑定到9000端口
	ServerSocketChannel ssc = ServerSocketChannel.open();
	InetSocketAddress address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9000);
	ssc.socket().bind(address);

	//使设定non-blocking的方式。
	ssc.configureBlocking(false);

	//向Selector注册Channel及我们有兴趣的事件
	SelectionKey s = ssc.register(selector, SelectionKey.OP_ACCEPT);
	printKeyInfo(s);
	return selector;
	
}

	public void listern(Selector selector){
		try {
			while(true) //不断的轮询
			{
					selector.select();
		            Set<SelectionKey> keys = selector.selectedKeys();  
		            Iterator<SelectionKey> iter = keys.iterator();  
		            while (iter.hasNext()) {   
		                SelectionKey key = (SelectionKey) iter.next();   
		                iter.remove();   
		                try {
							process(key);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		                Thread.sleep(1000);
		            }   
				
				debug("NBTest: Starting select");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

	private void process(SelectionKey key) throws IOException {
		Charset cs = Charset.forName("GBK");
		CharsetDecoder decoder = cs.newDecoder();
		CharsetEncoder encoder = cs.newEncoder();
		ByteBuffer   buffer=ByteBuffer.allocate(1024);
		// TODO Auto-generated method stub
		//Selector通过select方法通知我们我们感兴趣的事件发生了。
		// 接收请求  
	    if (key.isAcceptable()) {  
	        ServerSocketChannel server = (ServerSocketChannel) key.channel();  
	        SocketChannel channel = server.accept();  
	        channel.configureBlocking(false);  
	        channel.register(selector, SelectionKey.OP_READ);  
	    }  
	    // 读信息  
	    else if (key.isReadable()) {  
	        SocketChannel channel = (SocketChannel) key.channel();   
	        int count = channel.read(buffer);   
	        if (count > 0) {   
	            buffer.flip();   
	            CharBuffer charBuffer = decoder.decode(buffer);   
	            String name = charBuffer.toString();   
	            SelectionKey sKey = channel.register(selector, SelectionKey.OP_WRITE);   
	            sKey.attach(name);   
	        } else {   
	            channel.close();   
	        }   
	        buffer.clear();   
	    }  
	    // 写事件  
	    else if (key.isWritable()) {  
	        SocketChannel channel = (SocketChannel) key.channel();   
	        String name = (String) key.attachment();   
	          
	        ByteBuffer block = encoder.encode(CharBuffer.wrap("Hello " + name));   
	        if(block != null)  
	        {  
	            channel.write(block);  
	        }  
	        else  
	        {  
	            channel.close();  
	        }  
	  
	     }  
	}

	private static void debug(String s){
			System.out.println(s);
	}


	private static void printKeyInfo(SelectionKey sk)
	{
		String s = new String();
	
		s = "Att: " + (sk.attachment() == null ? "no" : "yes");
		s += ", Read: " + sk.isReadable();
		s += ", Acpt: " + sk.isAcceptable();
		s += ", Cnct: " + sk.isConnectable();
		s += ", Wrt: " + sk.isWritable();
		s += ", Valid: " + sk.isValid();
	 	s += ", Ops: " + sk.interestOps();
	 	debug(s);
	}


	/**
	* @param args the command line arguments
	*/
	public static void main (String args[]){
		NBTest nbTest = new NBTest();
		try{
			selector=	nbTest.getSelector();
			nbTest.listern(selector);
		}
		
		catch(Exception e){
		  e.printStackTrace();
	  }
	}

}