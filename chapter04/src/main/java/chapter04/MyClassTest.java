package chapter04;

public class MyClassTest {

	public static void main(String[] args) {
		//MyClass myClass0 = new MyClass();
		
		//객체는 1개, 생성자가 1개만 만들어진다.
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		MyClass myClass3 = MyClass.getInstance();
		MyClass myClass4 = MyClass.getInstance();
		MyClass myClass5 = MyClass.getInstance();
		MyClass myClass6 = MyClass.getInstance();
		MyClass myClass7 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);
	}

}
