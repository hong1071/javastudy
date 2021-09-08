package chapter03;

import myPakage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		
		Goods2 g2 = new Goods2();
		
		// 접근자 public은 접근 제한 없음
		g2.name = "camera";
		
		// 접근자 protected는 동일 패키지 내에서 접근 가능
		// 자식 클래스에서도 접근이 가능
//		g2.price = 100;
		
		// 접근자 default는 동일 패키지 내에서 접근 가능
//		g2.countStock = 10;
		
		// 접근자 private는 같은 패키지 내에서 접근 가능, 현재 접근 불가
		//g2.countSold = 10;
	}

}

