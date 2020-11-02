package classstructureintegrate;

public class BankAccount {
    private String accountName;
    private String owner;
    private int balance;

    public BankAccount (String accountName, String owner, int balance) {
        this.accountName = accountName;
        this.owner = owner;
        this.balance = balance;
    }

    public void transit (BankAccount target, int ammount) {
        this.balance = balance - ammount;
        target.balance = target.balance + ammount;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getOwner() {
        return owner;
    }
}
