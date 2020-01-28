package task1;

abstract class Shape {
	private Color color;
	private int x;
	
	public Shape(Color color, int x) {
		this.color = color;
		this.x = x;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getX() {
		return x;
	}
	
	abstract void draw();
	
	public void draw(int cnt) {
		for (int i = 0; i < cnt; i++)
			draw();
	}
	
	public String countPosition(String sign) {
		String output = "";
		for (int i = 0; i < getX(); i++)
			output += " ";
		output += sign;
		return output;
	}
}
