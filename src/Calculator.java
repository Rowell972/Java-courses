public class Calculator {

	private int result = 0;


	public void add(int ... params) {
		if (params.length > 0) {
			this.result = params[0];
			for (int index = 1; index != params.length ; index++) {
				this.result += params[index];
			}
		}
	}
	
	public void sub(int ... params) {
		if (params.length > 0) {
			this.result = params[0];
			for (int index = 1; index != params.length ; index++) {
				this.result -= params[index];
			}
		}
	}
	
	public void mult(int ... params) {
		if (params.length > 0) {
			this.result = params[0];
			for (int index = 1; index != params.length ; index++) {
				this.result *= params[index];
			}
		}
	}
	
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


	public int getResult() {
		return this.result;
	}


	public void cleanResult() {
		this.result = 0;
	}
}