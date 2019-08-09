public class Calculator {

	private int result = 0;


	public void add(int ... params) {
		for	(Integer param : params) {
			result += param;
		}
	}
	
	public void sub(int ... params) {
		result = params[0] - params[1];
	}
	
	public void mult(int ... params) {
		result = params[0] * params[1];
	}
	
	public void div(int ... params) {
		result = params[0] / params[1];
	}


	public int getResult() {
		return this.result;
	}


	public void cleanResult() {
		this.result = 0;
	}
}