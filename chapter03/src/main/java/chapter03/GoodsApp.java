package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		
		Goods goods = new Goods();
		goods.setName("nikon");
		goods.setPrice(400000);
		goods.setCountStock(10);
		goods.setCountSold(20);
		
		goods.showInfo();
		
		goods.setPrice(-1);
		
		int discountPrice = goods.calcDiscountPrice(5);
		
		System.out.println(discountPrice);
		
		System.out.println(Goods.countOfGoods);
		
		String s = "콜라 1000 20";
		String[] tokens = s.split(" ");
		
		for(String str : tokens) {
			System.out.println(str);
		}
		
	}

}
