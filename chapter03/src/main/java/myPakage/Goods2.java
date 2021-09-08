package myPakage;

public class Goods2 {

	public String name;				// 모두 접근 가능(접근 제한이 없다.)
	protected int price;			// 같은 패키지 + **자식 접근 가능 
	int countStock;					// default, 같은 패키지에서만 접근 가능
	private int countSold;			// 클래스 내부에서만 접근가능
	
	void m() {
		countSold = 100;
	}
}
