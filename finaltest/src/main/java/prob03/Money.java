package prob03;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}
	
	public Money add(Money money) {
		int result = amount + money.amount;
		
		return new Money(result);
	}
	
	public Money minus(Money money) {
		int result = amount - money.amount;
		
		return new Money(result);
	}
	
	public Money multiply(Money money) {
		int result = amount * money.amount;
		
		return new Money(result);
	}
	
	public Money devide(Money money) {
		int result = amount / money.amount;
		
		return new Money(result);
	}
	
	public boolean equals(Money money) {
		boolean result = false;
		if(money instanceof Money) {
			if(this.amount == money.amount) {
				result = true;
			}
			if(this.amount != money.amount) {
				result = false;
			}
		}
		else {
			result = false;
		}
		
		return result;
	}
}
