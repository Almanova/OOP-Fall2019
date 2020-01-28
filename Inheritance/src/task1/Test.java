package task1;

import java.util.Vector;

public class Test {
	public static void main (String []args) {
		Vector<Shape> v = new Vector<Shape>();
		v.add(new Circle(Color.RED, 5, 5));
		v.add(new Square(Color.BLACK, 1, 7));
		v.add(new Triangle(Color.RED, 12, 4, 4, 4));
		for (Shape s: v) {
			s.draw();
			s.draw(5);
			if (s instanceof Circle)
				System.out.println(((Circle)s).getRadius());
			else if (s instanceof Square) 
				System.out.println(((Square)s).getDiagonal());
			else
				System.out.println(((Triangle)s).isEquilateral());
		}
	}
}
