package Lab1.Task7;
import Lab1.Task7.Bank;


import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static final List<String> accountNumbers = new ArrayList<>();

    private final String accountNumber;
    private final Bank bank;
    private final String currency;
    private double balance;

    public BankAccount(String accountNumber, Bank bank, String currency, double initialBalance) {
        if (accountNumbers.contains(accountNumber)) {
            throw new IllegalArgumentException("Account number must be unique");
        }
        accountNumbers.add(accountNumber);
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.currency = currency;
        this.balance = initialBalance;
    }

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

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
