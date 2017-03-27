package fzb;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	static class oomObject{}
	public static void main(String[] args) {
		List<oomObject> list =new ArrayList<oomObject>();
		while(true){
			list.add(new oomObject());
		}
	}
}
