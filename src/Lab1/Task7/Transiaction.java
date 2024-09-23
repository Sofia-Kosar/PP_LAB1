package Lab1.Task7;
import Lab1.Task6.Convertor;


public class Transiaction {
    private static final double INTERNAL_TRANSFER_SAME_USER = 0.0;
    private static final double INTERBANK_TRANSFER_SAME_USER = 0.02;
    private static final double INTERNAL_TRANSFER_DIFF_USER = 0.03;
    private static final double INTERBANK_TRANSFER_DIFF_USER = 0.06;


    private final Convertor convertor = new Convertor();

    private double determineTransferFee(final Account fromAccount, final Account toAccount, final double amount) {
        boolean sameBank = fromAccount.getBank().equals(toAccount.getBank());
        boolean sameUser = fromAccount.getAccountNumber().equals(toAccount.getAccountNumber());

        if (sameBank && sameUser) {
            return INTERNAL_TRANSFER_SAME_USER * amount;
        } else if (sameBank) {
            return INTERNAL_TRANSFER_DIFF_USER * amount;
        } else if (sameUser) {
            return INTERBANK_TRANSFER_SAME_USER * amount;
        } else {
            return INTERBANK_TRANSFER_DIFF_USER * amount;
        }
    }
    public boolean transfer(final Account fromAccount, final Account toAccount, final double amount) {
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("There must be both acc");
        }

        final double convertedAmount = convertAmount(amount, fromAccount.getCurrency(), toAccount.getCurrency());
        final double fee = determineTransferFee(fromAccount, toAccount, amount);

        if (fromAccount.thesame(amount + fee)) {
            toAccount.deposit(convertedAmount);
            return true;
        } else {
            return false;
        }
    }

    private double convertAmount(final double amount, final String fromCurrency, final String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }
        final String input = amount + " " + fromCurrency + " into " + toCurrency;
        return convertor.convertCurrency(input);
    }


}