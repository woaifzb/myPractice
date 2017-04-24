package fzb.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Snippet {
	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();  
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));  
		Selector selector = Selector.open();
		socketChannel.configureBlocking(false);
		SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
		while(true) {
		  int readyChannels = selector.select();
		  if(readyChannels == 0) continue;
		  Set selectedKeys = selector.selectedKeys();
		  Iterator keyIterator = selectedKeys.iterator();
		  while(keyIterator.hasNext()) {
		    SelectionKey selectionKey = (SelectionKey) keyIterator.next();
		    if(key.isAcceptable()) {
		        // a connection was accepted by a ServerSocketChannel.
		    } else if (selectionKey.isConnectable()) {
		        // a connection was established with a remote server.
		    } else if (selectionKey.isReadable()) {
		        // a channel is ready for reading
		    } else if (selectionKey.isWritable()) {
		        // a channel is ready for writing
		    }
		    keyIterator.remove();
		  }
		}
	}
	
}

