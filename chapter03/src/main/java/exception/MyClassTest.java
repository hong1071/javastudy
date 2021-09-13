package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {

		try {
			MyClass myClass = new MyClass();
			myClass.danger();
		} catch (Exception e) {			// 모든 Exception을 받을 수 있음. but, 좋은 코드는 아님.
			System.out.println("error : " + e);
		}
	}

}
