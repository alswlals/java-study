package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickname;
	String message;
	List<Writer> listWriters;
	PrintWriter printWriter;
	Writer writer;
	
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		listWriters = new ArrayList<Writer>();
	}

	/* 요청 처리를 위한 Loop */
	@Override
	public void run() {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();

		ChatServer.log("connected by client [ " + remoteHostAddress + "/" + remoteHostPort + "]");
		
		try {
			/* 1. Stream 얻기*/
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UFT_8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF_8"));
	
			/* 2. 요청 처리*/
			
			while(true) {
				String request = br.readLine();
				if(request == null) {
					log("Client로부터 연결이 끊겼습니다.");
					break;
				}
				
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if("quit".equals(tokens[0])) {
					doQuit();
				} else {
					ChatServer.log("Error: 알 수 없는 요청("+tokens[0]+")");
				}
				
				
				
			}
		} catch(SocketException ex) {
			
		}
	}

	

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;
		String data = nickName+"님이 참여하였습니다.";
		broadcast(data);
		addWriter(writer);
		printWriter.println("join:ok");
	}
	private void addWriter() {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
	private void broadcast(String data) {
		synchronized(Writer writer : listWriters) {
			PrintWriter printWriter = (PrintWriter)writer;
			printWriter.println(data);
		}
	}
	
	
	private void doMessage(String message) {
		this.message = message;
		
	}
	private void doQuit() {
			removeWriter(writer);
			String data = nickname + "님이 퇴장하였습니다.";
			broadcast(data);
			
		}
	
	private void log(String message) {
		System.out.println("[ChatServer#" + getId() + "] " + message);
	}

}
