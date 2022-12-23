package prob6;

public class RectTriangle extends Shape {
	
	private double width;
	private double height;
	
	public RectTriangle(double width, double height) {
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		double result = width*height*0.5;
		return result;
	}

	@Override
	public double getPerimeter() {
		double result = width + height + (Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2)));
		return result;
	}
	
	

}
