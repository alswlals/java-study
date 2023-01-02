package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {
	
	private BufferedReader br;
	
	public ChatClientThread(BufferedReader br) {
		this.br = br;
		
	}

	@Override
	public void run() {
		
			try {
				String data = null;
				
				while(true) {
				data = br.readLine();
				if(data.equals("quit")) {
					log("closed by client");
					break;
				}
				System.out.println(data);
				}
			}catch (IOException e) {
				log("BufferedReader error: e");
		}
			
	}	
	private void log(String str) {
		System.out.println("[server] "+str);
	}
}	
	

