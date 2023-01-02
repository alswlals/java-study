package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8000;
	private static List<Writer> listWriters = new ArrayList<Writer>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			/* 1. 서버 소켓 생성*/
			serverSocket = new ServerSocket();
			
			/* 2. 바인딩*/
			/* 2-1. 주소뽑기*/
//			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
//			log("연결되었습니다." + hostAddress + ":" + PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
				log("연결되었습니다.");
			}
		} catch (IOException e) {
			log("server error: " + e);
		} finally {
			{
				try {
					if(serverSocket != null && !serverSocket.isClosed()) 
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	static void log(String message) {
		System.out.println("[ChatServer#" +  message);
	}

}
