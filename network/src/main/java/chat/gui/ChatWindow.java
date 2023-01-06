package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private String nickname;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		nickname = name;

		socket = new Socket();
		try {
			socket.connect(new InetSocketAddress("127.0.0.1", 8000));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			pw.println("join:" + name);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		} catch (Exception e) {
			updateTextArea("비정상 종료입니다.");
			finish();
		}

	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);

		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		// enter
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false); // readOnly
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// IOSTream 받아오기 구현
		// ChatClientThread 생성 후 실행

		new ChatClientThread().start();
	}

	private void finish() {
		// quit protocol 구현
		if ("quit".equals(textField.getText()) || !socket.isClosed() || socket != null) {
			System.exit(0);
			try {
				socket.close();
			} catch (Exception e) {
				updateTextArea("socket close error");
			}
		}

		// eixt java(Application)
		System.exit(0); // 0 -> 종료 | 인티저 값 반환
	}

	private void sendMessage() {
		String message = textField.getText();
		// System.out.println("메세지 보내는 프로토콜 구현: " + message);

		textField.setText("");
		textField.requestFocus();

		if (message == null || "quit".equals(message)) {
			finish();
		} else if (!"".equals(message)) {
			updateTextArea(nickname + ":" + message);
			pw.println("message:" + nickname + ">>" + message);
		}
	}

	private void updateTextArea(String message) {
		textArea.append(message + "\n");
	}

	private class ChatClientThread extends chat.ChatClientThread {
		public ChatClientThread() {
			super(br);
		}

		@Override
		public void print(String msg) {
			updateTextArea(msg);
		}

		@Override
		public void log(String str) {
			updateTextArea("error: " + str);
		}

	}
}
