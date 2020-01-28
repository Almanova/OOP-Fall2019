package problem2;

public class Cube extends Shape {
	private double edge;
	
	public Cube(String color, double edge) {
		super(color);
		this.edge = edge;
	}
	
	public double getEdge() {
		return edge;
	}
	
	public void setEdge(double edge) {
		this.edge = edge;
	}
	
	public double volume() {
		return super.squareArea(edge) * edge;
	}
	
	public double surfaceArea() {
		return super.squareArea(edge) * 6;
	}
	
	public double faceArea() {
		return super.squareArea(edge);
	}
}
