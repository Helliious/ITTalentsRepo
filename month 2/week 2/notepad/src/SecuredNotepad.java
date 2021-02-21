import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad {
    private final String password;

    SecuredNotepad(String password, int numberOfPages) {
        super(numberOfPages);
        if (!isSecure(password)) {
            throw new IllegalArgumentException(
                    "Password must be of size at least 5 and contain" +
                            " small letter, big letter and a number");
        }
        this.password = password;
    }

    boolean isSecure(String password) {
        int countSmallChars = 0;
        int countBigChars = 0;
        int countNumbers = 0;
        if (password.length() < 5) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                countSmallChars++;
            }
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                countBigChars++;
            }
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                countNumbers++;
            }
        }

        if (countSmallChars > 0 &&
        countBigChars > 0 &&
        countNumbers > 0) {
            return true;
        } else {
            return false;
        }
    }

    String enterPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        return sc.nextLine();
    }

    boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public void addTextOnPage(String text, int pageNumber) {
        if (checkPassword(enterPassword())) {
            super.addTextOnPage(text, pageNumber);
        } else {
            System.out.println("Wrong password!");
        }
    }

    @Override
    public void replaceTextOnPage(String text, int pageNumber) {
        if (checkPassword(enterPassword())) {
            super.replaceTextOnPage(text, pageNumber);
        } else {
            System.out.println("Wrong password!");
        }
    }

    @Override
    public void delTextOnPage(int pageNumber) {
        if (checkPassword(enterPassword())) {
            super.delTextOnPage(pageNumber);
        } else {
            System.out.println("Wrong password!");
        }
    }

    @Override
    public boolean searchWord(String word) {
        boolean hasWord = false;
        if (checkPassword(enterPassword())) {
            hasWord = super.searchWord(word);
        } else {
            System.out.println("Wrong password!");
        }
        return hasWord;
    }

    @Override
    public void printAllPagesWithDigits() {
        if (checkPassword(enterPassword())) {
            super.printAllPagesWithDigits();
        } else {
            System.out.println("Wrong password!");
        }
    }

    @Override
    public void printPages() {
        if (checkPassword(enterPassword())) {
            super.printPages();
        } else {
            System.out.println("Wrong password!");
        }
    }
}
