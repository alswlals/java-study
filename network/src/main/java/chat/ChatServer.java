package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8000;
	
//	new ChatServer.start();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();
		
		try {
			serverSocket = new ServerSocket();

//			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결되었습니다. [PROT:" + PORT + "]");
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
//				log("연결되었습니다.");
			}
		} catch (SocketException e) {
			log("suddenly closed by client"+e);
		} catch (IOException e) {
			log("error:" + e);
		} finally {
				try {	
					if(serverSocket != null && !serverSocket.isClosed()) {	
						serverSocket.close();
					}
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	static void log(String message) {
		System.out.println("[ChatServer#" +  message);
	}

}
