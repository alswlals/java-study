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
			while (true) {
				String data = br.readLine();

				if (data == null || "".equals(data)) {
					log("server로부터 연결이 끊겼습니다.");
					break;
				} else if (data.equals("quit")) {
					log("closed by client");
					break;
				} else {
					print(data);
				}
			}
			System.out.println("check");
		} catch (IOException e) {
			log("오류 발생" + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					log("buffer close error");
				}
			}

		}
	}

	public void print(String msg) {
		System.out.println(msg);
	}

	public void log(String str) {
		System.out.println("error: " + str);
	}
}
