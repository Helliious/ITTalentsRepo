package postoffices;

import deliverables.Letter;

import java.util.LinkedList;
import java.util.List;

public class Mailbox {
    private static int id = 0;
    private final int mailboxId;
    private final List<Letter> letters;

    public Mailbox() {
        letters = new LinkedList<>();
        mailboxId = ++id;
    }

    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    public void showLetters() {
        for (Letter l : letters) {
            l.showDelivery();
        }
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

    public int getMailboxId() {
        return mailboxId;
    }
}
