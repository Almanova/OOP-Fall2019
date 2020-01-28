package task1;

public class Triangle extends Shape {
	private double edge1, edge2, edge3;
	
	public Triangle(Color color, int x, double edge1, double edge2, double edge3) {
		super(color, x);
		this.edge1 = edge1;
		this.edge2 = edge2;
		this.edge3 = edge3;
	}
	
	public void draw() {
		if (getColor() == Color.BLACK)
			System.out.println(countPosition("<|"));
		else 
			System.err.println(countPosition("<|"));
	}
	
	public boolean isEquilateral() {
		return edge1 == edge2 && edge2 == edge3;
	}
}
