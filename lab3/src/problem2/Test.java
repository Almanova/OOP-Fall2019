package problem2;

public class Test {

	public static void main(String []args) {
		Sphere s = new Sphere("gold", 4);
		System.out.println(s.volume());
		Cube c = new Cube("red", 5.5);
		System.out.println(c.volume() + " " + c.surfaceArea());
		Cylinder cyl = new Cylinder("blue", 3, 7);
		System.out.println(cyl.volume() + " " + cyl.surfaceArea());
	}
}
