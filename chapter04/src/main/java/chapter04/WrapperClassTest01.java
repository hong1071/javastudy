package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		//Auto Boxing - 자동으로 값을 만들어준다.
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		
		// Auto Unboxing - 자동으로 값을 불러와준다.
		//int m = j1.intValue() + 10;
		int m = j1 + 10;

	}

}
