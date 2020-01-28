package problem2;

public class Cylinder extends Shape{
	private double radius;
	private double height;
	
	public Cylinder(String color, double radius, double height) {
		super(color);
		this.radius = radius;
		this.height = height;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double volume() {
		return super.circleArea(radius) * height;
	}
	
	public double surfaceArea() {
		return super.circleArea(radius) * 2 + Shape.PI * radius * height * 2;  
	}
}
