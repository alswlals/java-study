package chat.guie;
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

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
//		buttonSend.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed( ActionEvent actionEvent ) {
				//console log 처리 확인하기
//				System.out.println("!!!!!!!");
//				sendMessage();
//			}
//		});
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});/**이벤트를 등록? 리스너를 많이 등록할 수 있다 어노니멈스클로ㅡ?
		 	* String s = new A().m(80);*/
		
//		buttonSend.addActionListener((e) -> sendMessage());
		
		// Textfield
		textField.setColumns(80);
		//enter
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
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
		textArea.setEditable(false);  //readOnly
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		// x 눌렀을 때 화면 종료
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		//IOSTream 받아오기 구현
		// ChatClientThread 생성 후 실행
	}
	private void finish() {
		// quit protocol 구현
		if("quit".equals(textField)) {
			System.exit(0);
		}
		// eixt java(Application)
		System.exit(0); // 0 -> 종료 | 인티저 값 반환
	}
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현: " + message);
		
		textField.setText("");
		textField.requestFocus();
		
		// ChatClientThread 에서 서버로부터 받은 메세지가 있다 치고
		updateTextArea("nickName : " + message);
		
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			//String message = br.readLine();
			//
			//
			updateTextArea("안녕");
		}
	}
}
