package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );
		System.out.print("금액 : ");
		int won = scanner.nextInt();
		int sett[]=new int[10];
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		for (int i = 0; i < 10; i++) {
			sett[i] = won / MONEYS[i];
			won = won % MONEYS[i];
			System.out.println(MONEYS[i] + "원 : " +sett[i]+"개" );
		}
		//for문
		
		scanner.close();
 	}
}