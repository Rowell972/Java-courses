
public class Calculator {
	
	private int result = 0;
	
	
	public void add(int ... params) {
		for	(Integer param : params) {
			result += param;
		}
	}
	
	
	public int getResult() {
		return this.result;
	}
	
	
	public void cleanResult() {
		this.result = 0;
	}
}
