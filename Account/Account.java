/**
 * Created by Wina Gen Sotto; last modified on 9/21/2016
 */
public class Account{

	private int accountNumber;
	private double balance = 0.0;

	public Account(int accountNumber){
		this(accountNumber, 0.0);
	}

	public Account(int accountNumber,double balance){
		this.accountNumber = accountNumber;
		setBalance(balance);
	}

	public int getAccountNumber(){
	    return accountNumber;
	}

	public double getBalance() {
	    return balance;
	}

	public void setBalance(double balance) {
		if (balance >= 0.0) {
			this.balance = balance;
		}

		else {
			throw new IllegalArgumentException("Balance must be a non-negative value!");
		}
	}

	public void credit(double amount) {
		if (amount >= 0.0) {
			balance += amount;
		}

		else {
            throw new IllegalArgumentException("Amount must be a non-negative value!");
	    }
	}

	public void debit(double amount) {
	    if (amount <= balance) {
            balance -= amount;
	    }

	    else {
            throw new IllegalArgumentException("Amount withdrawn exceeds the current balance!");
	    }
	}

	public String toString() {
	    return String.format("A/C no: %d, Balance = $%.02f", accountNumber, balance);
	}
}
