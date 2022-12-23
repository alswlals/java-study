package execption;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("Some Code 1...");
		try {
			System.out.println("Some Code 2... : file open");
			System.out.println("Some Code 3...");
			
			int result = (1+2+3)/b;
			
			System.out.println("Some Code 4...");
			System.out.println("Some Code 5...");
			
		} catch(ArithmeticException ex) {
			/* 예외 처리 */
			// 1. 로깅
			System.out.println("error:" + ex);
			
			// 2. 사과
			System.out.println("Sorry");
			
			// 3. 정상종료
			return;
			// System.exit(0); //0은 에러코드에서 정상종료(바깥으로 던져주기)/ 1,2는 에러
			
			// ex.printStackTrace();
		} finally {
			System.out.println("자원 정리 예: file close...");
		}
		System.out.println("Some Code 6...");
		System.out.println("Some Code 7...");
		
	}

}
