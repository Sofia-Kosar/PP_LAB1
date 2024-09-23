package Lab1.Task6;
import java.util.Scanner;

public class Convertor {
    private static final double UAH_TO_USD = 0.02418;
    private static final double USD_TO_UAH = 41.34;
    private static final double UAH_TO_EUR = 0.02185;
    private static final double EUR_TO_UAH = 45.77;
    private static final double UAH_TO_CAD = 0.03306;
    private static final double CAD_TO_UAH = 30.24;
    private static final double USD_TO_EUR = 0.903;
    private static final double EUR_TO_USD = 1.107;
    private static final double USD_TO_CAD = 1.367;
    private static final double CAD_TO_USD = 0.731;
    private static final double EUR_TO_CAD = 1.513;
    private static final double CAD_TO_EUR = 0.661;

    public double convertCurrency(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Введіть щось у форматі '100 UAH into USD'");
        }

        final String[] parts = input.split(" ");
        if (parts.length != 4 ) {
            throw new IllegalArgumentException("Невірний формат. Потрібно '100 UAH into USD'");
        }

        final double amount;
        try {
            amount = Double.parseDouble(parts[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Перша частина має бути числом");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Сума не може бути від'ємною");
        }

        final String fromCurrency = parts[1].toUpperCase();
        final String toCurrency = parts[3].toUpperCase();

        return calculateConversion(amount, fromCurrency, toCurrency);
    }

    private double calculateConversion(final double amount, final String fromCurrency, final String toCurrency) {
        String conversionKey = fromCurrency + "to" + toCurrency;

        switch (conversionKey) {
            case "UAHtoUSD":
                return amount * UAH_TO_USD;
            case "USDtoUAH":
                return amount * USD_TO_UAH;
            case "UAHtoEUR":
                return amount * UAH_TO_EUR;
            case "EURtoUAH":
                return amount * EUR_TO_UAH;
            case "UAHtoCAD":
                return amount * UAH_TO_CAD;
            case "CADtoUAH":
                return amount * CAD_TO_UAH;
            case "USDtoEUR":
                return amount * USD_TO_EUR;
            case "EURtoUSD":
                return amount * EUR_TO_USD;
            case "USDtoCAD":
                return amount * USD_TO_CAD;
            case "CADtoUSD":
                return amount * CAD_TO_USD;
            case "EURtoCAD":
                return amount * EUR_TO_CAD;
            case "CADtoEUR":
                return amount * CAD_TO_EUR;
            default:
                throw new IllegalArgumentException("Невідома конверсія валюти");
        }
    }

}
