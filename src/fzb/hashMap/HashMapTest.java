/**
 * 
 */
package fzb.hashMap;

import java.util.HashMap;
import java.util.Map;

import fzb.SocketChat.main;

/**
 * @author fzb
 * @since  2019年3月22日 下午3:42:49
 */
public class HashMapTest {
	public static void main(String[] args) {
		
		Map map=new HashMap();
		putDate("test1", "1",map);
		putDate("test2", "2",map);
		putDate("test1", "1",map);
		
	}
	
	private static void putDate(String key, String val,Map map) {
		// TODO Auto-generated method stub
		
		if(map.containsKey(key)){
			System.out.println("exist:"+key);
		}
		else{
			map.put(key, val);
		}
	}

	class MyHashMap extends HashMap{
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

		
	}
}
