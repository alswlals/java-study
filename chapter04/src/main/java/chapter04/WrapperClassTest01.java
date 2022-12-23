package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하면 heap 상에 객체가 존재하게 된다.
		// 리터럴을 사용하게 되면 JVM 안의 Constant Pool이 관리한다. 
		Integer i = new Integer(10); //조만간 없어질 거니까 쓰지 마라 라는 뜻
		Character c = new Character('c');
		Float f = new Float(3.14);
		Boolean b = new Boolean(true);
		
		// Auto Boxing 자동으로 개입해서 클래스 완성
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2);
		System.out.println(j2.equals(j1));
		
		// Auto Unboxing
		// int m = j1.intValue() + 10;
		int m = j1 + 10;
	}

}
