package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */
			
			// 정답 랜덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);

			while(true) {
				System.out.println("1-100");
				System.out.print("1>>");
				int answer = scanner.nextInt();
				
				for(int i=0;; i++) {
					if(answer > correctNumber) {
						System.out.println("더 낮게");
					} else if(answer < correctNumber) {
						System.out.println("더 높게");
					} else if(answer == correctNumber) {
						System.out.print( "다시 하겠습니까(y/n)>>" );
						String answer1 = scanner.next();
						if( "y".equals( answer1 ) == false ) {
							break;
						}
					}
				}
//				while(answer != correctNumber) {
//				if (answer < correctNumber) 
//					System.out.print("더 크게");
//				else if(answer > correctNumber)
//					System.out.print("더 작게");
//				
//					break;
//				}
			}
			//새 게임 여부 확인하기
		}
		scanner.close();
	}
}