package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickname;
	List<Writer> listWriters;
	PrintWriter pw;
	BufferedReader br;
	
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	@Override
	public void run() {
//		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
//		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
//		int remoteHostPort = inetRemoteSocketAddress.getPort();

//		ChatServer.log("connected by client [ " + remoteHostAddress + "/" + remoteHostPort + "]");
		
		try {
			/* 1. Stream 얻기*/
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
	
			/* 2. 요청 처리*/
			
			while(true) {
				String request = br.readLine();
				if(request == null) {
					log("Client로부터 연결이 끊겼습니다.");
					doQuit(pw);
					break;
				}
				
				String[] tokens = request.split(":");
				//switch 문 해보기
//				if("join".equals(tokens[0])) {
//					doJoin(tokens[1], pw);
//				} else if("message".equals(tokens[0])) {
//					doMessage(tokens[1], pw);
//				} else if("quit".equals(tokens[0])) {
//					doQuit();
//				} else {
//					log("Error: 알 수 없는 요청("+tokens[0]+")");
//				}
//				System.out.println("tokens[0]"+tokens[0]);
//				System.out.println("tokens[1]"+tokens[1]);
				switch (tokens[0]) {
				case "join" : 
					doJoin(tokens[1],pw);
					break;
				case "message" :
					doMessage(tokens[1]);
					break;
				case "quit" :
					doQuit(pw);
					break;
				}
				
			}
		}
//		catch (SocketException ex) {
//			System.out.println("[server]suddenly closed by client");
//		} catch (UnsupportedEncodingException e) {
//			ChatServer.log("에러: " + e);
//		}
		catch(IOException ex) {
			log("error:" + ex);
		}  finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	}

	

	private void doJoin(String nickName,  PrintWriter writer) {
		this.nickname = nickName;
		String data = nickName+"님이 참여하였습니다.";
		broadcast(data);
		addWriter(writer);
		System.out.println(data);
		pw.println("Join:ok");
		
	}
	private void doMessage(String message) {
		broadcast(this.nickname + ":"+ message);
		
	}
	private void doQuit( PrintWriter writer) {
			removeWriter(writer);
			String data = nickname + "님이 퇴장하였습니다.";
			pw.println("quit");			
			broadcast(data);
		}
	
	private void broadcast(String data) {
				
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
			}
		}
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}

	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}
	
	private void log(String message) {
		System.out.println("[ChatServer#" + getId() + "] " + message);
	}

}
