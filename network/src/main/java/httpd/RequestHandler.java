package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream 이미지, txt도 보내야하기 때문에 파이프 x
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());
			String request = null;

			// 요청하는 자원에 대한 정보 입력
			while (true) {
				String line = br.readLine();

				// 1-1. 브라우저 연결을 끊으면
				if (line == null) {
					break;
				}

				// 1-2. SimpleHttpServer는 요청의 헤더만 처리한다. (Body X)
				if ("".equals(line)) {
					break;
				}

				// 1-3. 요청 헤더의 첫 번째 라인만 읽음
				if (request == null) {
					request = line;
					break;
				}
				// 요청 처리
				// consoleLog(request);
				/* http는 연결한 다음 응답한 후 서버가 응답을 끊어버려야 함 */

				String[] tokens = request.split(" ");
				if ("GET".equals(tokens[0])) {
					consoleLog(request);
					reponseStaticResource(outputStream, tokens[1], tokens[2]);
				} else {
					// methods: POST, PUT, DELETE, HEAD, CONNECT
					// 많이 쓰는 거 POST GET PUT DELETE (QRUD)
					// SimpleHttpServer에서는 무시(400 Bad Resquest | 모든 통신은 request response)
					/**
					 * 과제 reponse400Eroor(outputStream, tokens[2]);
					 */
				}
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
			// outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
			// outputStream.write("Content-Type:text/html;
			// charset=utf-8\r\n".getBytes("UTF-8"));
			// outputStream.write("\r\n".getBytes());
			// outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된
			// 것입니다.</h1>".getBytes("UTF-8"));

		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void reponseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {

		// default(welcome) file set
		if ("/".equals(url)) {
			url = "/index.html";
		}
		File file = new File(DOCUMENT_ROOT + url);

		// nio(New IO)
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		// 응답
		outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
		outputStream.write(("Content-Type: " + contentType +"; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	public void consoleLog(String message) {
		System.out.println("[http#" + getId() + "] " + message);
	}
}
