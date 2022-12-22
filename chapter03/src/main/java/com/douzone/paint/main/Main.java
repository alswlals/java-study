package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.ColorPoint;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

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
		
//		drawPoint(point1); //아래 static drawrPoint 구현 후 진행
//		point1.disapear();
		draw(point1);
		point1.show(false);


		Point point2 = new ColorPoint(20, 20, "red");

		//Point point2 = new ColorPoint(20, 20, "red"); 이거 사용하고 싶을 떄 
//		point2.setX(20);
//		point2.setY(20);
//		((ColorPoint)point2).setColor("red");
		
//		drawPoint(point2);
		draw(point2);
		
		
		
		
		Rect rect = new Rect();
//		drawRect(rect);
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawTriangle(triangle);
//		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
//		drawCircle(circle);
//		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("Hello World"));
		
		
		// instanceof 연산자 Test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		//instance 관계에서 가능한 건 하이라이터 ? 밖에 없음 이때 조건은 
		//래퍼런스 하고 있는 객체가 있으면 그 타입으 하이라이키? 바로위에잇는녀석만물어보기가능
		//근데 만일 Object s =  라고 하면 Object의 있는  건 다 부를 수 있음
		
		// 오류 : 연산자 우측항이 클래스인 경우,
		// 		 레퍼런스하고 있는 class type의 hierachy상의 하위와 상위만
		//		 instanceof 연산자를 사용할 수 있다.
//		System.out.println(circle instanceof Rect);
		Object o = circle; // up casting
		System.out.println(o instanceof String);
		
		// 연산자 우측항이 인터페이스인 경우,
		// Hierachy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	
//	public static void drawColorPoint(ColorPoint ColorPoint) {
//		colorPoint.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	public static void drawCricle(Cricle cricle) {
//		cricle.draw();
//	}
}
