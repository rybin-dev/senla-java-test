package hangman;

import java.util.List;
import java.util.Random;

public class Words {
    private final Random rand = new Random();
    private final List<String> words = List.of("арахнология",
            "арбалет",
            "арбалетчик",
            "арбитр",
            "арбитраж",
            "арболит",
            "арбуз",
            "арбузик",
            "арбузище",
            "аргал");
    public String getRandomWord() {
        return words.get(rand.nextInt(words.size()));
    }
}
