package chat.gui;

import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			if (name == "" || name == null || name.matches(".*[^a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣1-9].*")) {
				System.out.println("잘못된 입력입니다. 특수문자를 제외한 문자로 다시 입력해주세요.");
				continue;
			}

			if (!name.isEmpty()) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");

		}
		new ChatWindow(name).show();
		scanner.close();

	}

}
