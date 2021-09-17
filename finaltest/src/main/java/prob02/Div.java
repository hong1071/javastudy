package prob02;

public class Div implements Arithmetic{

	private int result;
	
	@Override
	public int calculate(int a, int b) {
		result = a / b;
		return result;
	}

}
