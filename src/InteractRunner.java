import java.util.Scanner;


public class InteractRunner {
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		
		try {
			Calculator calc = new Calculator();
			String exit = "no";
			while(!exit.equals("yes")) {
				System.out.println("Enter first argument: ");
				String first = scaner.next();
				System.out.println("Enter second argument: ");
				String second = scaner.next();
				calc.add(Integer.parseInt(first), Integer.parseInt(second));
				System.out.println("Result: " + calc.getResult());
				calc.cleanResult();
				System.out.println("Exit: yes/no");
				exit = scaner.next();
			}
		} finally {
			scaner.close();
		}
	}
}
