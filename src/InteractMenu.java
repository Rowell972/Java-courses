import java.util.Scanner;

/**
 * Class Класс представляющий собой интерактивное(консольное) меню для взаимодействия с пользователем.
 * @author Kovalev
 * @since 13.08.2019
 * @version 1
 */
public class InteractMenu {


    /**
     * Основной набор переменных для работы с калькулятором
     * отдельное упоминание для переменной answer - она служит ответом пользователя,
     * для сохранения результата предыдущего вычисления.
     */
    private String exit;
    private String operand;
    private String firstArgument;
    private String secondArgument;
    private String answer;
    private int result;
    private Scanner scanner = new Scanner(System.in);


    /**
     * Константа определяющая максимальное количество аргументов.
     */
    private final int COUNT_OF_ARGS = 2;
    private int [] args = new int[COUNT_OF_ARGS ];
    private char [] checkArgs = args.toString().toCharArray();


    /**
     * Метка определяющая число входящий параметр или нет.
     */
    private boolean isNumber = false;


    /**
     * Метка устанавливающая завершение программы.
     */
    private boolean isClose = false;


    /**
     * Метка определяющая сохранён ли результат предыдущего вычисления.
     */
    private boolean isSave = false;
    private Calculator calculator;


    /**
     * Метод с которого начинается взаимодействие с пользователем.
     * Просит ввести два аргумента при условии если isSave = false,
     * иначе подразумевается, что результат предыдущего вычисления сохранён в первый аргумент.
     */
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


    /**
     * Метод проводящий основные четыре математические аргументы.
     * Перед своей работой вызывает метод для проверки ввода пользователя.
     * @param args Массив введённых пользователем аргументов.
     */
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


    /**
     * Метод отвечающий за прекращение работы калькулятора.
     */
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


    /**
     * Метод отвечающий за сохранение результата предыдущего вычисления
     * и его использование в дальнейших расчётах.
     */
    private void saveResult() {
        System.out.println("Do you wanna save result? (yes/no)");
        answer = scanner.next();
        if (answer.equals("yes")) {
            isSave = true;
            result = calculator.getResult();
        } else if (answer.equals("no")){
            isSave = false;
            calculator.cleanResult();
        } else {
            System.out.println("Wrong input." + "\n" +
                                "Try again");
        }
    }


    /**
     * Метод для проверки ввода пользователя.
     * Проверяет является ли введённое значение числом.
     * @param checkArgs Принимает массив знаков, для которых вызывается
     *                  метод проверки на число.
     * @return isNumber Возвращает метку указывающую на то,
     *                  является ли ввод числом или нет.
     */
    private boolean checkInputForNumbers(char [] checkArgs) {
        for (Character number : checkArgs) {
            if (Character.isDigit(number)) {
                isNumber = true;
            }
        }
        return isNumber;
    }


    /**
     * Метод возвращающий значение метки-завершения работы калькулятора.
     * @return isClose метка прекращения работы программы.
     */
    public boolean getIsClosed() {
        return this.isClose;
    }


    /**
     * Метод возвращающий значение массива аргументов для вызывающей части кода.
     * @return args Массив аргументов.
     */
    public int[] getArgs() {
        return this.args;
    }
}
