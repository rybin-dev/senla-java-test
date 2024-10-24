package generator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*****Генератор паролей*****");
            System.out.println("Введите длину пароля (4-12): ");
            System.out.println("exit для завершения");
            var input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int length = Integer.parseInt(input);

                if (length < 4 || length > 12) {
                    System.out.println("Ошибка");
                    continue;
                }

                System.out.println("Пароль: " + PasswordGenerator.generate(length));

            } catch (NumberFormatException e) {
                System.out.println("Ошибка");
            }
        }
    }
}
