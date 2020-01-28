package task1;

public class Circle extends Shape{
	private double radius;
	
	public Circle(Color color, int x, double radius) {
		super(color, x);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void draw() {
		if (getColor() == Color.BLACK)
			System.out.println(countPosition("()"));
		else 
			System.err.println(countPosition("()"));
	}
}
