package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str = "hello world";
		String[] array_word = str.split("");
		
		System.out.println("문자열을 입력하세요 : " + str);
		
		String word = null;
		for(int i=0; i<=str.length(); i++) {
			for(int j=0; i<=str.length();j++)
			System.out.println(array_word[j]);
		}

		
		String text = scanner.nextLine();

		
		scanner.close();
	}

}
