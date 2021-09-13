package prob04;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );

	}
	
	public static char[] reverse(String str) {
		int len = str.length();
		char[] strSplit = new char[len];
		char[] rvsStr = new char[len];
//		int[] absVal = new int[len];
		
//		for(int i=0;i<len;i++) {
//			strSplit[i] = str.charAt(i);
//			absVal[i] = Math.abs(str.length()-i-1);
//			rvsStr[i] = strSplit[absVal[i]];
//		}
		
		for(int i=0;i<len;i++) {
			strSplit[i] = str.charAt(i);
			rvsStr[len-i-1] = strSplit[i];
		}
		
		return rvsStr;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}