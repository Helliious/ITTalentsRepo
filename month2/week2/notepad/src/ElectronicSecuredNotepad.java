public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {
    private boolean isStarted;

    ElectronicSecuredNotepad(String password, int numberOfPages) {
        super(password, numberOfPages);
        isStarted = false;
    }

    @Override
    public void start() {
        isStarted = true;
    }

    @Override
    public void stop() {
        isStarted = false;
    }

    @Override
    public void addTextOnPage(String text, int pageNumber) {
        if (isStarted) {
            super.addTextOnPage(text, pageNumber);
        } else {
            System.out.println("Notepad is not turned on!");
        }
    }

    @Override
    public void replaceTextOnPage(String text, int pageNumber) {
        if (isStarted) {
            super.replaceTextOnPage(text, pageNumber);
        } else {
            System.out.println("Notepad is not turned on!");
        }
    }

    @Override
    public void delTextOnPage(int pageNumber) {
        if (isStarted) {
            super.delTextOnPage(pageNumber);
        } else {
            System.out.println("Notepad is not turned on!");
        }
    }

    @Override
    public boolean searchWord(String word) {
        if (isStarted) {
            return super.searchWord(word);
        } else {
            System.out.println("Notepad is not turned on!");
            return false;
        }
    }

    @Override
    public void printAllPagesWithDigits() {
        if (isStarted) {
            super.printAllPagesWithDigits();
        } else {
            System.out.println("Notepad is not turned on!");
        }
    }

    @Override
    public void printPages() {
        if (isStarted) {
            super.printPages();
        } else {
            System.out.println("Notepad is not turned on!");
        }
    }
}
