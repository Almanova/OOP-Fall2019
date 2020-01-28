package lab1;

public class problem5 {
	public static void main(String []args) {
		int InitBalance = 100;
		System.out.println("Initial Balance: " + InitBalance);
		Increment(InitBalance);
	}
	
	public static void Increment(int InBal) {
		double Interest;
		Interest = InBal + InBal * 0.05;
		System.out.println("5% interest: " + Interest);
	}
}
