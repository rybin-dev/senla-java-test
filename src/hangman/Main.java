package hangman;

public class Main {

    public static void main(String[] args) {
        var words = new Words();
        new Game(words.getRandomWord()).play();
    }
}
