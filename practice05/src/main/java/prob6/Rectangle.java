package prob6;

public class Rectangle extends Shape implements Resizable{

	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
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

	@Override
	public void resize(double s) {
		this.width = width*s;
		this.height = height*s;
		
		
	}

}
