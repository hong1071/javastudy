package prob05;

public class Account {
	
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int save(int money) {
		this.balance += money;
		return this.balance;
	}
	
	public int deposit(int money) {
		this.balance -= money;
		return this.balance;
	}
}
