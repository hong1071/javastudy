package exception;

public class UncheckedExceptionTest {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		for(int i = 0; i <= a.length; i++) {
			System.out.println(a[i]);			//이것은 논리적 오류: 5개 이상의 숫자를 print
		}

	}

}
