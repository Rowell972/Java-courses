import java.util.Scanner;

public class InteractMenu {

    private String exit;
    private String operand;
    private String firstArgument;
    private String secondArgument;
    private String answer;
    private int result;
    private Scanner scanner = new Scanner(System.in);
    private final int COUNT_OF_ARGS = 2;
    private int [] args = new int[COUNT_OF_ARGS ];
    private char [] checkArgs = args.toString().toCharArray();
    private boolean isNumber = false;
    private boolean isClose = false;
    private boolean isSave = false;
    private Calculator calculator;


    public void startDialog() {
        if (!isSave) {
            System.out.println("Enter first argument: ");
            firstArgument = scanner.next();
            args[0] = Integer.parseInt(firstArgument);
        } else {
            firstArgument = String.valueOf(result);
            args[0] = result;
        }
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


    private void exitFromCalc() {
        System.out.println("Do you want exit? (yes/no)");
        exit = scanner.next();
        if (exit.equals("yes")) {
            isClose = true;
        } else if (exit.equals("no")){
            startDialog();
            conductOperations(args);
        } else {
            System.out.println("Wrong input." + "\n" +
                                "Try again");
        }
    }


    private void saveResult() {
        System.out.println("Do you wanna save result? (yes/no)");
        answer = scanner.next();
        if (answer.equals("yes")) {
            isSave = true;
            result = calculator.getResult();
            //startDialog();
            //conductOperations(args);
        } else if (answer.equals("no")){
            isSave = false;
            calculator.cleanResult();
            //startDialog();
            //conductOperations(args);
        } else {
            System.out.println("Wrong input." + "\n" +
                                "Try again");
        }
    }


    private boolean checkInputForNumbers(char [] checkArgs) {
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
