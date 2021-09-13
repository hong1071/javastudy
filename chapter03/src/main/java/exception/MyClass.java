package exception;

import java.io.IOException;

public class MyClass {

	public void danger() throws IOException, MyException {
		System.out.println("some codes1...");
		System.out.println("some codes2...");
		
		//MyException 던지기
		if(5-5 == 0) {
			throw new MyException();
		}
		
		//예외 던지기
		if(10-10 == 0) {
		throw new IOException();
		}
		
		System.out.println("some codes3...");
		System.out.println("some codes4...");
	}
}
