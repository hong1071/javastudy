package prob02;

public class Sub implements Arithmetic{

	private int result;
	
	@Override
	public int calculate(int a, int b) {
		result = a - b;
		return result;
	}
}
