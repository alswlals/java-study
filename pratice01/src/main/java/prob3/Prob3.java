package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("수를 입력하세요 : ");
		int num = scanner.nextInt();
		int sum = 0;
		
		if(num % 2 == 1) {
			for(int i = 1; i<=num; i+=2) {
				sum += i;
			}
		}else {
			for(int i = 2; i<=num; i+=2) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
		
}

//int even = 0;
//int odd = 0;
//System.out.println(num % 2 == 0 ? even : odd) ;


//int sum = 0;
//
//for (int i = 1; i <= num; i++) {
//	if(i % 2 == 0) {
//		sum +=i;	
//	}else if(i % 2 != 0){
//		sum += i;
//	}
//}
//System.out.println(sum);
		
		//		int number = scanner.nextInt();
//		int sum = 0, i;
//		for(i = 1; i <=number; i++) {
//			if (i%2==0) {
//				sum += i;
//				System.out.println(sum);
//			}else {
//				sum += i;
//				System.out.println(sum);
//			}
//		}
//			
		
//			System.out.print("수를 입력하세요 : ");
//			int number = scanner.nextInt();
//			int sum = 0;
//			int odd = 0;
//			
//			for(int i = 1; i <=number; i++) {
//				if (i%2==0) {
//					sum += i;
//				}
//			}
//			for(int i = 1; i<=number; i++) {
//				if(i%2 != 0) {
//					odd +=i;
//				}
//			}
//			System.out.println(sum);
//			System.out.println(odd);
//		

