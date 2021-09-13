package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		//
		int j;
		int k;
		int l;
		
		for(int a = 0; a<count;a++) {
		
			for(int i = 0;i<count-1;i++) {
				j = array[i];
				k = array[i+1];
				l = 0;
				
				if(j<k) {
					
					l = j;
					array[i] = k;
					array[i+1] = l;
				}
			}
		}
		
		
		System.out.println();

		
		// 결과 출력
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}