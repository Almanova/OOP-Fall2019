package problem4;

import java.util.*;

/*public class Example4 {
	public static void main(String[] args) {
		ArrayList<Double> operands = new ArrayList<Double>();
		ArrayList<String> operators = new ArrayList<String>();
		double result;
		StringTokenizer tokenizer;
		Scanner in = new Scanner(System.in);
		tokenizer = new StringTokenizer(in.nextLine(), "+-*", true);
		try {
			int cnt = 0;
			boolean precendence = false;
			while (tokenizer.hasMoreTokens()) {
				String str = tokenizer.nextToken();
				if (cnt % 2 == 0) {
					try {
						if (precendence == true) {
							double top = operands.get(operands.size() - 1);
							operands.remove(operands.size() - 1);
							if (operators.get(operators.size() - 1).equals("*"))
								top *= Double.parseDouble(str);
							else
								top /= Double.parseDouble(str);
							operators.remove(operators.size() - 1);
							operands.add(top);
							precendence = false;
						} else
							operands.add(Double.parseDouble(str));
					} catch (NumberFormatException nfe) {
						System.out.println("Operand " + str + " is not a number");
						break;
					}
				} else {
					if (str.equals("*") || str.equals("/")) {
						operators.add(str);
						precendence = true;
					} else
						operators.add(str);
				}
				cnt++;
			}
			result = operands.get(0);
			for (int i = 0; i < operators.size(); i++) {
				if (operators.get(i).equals("+"))
					result += operands.get(i + 1);
				else
					result -= operands.get(i + 1);
			}
			System.out.println("Result: " + result);
		} catch (IndexOutOfBoundsException ibe) {
			System.out.println("Invalid syntax");
		} catch (NoSuchElementException nsee) {
			System.out.println("Invalid syntax");
		} catch (NumberFormatException nfe) {
			System.out.println("Operand(s) is not a number");
		}
	}
}*/

public class Example4 {
	public static void main(String[] args) {
		ArrayList<String> expressions = new ArrayList<String>();
		double leftOperand = 0, result, rightOperand = 0;
		String leftString, operator, rightString;
		StringTokenizer tokenizer1, tokenizer2;
		Scanner in = new Scanner(System.in);

		tokenizer1 = new StringTokenizer(in.nextLine(), " ");

		while (tokenizer1.hasMoreTokens()) {
			expressions.add(tokenizer1.nextToken());
		}

		for (int i = 0; i < expressions.size(); i++) {
			tokenizer2 = new StringTokenizer(expressions.get(i), "+-*/", true);
			try {
				leftString = tokenizer2.nextToken();
				operator = tokenizer2.nextToken();
				rightString = tokenizer2.nextToken();

				try {
					leftOperand = Double.parseDouble(leftString);
					rightOperand = Double.parseDouble(rightString);
					if (operator.equals("+"))
						result = leftOperand + rightOperand;
					else if (operator.equals("-"))
						result = leftOperand - rightOperand;
					else if (operator.equals("*"))
						result = leftOperand * rightOperand;
					else if (operator.equals("/"))
						result = leftOperand / rightOperand;
					else
						result = 0.0;
					System.out.println("Result: " + result);
				} catch (NumberFormatException nfe) {
					if (leftOperand == 0)
						System.out.println("Operand " + leftString + " is not a number");
					else
						System.out.println("Operand " + rightString + " is not a number");
				}
			} catch (NoSuchElementException nsee) {
				System.out.println("Invalid syntax");
			}
		}
	}
}
