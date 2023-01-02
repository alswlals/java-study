package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			System.out.println("닉네임을 입력하세요");
			scanner = new Scanner(System.in);
			String nickname = scanner.nextLine();
			
			/* 1. socket 생성 */
			socket = new Socket();
			
			/* 2. 연결*/
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");
			
			/* 3. Reader|Writer 생성*/
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			pw.println("Join:"+ nickname);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			new ChatClientThread(br).start();
			
			while(true) {
				System.out.println("> ");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					pw.println("quit:");
					break;
				} else {
					pw.println("message: " + input);
//					System.out.println(nickname+":"+input);
				}
			}
			
		} catch (IOException ex){
			log("Error: " + ex);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				} else if(scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				System.out.println("error: " + e);
			}
		}
	}
	
	private static void log(String message) {
		System.out.println("[ChatClient]" + message);
	}
}
