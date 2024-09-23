package Lab1.Task7;


public class ForWork {

    public static void main(String[] args) {
        try {
            Bank bank1 = new Bank("BankofAmerica");
            Bank bank2 = new Bank("Wright-Patt");

            User user1 = new User("Jorge");
            User user2 = new User("Jeremy");

            BankAccount acc1 = new BankAccount("111111", bank1, "USD", 1000);
            BankAccount acc2 = new BankAccount("222222", bank1, "USD", 500);
            BankAccount acc3 = new BankAccount("333333", bank2, "EUR", 2000);
            BankAccount acc4 = new BankAccount("444444", bank2, "EUR", 1500);

            user1.addAccount(acc1);
            user1.addAccount(acc2);
            user2.addAccount(acc3);
            user2.addAccount(acc4);

            Transiaction transaction = new Transiaction();

            printBalances(user1);
            printBalances(user2);

            performTransfer(acc1, acc2, 100, transaction);
            performTransfer(acc1, acc3, 200, transaction);
            performTransfer(acc1, acc4, 50, transaction);
            performTransfer(acc3, acc4, 300, transaction);

            printBalances(user1);
            printBalances(user2);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void printBalances(User user) {
        System.out.println("User: " + user.getName());
        for (BankAccount acc : user.getAccounts()) {
            System.out.println("Account " + acc.getAccountNumber() + ": " + acc.getBalance() + " " + acc.getCurrency());
        }
    }

    private static void performTransfer(BankAccount from, BankAccount to, double amount, Transiaction transaction) {
        boolean success = transaction.transfer(from, to, amount);
        String result;

        if (success) {
            result = "successful";
        } else {
            result = "failed";
        }

        System.out.println("Transfer of " + amount + " " + from.getCurrency() + " from " + from.getAccountNumber() + " to " + to.getAccountNumber() + " was " + result);
    }
}
