package fzb.decorate.myIO;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.print.DocFlavor.URL;

public class InputTest {
	public static void main(String[] args) {
		int c;
	//	System.out.println( InputTest.class.getClassLoader().getResource("").getPath());
	//	System.out.println( System.getProperty("user.dir"));
		try {
			
				InputStream is=	new LowerCaseInputStream(new BufferedInputStream( 
						new FileInputStream(System.getProperty("user.dir")+"\\test.txt")));
				while((c=is.read())>0){
					System.out.print((char)c);
				}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
