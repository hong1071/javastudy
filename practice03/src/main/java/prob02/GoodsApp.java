package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		goods[0] = new Goods();
		goods[0].setName("콜라");
		goods[0].setPrice(1000);
		goods[0].setCountStock(10);
		
		goods[1] = new Goods();
		goods[1].setName("사이다");
		goods[1].setPrice(900);
		goods[1].setCountStock(40);
		
		goods[2] = new Goods();
		goods[2].setName("맥주");
		goods[2].setPrice(2000);
		goods[2].setCountStock(100);

		
		// 상품 출
		for(int i=0; i<goods.length; i++) {
			System.out.println(goods[i].getName() + "(가격: " + goods[i].getPrice() + "원)이 " + goods[i].getCountStock() + "개 입고 되었습니다.");
		}
		
		// 자원정리
		scanner.close();
	}
}
