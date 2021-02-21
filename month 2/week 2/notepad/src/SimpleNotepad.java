public class SimpleNotepad implements INotepad {
    private final Page[] pages;

    SimpleNotepad(int numberOfPages) {
        pages = new Page[numberOfPages];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = new Page("Page " + (i + 1));
        }
    }

    @Override
    public void addTextOnPage(String text, int pageNumber) {
        if (pageNumber > pages.length) {
            System.out.println("Invalid page!");
        } else {
            pages[pageNumber].addText(text);
        }
    }

    @Override
    public void replaceTextOnPage(String text, int pageNumber) {
        if (pageNumber > pages.length) {
            System.out.println("Invalid page!");
        } else {
            pages[pageNumber].delText();
            pages[pageNumber].addText(text);
        }
    }

    @Override
    public void delTextOnPage(int pageNumber) {
        if (pageNumber > pages.length) {
            System.out.println("Invalid page!");
        } else {
            pages[pageNumber].delText();
        }
    }

    @Override
    public boolean searchWord(String word) {
        boolean hasWord = false;
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] != null && pages[i].searchWord(word)) {
                hasWord = true;
            }
        }
        return hasWord;
    }

    @Override
    public void printAllPagesWithDigits() {
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] != null && pages[i].containsDigits()) {
                pages[i].viewPage();
            }
        }
    }

    @Override
    public void printPages() {
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] != null) {
                System.out.println(pages[i].viewPage());
            }
        }
    }
}
