package prob03;

public class Prob03 {
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);
		
		String a = "Hello World";
		System.out.println(a.length());
	}

	private static void replaceSpace(char[] c) {
		
		String str = String.valueOf(c);
		str = str.replace(" ", ",");
		System.out.println(str);		
	}

	private static void printCharArray(char[] c) {
		System.out.println(c);
		
	}

}
