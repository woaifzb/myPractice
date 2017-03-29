package fzb.SocketChat;


import java.util.Vector;

public class ChatManager {
	public static ChatManager cm=new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	private Vector<ChatSocket> chatVector=new Vector<ChatSocket>();
	public void add(ChatSocket cs){
		chatVector.add(cs);
	}
	public void publich(ChatSocket cs,String out){
		for(int i=0;i<chatVector.size();i++){
			if(!cs.equals(chatVector.get(i))){
				chatVector.get(i).output(out);
			}
		}
	}
}
