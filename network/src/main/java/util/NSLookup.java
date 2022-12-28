package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {

		/* 주소 입력하기 */
		Scanner sc = new Scanner(System.in);
		/**
		 * 이렇게 써주지 않는 이유는 아래 배열에서 이미 값을 지정해줬기 때문 InetAddress inetAddress[] = null;
		 */

		/* 반복해주기 */
		while (true) {
			try {
				System.out.print(">> ");
				String line = sc.nextLine();
				
				if ("exit".equals(line)) {
					System.out.println("end");
					break;
				}
				
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);	

				for (InetAddress inetAddress : inetAddresses)
					System.out.println(inetAddress.getHostName() + ":" + inetAddress.getHostAddress());
			} catch (UnknownHostException e) {
				System.out.println("Domain Missing");
			}
		}
	}

}
