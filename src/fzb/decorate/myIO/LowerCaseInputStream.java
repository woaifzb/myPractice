package fzb.decorate.myIO;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	
	

	protected LowerCaseInputStream(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	public int read(byte b[], int off, int len) throws IOException {
		int result = super.read();
		return result;
	}
	public int read()throws IOException{
		int c=super.read();
		return (c==-1? c: Character.toLowerCase(c));
	}

}
