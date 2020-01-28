package task1;

import java.lang.Math;

public class Square extends Shape {
	private double edge;
	
	public Square(Color color, int x, double edge) {
		super(color, x);
		this.edge = edge;
	}
	
	public double getEdge() {
		return edge;
	}
	
	public double getDiagonal() {
		return edge * edge * Math.sqrt(2);
	}
	
	public void draw() {
		if (getColor() == Color.BLACK)
			System.out.println(countPosition("[]"));
		else 
			System.err.println(countPosition("[]"));
	}
}
