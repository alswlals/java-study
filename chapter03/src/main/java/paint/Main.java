package paint;

public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 10);
//		Point.java에서 
//		public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//		}
// 		값을 주겠다고 선언해서 오류남, 그래서 아래 point.setX(10)ㅇ ㅒ네 지워줌		
		
		
		
//		point.setX(10);
//		point.setY(10);
		point.show();
		
		point.show(true);
		point.show(false);
//		point.disapear();
	}

}
