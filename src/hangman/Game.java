package hangman;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private static final int MAX_MISTAKES = 6;

    private final List<String> word;
    private final Set<String> attemptedLetters;
    private int mistakeCount = MAX_MISTAKES;

    private final Scanner scanner;

    public Game(String word) {
        this.word = Arrays.asList(word.toLowerCase().split("|"));
        this.attemptedLetters = new LinkedHashSet<>();
        this.scanner =  new Scanner(System.in);;
    }

    public void play() {
        while (mistakeCount > 0) {
            printGallows();
            print("Ошибки: " + mistakeCount);
            print("Слово: " + getMaskedWord());
            print(String.join(", ", attemptedLetters));

            var ch = input();
            if (!word.contains(ch)) {
                mistakeCount--;
            }
            attemptedLetters.add(ch);
            if (isWordGuessed()){
                print("Поздравляем! Вы отгадали слово: " + getHiddenWord());
                return;
            }
            print("");
        }
        printGallows();
        print("Вы проиграли. Загаданное слово: " + getHiddenWord());
    }

    private void printGallows() {
        print("*****Виселица*****");
        print(Sprites.values()[mistakeCount].value);
    }

    private String input() {
        String ch;
        while (true) {
            print("Введите букву: ");
            ch = scanner.nextLine().toLowerCase();
            if (!ch.matches("[а-яё]")) {
                print("Недопустимый символ: " + ch);
                continue;
            }
            if (attemptedLetters.contains(ch)){
                print("Буква уже использовалась");
                continue;
            }
            break;
        }

        return ch;
    }

    private void print(String msg) {
        System.out.println(msg);
    }

    private boolean isWordGuessed() {
        return attemptedLetters.containsAll(word);
    }

    private String getHiddenWord() {
        return String.join("", word);
    }

    private String getMaskedWord() {
        return word.stream()
                .map(c -> attemptedLetters.contains(c) ? c : "_")
                .collect(Collectors.joining());
    }
}
