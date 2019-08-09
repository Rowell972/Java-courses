import java.util.Scanner;


public class InteractRunner {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);

		try {
			Calculator calc = new Calculator();
			System.out.println("Enter first argument: ");
			String first = scaner.next();
			String exit = "no";
			String cleanResult = "no";
			while(!exit.equals("yes")) {
				System.out.println("Enter second argument: ");
				String second = scaner.next();
				System.out.println("Enter operand: ");
				String answer = scaner.next();
				switch (answer) {
				case ("+") :
					calc.add(Integer.parseInt(first), 
							Integer.parseInt(second));
					System.out.println("Result: " + calc.getResult());
					break;
				case ("-") :
					calc.sub(Integer.parseInt(first), 
							Integer.parseInt(second));
					System.out.println("Result: " + calc.getResult());
					break;
				case ("*") :
					calc.mult(Integer.parseInt(first), 
							Integer.parseInt(second));
					System.out.println("Result: " + calc.getResult());
					break;
				case ("/") :
					calc.div(Integer.parseInt(first), 
							Integer.parseInt(second));
					System.out.println("Result: " + calc.getResult());
					break;
				}
				System.out.println("Clean result? yes/no");
				cleanResult = scaner.next();
				if (cleanResult.equals("yes")) {
					calc.cleanResult();
					System.out.println("Enter first argument: ");
					first = scaner.next();
				}
				System.out.println("Exit? yes/no");
				exit = scaner.next();
			}
		} finally {
			scaner.close();
		}
	}
}
