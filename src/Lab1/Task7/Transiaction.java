package Lab1.Task7;
import Lab1.Task6.Convertor;


public class Transiaction {
    private static final double SA_BANK_INT = 0.0;
    private static final double DIF_BANK_INT = 0.02;
    private static final double SA_BANK_EXT = 0.03;
    private static final double DIF_BANK_EXT = 0.06;

    public boolean transfer(final BankAccount fromAccount, final BankAccount toAccount, final double amount) {
        if (fromAccount == null) {
            throw new IllegalArgumentException("Потрібно 2 акаунти");
        }
        if (toAccount == null) {
            throw new IllegalArgumentException("E");
        }

        double fee = calculateFee(fromAccount, toAccount, amount);

        if (fromAccount.withdraw(amount + fee)) {
            double convertedAmount = convertAmount(amount, fromAccount.getCurrency(), toAccount.getCurrency());
            return toAccount.deposit(convertedAmount);
        } else {
            return false;
        }

    }

    private double convertAmount(final double amount, final String fromCurrency, final String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }
        String input = amount + " " + fromCurrency + " into " + toCurrency;
        Convertor converter = new Convertor();
        return converter.convertCurrency(input);
    }

    private double calculateFee(final BankAccount fromAccount, final BankAccount toAccount, final double amount) {
        if (fromAccount.getBank().equals(toAccount.getBank())) {
            if (fromAccount.getAccountNumber().equals(toAccount.getAccountNumber())) {
                return SA_BANK_INT * amount;
            } else {
                return SA_BANK_EXT * amount;
            }
        } else {
            if (fromAccount.getAccountNumber().equals(toAccount.getAccountNumber())) {
                return DIF_BANK_INT * amount;
            } else {
                return DIF_BANK_EXT * amount;
            }
        }
    }
}
