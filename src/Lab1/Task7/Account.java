package Lab1.Task7;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private static final List<String> accountNumbers = new ArrayList<>();

    private final String accountNumber;
    private final Bank bank;
    private final String currency;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }
    public Account(final String accountNumber, final Bank bank, final String currency, final double initialBalance) {
        if (accountNumbers.contains(accountNumber)) {
            throw new IllegalArgumentException("It is not a unique");
        }
        accountNumbers.add(accountNumber);
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.currency = currency;
        this.balance = initialBalance;
    }



    public void deposit(final double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit can't be less than 0");
        }
    }

    public boolean thesame(final double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
