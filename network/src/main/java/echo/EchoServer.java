package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	/* 넣는 이유 : */
	public static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", 8000));
			log("starts..... [port: " + PORT + "]");

			Socket socket = serverSocket.accept();

			/* 정보 빼오기 */
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			try {
				/*
				 * BufferedReader로 보내주기 때문에 개행 필수(경계 | 문자 x) 읽을 수 있게 보장은 해주지만 그대로 읽게는 안해줌 true
				 * 사용 이유: 버퍼를 사용할 때 즉시 비워줘라(다 찰때까지 기다리지 말고)
				 */
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

				while (true) {
					String data = br.readLine(); /* 꼭 개행을 붙여라 */
					if (data == null) {
						log("closed by client");
						break;
					}
					log("received:  " + data);
					pw.println(data + "\n");
				}
			} catch (SocketException ex) {
				System.out.println("[server]suddenly closed by client");
			} catch (IOException ex) {
				log("error: " + ex);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
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
		System.out.println("[EchoServer] " + message);
	}
}
