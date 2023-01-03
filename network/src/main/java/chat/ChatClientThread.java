package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ChatClientThread extends Thread {

	private BufferedReader br;


	public ChatClientThread(BufferedReader br) {
		this.br = br;

	}

	@Override
	public void run() {
		try {
			while (true) {
				String data = br.readLine();
				if (data.equals("quit")) {
					log("closed by client");
					break;
				} else {
					System.out.println(data);
				}
			}
			System.out.println("check");
		} catch (IOException e) {
			log("BufferedReader error: " + e);
		} finally {
		
		}
	}

	private void log(String str) {
		System.out.println("[server] " + str);
	}
}
