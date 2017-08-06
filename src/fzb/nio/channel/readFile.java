package fzb.nio.channel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio vs io
 * BufferedInputStream   &&   ByteBuffer
 * @author fzb
 * @since  2017年8月6日 下午3:51:57
 */
public class readFile {
	public static void main(String[] args) throws IOException {
		readByIO();
	}

	
	private static void readByIO() {
		InputStream in = null;
		 try {
			in = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\read.txt"));
			byte buf[] = new byte[1024];
			int byteRead = in.read(buf);
			while (byteRead != -1) {
				int i = 0;
				while (i < byteRead) {
					System.out.print((char) buf[i]);
					i++;
				}
				byteRead = in.read(buf);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		 finally{
			 if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
	}
	
	
	private static void readByNIO() throws FileNotFoundException, IOException {
		RandomAccessFile aFile = new RandomAccessFile(System.getProperty("user.dir")+"\\read.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	
}

