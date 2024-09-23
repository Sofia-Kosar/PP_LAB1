package Lab1.Task7;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<Account> accounts = new ArrayList<>();

    public User(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(final Account account) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(account.getAccountNumber())) {
                throw new IllegalArgumentException("Account number must be unique");
            }
        }
        accounts.add(account);
    }
}