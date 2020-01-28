package task4;

import java.util.Arrays;

public class MinMax {
	
	static class MinMaxPair {
		int min;
		int max;
		
		public MinMaxPair(int min, int max) {
			this.min = min;
			this.max = max;
		}
		
		public String toString() {
			return "Min: " + min + ", Max: " + max;
		}
	}
	
	static MinMaxPair minmax(int values[]) {
		Arrays.sort(values);
		return new MinMaxPair(values[0], values[values.length - 1]);
	}
}
