package postoffices;

import deliverables.Letter;

import java.util.LinkedList;
import java.util.List;

public class Mailbox {
    private final List<Letter> letters;

    public Mailbox() {
        letters = new LinkedList<>();
    }

    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    public boolean isEmpty() {
        return letters.isEmpty();
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public int getLettersCount() {
        return letters.size();
    }
}
