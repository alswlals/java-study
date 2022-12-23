package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
												// 출력값(의미)
		
//		Class klass = point.getClass();			// reflection
		System.out.println(point.getClass());
		System.out.println(point.hashCode());	// address 기반의 해싱값        객체 아이디 int 16진수 출력 
												// address x
												// reference x		
		System.out.println(point.toString());	// getClass() + "@" + hashCode() 
		System.out.println(point);
		
		
		
	}

}
