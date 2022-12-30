package chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static final int PORT = 8000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			/* 1. 서버 소켓 생성*/
			serverSocket = new ServerSocket();
			
			/* 2. 바인딩*/
			/* 2-1. 주소뽑기*/
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 8000));
			log("연결을 기다리고 있습니다." + hostAddress + ":" + PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, null).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	static void log(String message) {
		System.out.println("[ChatServer#" + Thread.currentThread().getId()+ "] " + message);
	}

}
