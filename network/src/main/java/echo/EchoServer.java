package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/* 넣는 이유 : */
	public static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", 8000));
			log("starts..... [port: " + PORT + "]");

			while(true) {
				Socket socket = serverSocket.accept();
				/*EchoRequestHandler 파일에서 socket 정보를 받아옴*/
				new EchoRequestHandler(socket).start();
			}
			//여기서부터 스레드 가넝
			
			
			//여기까지 스레드 가넝
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static void log(String message) {
		System.out.println("[EchoServer#" + Thread.currentThread().getId()+ "] " + message);
	}
}
