package generator;

import java.util.Random;

public class PasswordGenerator {
    private static final Random RANDOM = new Random();
    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    private static final String ALL_CHARACTERS = UPPER_CASE_LETTERS + LOWER_CASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;

    public static String generate(int length) {
        assert length >= 4;

        var password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = (randomChar(ALL_CHARACTERS));
        }

        password[RANDOM.nextInt(length)] = randomChar(UPPER_CASE_LETTERS);
        password[RANDOM.nextInt(length)] = randomChar(LOWER_CASE_LETTERS);
        password[RANDOM.nextInt(length)] = randomChar(DIGITS);
        password[RANDOM.nextInt(length)] = randomChar(SPECIAL_CHARACTERS);

        return String.valueOf(password);
    }

    private static char randomChar(String characters) {
        return characters.charAt(RANDOM.nextInt(characters.length()));
    }
}
