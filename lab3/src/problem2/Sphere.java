package problem2;

public class Sphere extends Shape {
	private double radius;
	
	public Sphere(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double volume() {
		return super.circleArea(radius) * radius * 4.0/3.0;
	}
	
	public double surfaceArea() {
		return super.circleArea(radius) * 4;
	}
}
