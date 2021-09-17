package prob02;

public class Mul implements Arithmetic{
	
	private int result;

	@Override
	public int calculate(int a, int b) {
		result = a * b;
		return result;
	}
}
