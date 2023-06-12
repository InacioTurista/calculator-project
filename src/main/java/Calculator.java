import java.util.Scanner;

class Calculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		System.out.println("------ CALCULATOR ------");
		
		System.out.println("Examples of counts: ");
		System.out.println("'1 + 1' (will result in 2)");
		System.out.println("'2.5 - 1' (will result in 1.5)");
		System.out.println("'2 * 1' (will result in 2)");
		System.out.println("'2.8 / 2' (will result in 1.4)");
		System.out.println("'10 % 500' (will result in 50)");
		
		while (running) {
			System.out.print("Enter the expression (or 'q' to quit): ");
			String input = scanner.nextLine();
			
			if (input.equalsIgnoreCase("q")) {
				running = false;
				continue;
			}
			
			String[] tokens = input.split(" ");
			if (tokens.length != 3) {
				System.out.println("Invalid expression. Please provide an expression like the examples.");
				continue;
			}
			double operand1 = Double.parseDouble(tokens[0]);
			double operand2 = Double.parseDouble(tokens[2]);
			String operator = tokens[1];
			
			double result = 0.0;
			boolean isValid = true;
			
			switch (operator) {
				case "+":
					result = operand1 + operand2;
					break;
				case "-":
					result = operand1 - operand2;
					break;
				case "*":
					result = operand1 * operand2;
					break;
				case "/":
					if (operand2 != 0) {
						result = operand1 / operand2;
					} else {
						System.out.println("Division by zero it not allowed.");
						isValid = false;
					}
					break;
				case "%":
					result = (operand1 * operand2) / 100;
					break;
				default:
					System.out.println("Invalid operator. Please use one that is on the examples.");
					isValid = false;
					break;
			}
			
			if (isValid) {
				System.out.println("Result: " + result);
			}
			System.out.println();
		}
		
		scanner.close();
	}
}