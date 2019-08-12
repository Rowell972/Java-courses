/**
 * Class Класс реализующий основную логику работы калькулятора.
 * @author Kovalev
 * @since 13.08.2019
 * @version 1
 */
public class Calculator {

	/**
	 * Переменная для хранения результат вычислений.
	 */
	private int result = 0;


	/**
	 * Метод сложения.
	 * @param params Аргументы
	 */
	public void add(int ... params) {
		if (params.length > 0) {
			this.result = params[0];
			for (int index = 1; index != params.length ; index++) {
				this.result += params[index];
			}
		}
	}


	/**
	 * Метод вычитания.
	 * @param params Аргументы
	 */
	public void sub(int ... params) {
		if (params.length > 0) {
			this.result = params[0];
			for (int index = 1; index != params.length ; index++) {
				this.result -= params[index];
			}
		}
	}


	/**
	 * Метод умножения.
	 * @param params Аргументы
	 */
	public void mult(int ... params) {
		if (params.length > 0) {
			this.result = params[0];
			for (int index = 1; index != params.length ; index++) {
				this.result *= params[index];
			}
		}
	}


	/**
	 * Метод деления.
	 * @param params Аргументы
	 */
	public void div(int ... params) {
		if (params.length > 0) {
			this.result = params[0];
			for (int index = 1; index != params.length ; ++index) {
				if (params[index] != 0) {
					this.result /= params[index];
				}
			}
		}
	}

	/**
	 * Метод возвращающий значения результата вычисления
	 * для вызывающей части кода.
	 */
	public int getResult() {
		return this.result;
	}

	/**
	 * Метод очищающий значение результата вычислений.
	 */
	public void cleanResult() {
		this.result = 0;
	}
}