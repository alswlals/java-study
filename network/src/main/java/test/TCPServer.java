package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();

			// 1-1. FIN_WAIT -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록 하기 위해 설정
			serverSocket.setReuseAddress(true);
			
			// 2. 바인딩 (binding)
			// Socket에 InetSocketaddress(IPAddress + Port)를 바인딩 한다.
			// IPAddress: 0.0.0.0: 특정 호스트 IP에 바인딩 하지 않는다.
			// 뒤에 숫자는 입력된 값까지 처리된다? ex) 10이면 11번째 accept - connection없이 켁 죽어있음
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);
			/* 확정 Ip 지정 x , */
			// serverSocket.bind(new InetSocketAddress("192.168.10.25", 5000));
			// serverSocket.bind(new
			// InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), 5000));

			// 3. accept
			// serverSocket.accept(); /* blocking*/
			Socket socket = serverSocket.accept(); /* blocking */

			// 데이터소캣이시작되는곳
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();

				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
				// 결과 : [server] connected by client[192.168.10.14:51387]
				// socket.getOutputStream();

				// 4. IO Stream 받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();

				while (true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					// is.read(buffer); // blocking
					int readByteCount = is.read(buffer); // blocking
					if (readByteCount == -1) {
						//클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[sever] closed by client");
						break;
					}

					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received:  " + data);
					
					// 6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
			} catch (SocketException ex) {
				System.out.println("[server]suddenly closed by client");
			} catch (IOException ex) {
				System.out.println("[server]error: " + ex);
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
			System.out.println("[server] error: " + e);
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
}
