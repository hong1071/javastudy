package chapter03;

public class Goods {
	
	public static int countOfGoods = 0;

	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		this.countOfGoods++;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		if(price<0) {
			return;
		}
		this.price = price;
	}
	
	public int getCountStock() {
		return countStock;
	}
	
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public int getCountSold() {
		return countSold;
	}
	
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public static int getCountOfGoods() {
		return countOfGoods;
	}

	public static void setCountOfGoods(int countOfGoods) {
		Goods.countOfGoods = countOfGoods;
	}
	
	public void showInfo() {
		System.out.println("상품 이름 : " + name);
		System.out.println("상품 가격 : " + price);
		System.out.println("상품 재고 : " + countStock);
		System.out.println("상품 판매량 : " + countSold);
		System.out.println("countOfGoods : " + countOfGoods);
		
	}
	
	public int calcDiscountPrice(int percentage) {
		return price * percentage / 100;
	}
}
