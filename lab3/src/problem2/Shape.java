package problem2;

abstract class Shape {
	final static double PI = 3.14159;
	private String color;
	
	public Shape(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	abstract public double volume();
	
	abstract public double surfaceArea();
	
	public static double circleArea(double radius) {
		return radius * radius * PI;
	}
	
	public static double squareArea(double edge) {
		return edge * edge;
	}
}
