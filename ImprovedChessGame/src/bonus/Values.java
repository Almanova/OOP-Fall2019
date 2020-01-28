package bonus;

import java.lang.Math;

public class Values {
	private int miny;
	private int maxy;
	private int minx;
	private int maxx;
	
	public Values(Position a, Position b) {
		setValues(a, b);
	}
	
	public void setValues(Position a, Position b) {
		this.miny = Math.min(a.getY(), b.getY());
		this.maxy = Math.max(a.getY(), b.getY());
		this.minx = Math.min(a.getX(), b.getX());
		this.maxx = Math.max(a.getX(), b.getX());
	}
	
	public int getMinY() {
		return miny;
	}
	
	public int getMaxY() {
		return maxy;
	}
	
	public int getMinX() {
		return minx;
	}
	
	public int getMaxX() {
		return maxx;
	}
}
