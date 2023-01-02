package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ChatClientThread extends Thread {

	private BufferedReader br;
	private Socket socket;

	public ChatClientThread(BufferedReader br) {
		this.br = br;

	}

	@Override
	public void run() {
		try {
			socket = new Socket();
			while (true) {
				String data = br.readLine();
				if (data.equals("Quit")) {
					log("closed by client");
					break;
				} else {
					System.out.println(data);
				}
			}
		} catch (IOException e) {
			log("BufferedReader error: " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void log(String str) {
		System.out.println("[server] " + str);
	}
}
