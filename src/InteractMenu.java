import java.util.Scanner;

public class InteractMenu {

    private String exit;
    private String operand;
    private String firstArgument;
    private String secondArgument;
    private String result;
    private int newResult;
    private Scanner scanner = new Scanner(System.in);
    private final int COUNT_OF_ARGS = 2;
    private int [] args = new int[COUNT_OF_ARGS ];
    private char [] checkArgs = args.toString().toCharArray();
    private boolean isNumber = false;
    private boolean isClose = false;
    private Calculator calculator;


    public void startDialog() {
        System.out.println("Enter first argument: ");
        firstArgument = scanner.next();
        args[0] = Integer.parseInt(firstArgument);
        System.out.println("Enter second argument: ");
        secondArgument = scanner.next();
        args[1] = Integer.parseInt(secondArgument);
    }


    public void conductOperations(int [] args) {
        if (checkInputForNumbers(checkArgs)) {
            System.out.println("Enter operand: ");
            operand = scanner.next();
            calculator = new Calculator();
            switch (operand) {
                case ("+") :
                    calculator.add(args[0], args[1]);
                    System.out.println("Result: " + calculator.getResult());
                    break;
                case ("-") :
                    calculator.sub(args[0], args[1]);
                    System.out.println("Result: " + calculator.getResult());
                    break;
                case ("*") :
                    calculator.mult(args[0], args[1]);
                    System.out.println("Result: " + calculator.getResult());
                    break;
                case ("/") :
                    calculator.div(args[0], args[1]);
                    System.out.println("Result: " + calculator.getResult());
                    break;
            }
            saveResult();
            exitFromCalc();
        } else {
            System.err.println("Your input is not numbers." + "\n" +
                                "Try again!");
            exitFromCalc();
        }
    }


    public void exitFromCalc() {
        System.out.println("Do you want exit? (yes/no)");
        exit = scanner.next();
        if (exit.equals("yes")) {
            isClose = true;
        } else if (exit.equals("no")){
            conductOperations(args);
        } else {
            System.out.println("Wrong input." + "\n" +
                                "Try again");
        }
    }


    public void saveResult() {
        System.out.println("Do you wanna save result? (yes/no)");
        result = scanner.next();
        if (result.equals("yes")) {
            result = String.valueOf(calculator.getResult());
            newResult = Integer.parseInt(result);
        } else if (result.equals("no")){
            calculator.cleanResult();
        } else {
            System.out.println("Wrong input." + "\n" +
                                "Try again");
        }
    }


    public boolean checkInputForNumbers(char [] checkArgs) {
        for (Character number : checkArgs) {
            if (Character.isDigit(number)) {
                isNumber = true;
            }
        }
        return isNumber;
    }


    public boolean getIsClosed() {
        return this.isClose;
    }


    public int[] getArgs() {
        return this.args;
    }
}
