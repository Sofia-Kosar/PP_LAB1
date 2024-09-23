package Lab1.Task7;

public class ForWork {

    public static void main(final String[] args) {
        try {

            final Bank bank1 = new Bank("Privat");
            final Bank bank2 = new Bank("Mono");
            final User user1 = new User("Sofiia");
            final User user2 = new User("Khrystyna");


            final Account account1 = new Account("123456", bank1, "USD", 90);
            final Account account2 = new Account("227522", bank1, "USD", 1000);
            final Account account3 = new Account("339933", bank2, "ESD", 200);
            final Account account4 = new Account("444124", bank2, "EUR", 900);


            user1.addAccount(account1);
            user1.addAccount(account2);
            user2.addAccount(account3);
            user2.addAccount(account4);


            final Transiaction transiactionProcessor = new Transiaction();


            printBalance(user1);
            printBalance(user2);


            doTransfer(account1, account2, 90, transiactionProcessor);
            doTransfer(account1, account3, 70, transiactionProcessor);
            doTransfer(account1, account4, 88, transiactionProcessor);
            doTransfer(account3, account4, 30, transiactionProcessor);


            printBalance(user1);
            printBalance(user2);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
    }


    private static void printBalance(final User user) {
        System.out.println("User: " + user.getName());
        for (final Account account : user.getAccounts()) {
            System.out.println("Balance of Account " + account.getAccountNumber() + ": " + account.getBalance() + " " + account.getCurrency());
        }
    }


    private static void doTransfer(final Account fromAccount, final Account toAccount, final double amount, final Transiaction transiactionProcessor) {
        if (transiactionProcessor.transfer(fromAccount, toAccount, amount)) {
            System.out.println("Transfer of " + amount + " " + fromAccount.getCurrency() + " from acc " + fromAccount.getAccountNumber() +
                    " to acc " + toAccount.getAccountNumber() + " was successful.");
        } else {
            System.out.println("Transfer of " + amount + " " + fromAccount.getCurrency() + " from acc " + fromAccount.getAccountNumber() +
                    " to acc " + toAccount.getAccountNumber() + " failed.");
        }
    }
}
