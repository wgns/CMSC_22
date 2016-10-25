/**
 * Created by Wina Gen Sotto
 */
public class TestAccount {
    public static void main(String[] args) {
        Account acc1 = new Account(201512009, 2000.00);
        System.out.println(acc1);

        acc1.setBalance(5000.00);
        System.out.println(acc1);
        System.out.println("Account Number: " + acc1.getAccountNumber());
        System.out.println("Balance: $" + acc1.getBalance());

        acc1.credit(500.00);
        System.out.println("New Balance: $" + acc1.getBalance());

        acc1.debit(1000.00);
        System.out.println("New Balance: $" + acc1.getBalance());

        acc1.debit(6000.00);
        System.out.println("New Balance: $" + acc1.getBalance());
    }
}
