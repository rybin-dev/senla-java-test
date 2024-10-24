package exchanger;

import java.util.Arrays;
import java.util.Scanner;

public class Exchanger {
    private final Scanner scanner;

    public Exchanger() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            print("*****Обменник*****");
            print("Доступные валюты: " + Arrays.toString(Rates.values()));
            print("exit для завершения");

            print("Введите код исходной валюты: ");
            var from = getCurrencyRate();

            print("Введите код целевой валюты: ");
            var to = getCurrencyRate();

            print("Введите количество валюты: ");
            var amount = getAmount();

            var convertedAmount = getConvertedAmount(amount, from, to);

            print(String.format("%.3f %s = %.3f %s", amount, from, convertedAmount, to));
        }
    }

    private double getConvertedAmount(double amount, Rates from, Rates to) {
        return amount * (to.rate / from.rate);
    }

    private double getAmount() {
        while (true) {
            try {
                return Double.parseDouble(input());
            } catch (NumberFormatException e) {
                print("Ошибка. Введите число");
            }

        }
    }

    private Rates getCurrencyRate() {
        while (true) {
            var currencyCode = input().toUpperCase();
            try {
                return Rates.valueOf(currencyCode);
            } catch (IllegalArgumentException e) {
                print("Код валюты не найден: " + currencyCode);
                print("Введите код валюты");
            }
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String input() {
        var line = scanner.nextLine().trim();

        if ("exit".equalsIgnoreCase(line)) {
            System.exit(0);
        }

        return line;
    }
}
