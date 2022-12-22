package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
//		Point.java에서 
//		public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//		}
// 		값을 주겠다고 선언해서 오류남, 그래서 아래 point.setX(10)ㅇ ㅒ네 지워줌		
		
		
		
//		point.setX(10);
//		point.setY(10);
//		point.show();
//		
//		point.show(true);
		
		drawPoint(point1); //아래 static drawrPoint 구현 후 진행
//		point1.disapear();
		point1.show(false);


		Point point2 = new ColorPoint(20, 20, "red");

		//Point point2 = new ColorPoint(20, 20, "red"); 이거 사용하고 싶을 떄 
//		point2.setX(20);
//		point2.setY(20);
//		((ColorPoint)point2).setColor("red");
		
		drawPoint(point2);
		
		
		Rect rect = new Rect();
		drawRect(rect);
		
		Triangle triangle = new Triangle();
		drawTriangle(triangle);
	}
	
	public static void drawPoint(Point point) {
		point.show();
	}
	
//	public static void drawColorPoint(ColorPoint ColorPoint) {
//		colorPoint.show();
//	}
	
	public static void drawRect(Rect rect) {
		rect.draw();
	}
	public static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}
}
