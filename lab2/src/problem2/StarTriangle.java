package problem2;

public class StarTriangle {
	int longest; 
	
	public StarTriangle(int longest) {
		this.longest = longest;
	}
	
	public String toString() {
		String res = "";
		for (int i = 1; i <= longest; i++) {
			for (int j = 1; j <= i; j++) {
				res += "[*]";
			}
			res += "\n";
		}
		return res;
	}
	
	public static void main (String []args) {
		StarTriangle triangle = new StarTriangle(5);
		System.out.print(triangle);
	}
}

