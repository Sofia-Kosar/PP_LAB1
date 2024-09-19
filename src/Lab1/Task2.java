package Lab1;

import java.util.Scanner;

public class Task2 {

        /*public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введіть вираз: ");
            String expr = sc.nextLine();
            sc.close();

            try {
                String cleanExpr = cleanUp(expr);
                double res = evaluate(cleanExpr);
                System.out.println("Результат: " + res);
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        private static String cleanUp(String expr) {
            expr = expr.replace("=", "");
            expr = expr.replace("?", "");
            return expr.trim();
        }

        private static double evaluate(String expr) {
            String[] parts = expr.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Невірний формат виразу.");
            }

            String n1Str = parts[0];
            String op = parts[1];
            String n2Str = parts[2];

            double n1;
            double n2;

            try {
                n1 = Double.parseDouble(n1Str);
                n2 = Double.parseDouble(n2Str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Невірні числа.");
            }

            switch (op) {
                case "+":
                    return n1 + n2;
                case "-":
                    return n1 - n2;
                case "*":
                    return n1 * n2;
                case "/":
                    if (n2 == 0) {
                        throw new IllegalArgumentException("Ділення на нуль.");
                    }
                    return n1 / n2;
                default:
                    throw new IllegalArgumentException("Невідомий оператор.");
            }
        }*/


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть вираз: ");
        String input = scanner.nextLine();
        scanner.close();

        String cleanedInput = cleanExpression(input);
        double result = calculate(cleanedInput);
        System.out.println("Результат: " + result);
    }

    private static String cleanExpression(String expr) {
        expr = expr.replace("=", "");
        expr = expr.replace("?", "");
        return expr.trim();
    }

    private static double calculate(String expr) {
        String[] parts = expr.split(" ");
        if (parts.length != 3) {
            System.out.println("Помилка: Невірний формат виразу.");
            return Double.NaN;
        }

        double num1 = parseNumber(parts[0]);
        double num2 = parseNumber(parts[2]);
        char operator = parts[1].charAt(0);

        return performOperation(num1, num2, operator);
    }

    private static double parseNumber(String numStr) {
        try {
            return Double.parseDouble(numStr);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: Невірне число.");
            return Double.NaN;
        }
    }

    private static double performOperation(double num1, double num2, char op) {
        if (op == '+') return num1 + num2;
        if (op == '-') return num1 - num2;
        if (op == '*') return num1 * num2;
        if (op == '/') {
            if (num2 == 0) {
                System.out.println("Помилка: Ділення на нуль.");
                return Double.NaN;
            }
            return num1 / num2;
        }
        System.out.println("Помилка: Невідомий оператор.");
        return Double.NaN;
    }
}
