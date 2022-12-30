package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			System.out.println("닉네임을 입력하세요");
			String nickName = scanner.nextLine();
			
			/* 1. socket 생성 */
			socket = new Socket();
			socket.connect(InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UFT_8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF_8"));
			
			while(true) {
				System.out.println("> ");
				scanner = new Scanner(System.in);
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					log("");
				}
				
				
			}
			
		} catch (IOException ex){
			log("Error: " + ex);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static void log(String message) {
		System.out.println("[ChatClient]" + message);
	}
}
