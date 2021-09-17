package prob01;

public class Printer {

//	public void println(Object object) {
//		System.out.println(object);
//	}
	
	public <T>/*generic type*/ void println(T t) {
		System.out.println(t);
	}
	
	//가변과 제네릭 메소드를 합침!
	public <T>/*generic type*/ void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}
	
	//가변 수를 받아 내는 방법
	public int sum(Integer... nums) {
		int sum = 0;
		for (Integer i : nums) {
			sum += i;
		}
		return sum;
	}
}
